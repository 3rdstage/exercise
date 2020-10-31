package thirdstage.exercise.algorithm.steppingstone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 *
 *
 *  stones    |--------------------------------------------------------------------|
 *            0                                                                  l - 1
 *
 *
 *  sorted = sort(stones) : i < j -> v[i] <= v[j]
 *
 *           v[0] v[1] v[2]                        a                           v[l - 1]
 *  sorted    |----|----|--------------------------|-------------------------------|
 *            0    1    2                        k - 1                           l - 1
 *
 *
 *  numbers = distinct(sorted) : i < j -> w[i] < w[j]
 *
 *                       w[0] w[1] w[2]                       a                w[q - 1]
 *  numbers               |----|----|-------------------------|--------|-----------|
 *                        0    1    2                         p        r         q - 1
 *
 *  narrowed values : [w[p], w[p + 1], w[p + 2], ... w[q - 1]]
 *  narrowed indexes : [p ... (q - 1)]
 *
 *  w[p] <= answer <= w[q - 1]
 *
 * @author 3rdstage
 * @since 2020. 10. 31.
 *
 */
class Solution8 {

  public int solution(int[] stones, int k) {
        final int[] stones2 = stones;
        final int k2 = k;
        final int l = stones2.length;
        final int[] sorted = IntStream.of(stones2).sorted().toArray();
        final int[] numbers = IntStream.of(sorted).distinct().toArray();

        if(numbers.length == 1) return numbers[0];
        if(k2 == 1) return numbers[0];
        if(k2 == l) return numbers[l - 1];

        final int a = sorted[k2 - 1];
        final int p = Arrays.binarySearch(numbers, a);
        final int q = numbers.length;

        // narrowing index scope to process
        final AtomicInteger ans = new AtomicInteger();
        final AtomicInteger passMax = new AtomicInteger(p - 1); // index on numbers
        final AtomicInteger failMin = new AtomicInteger(q); // index on numbers

        // shuffle narrowed index scope to process
        final List<Integer> narrowed = new ArrayList<>();
        for(int i = p; i < q; i++) narrowed.add(i);
        Collections.shuffle(narrowed);
        final int[] positions = new int[narrowed.size()];
        for(int i = 0, w = narrowed.size(); i < w ; i++) positions[i] = narrowed.get(i);
        //System.out.println(Arrays.toString(positions));

        IntStream.of(positions)
            .anyMatch(i -> {
                final int r = (q - 1) - (i - p);
                if(r < passMax.get() || r > failMin.get()) return false;

                final int d = numbers[r];
                int cnt = 0;
                boolean broken = false;

                for(int j = 0; j < l; j++){
                    if(stones2[j] - d > 0) cnt = 0;
                    else if(++cnt == k2){ broken = true; break; }
                }

                boolean found = false;
                if(broken){ // failed
                    if(r == p || (r - 1) == passMax.get()){
                        ans.set(d);
                        found = true;
                    }else failMin.updateAndGet(x -> (r < x) ? r : x);
                }else{ // passed
                    if((r + 1) == failMin.get()){
                        ans.set(numbers[r + 1]);
                        found = true;
                    }else passMax.updateAndGet(x -> (r > x) ? r : x);
                }
                return found;
            });

        return ans.get();
    }
}