package thirdstage.exercise.algorithm.steppingstone;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.security.SecureRandom;

class Solution6 {

    public int solution(int[] stones, int k) {

        final int q = k;
        final int l = stones.length;
        final int[] sorted = IntStream.of(stones).sorted().toArray();
        final int[] numbers = IntStream.of(sorted).distinct().toArray();

        if(numbers.length == 1) return numbers[0];
        if(q == 1) return numbers[0];
        if(q == l) return numbers[l - 1];

        final int r = sorted[q - 1];
        final int s = Arrays.binarySearch(numbers, r);
        final int m = numbers.length;

        final int avg = (r + numbers[m - 1])/2;
        boolean left = true;
        for(int i = q; i < l; i++){
            if(sorted[i] > avg){
                if(i < 9*(q + l)/10) left = false;
                break;
            }
        }

        boolean lower = (q < 9*l/10);
        final boolean forwards = left ? lower : left;
        final List<Integer> passes = new ArrayList<>();
        final List<Integer> fails = new ArrayList<>();
        final AtomicInteger ans = new AtomicInteger();

        IntStream.range(s, m).sequential()
            .anyMatch(i -> {

            final int p = (forwards) ? i : m - 1 - i + s;
            final int d = numbers[p];
            int cnt = 0;
            boolean broken = false;

            for(int j = 0; j < l; j++){
                if(stones[j] - d > 0) cnt = 0;
                else if(++cnt == q){ broken = true; break; }
            }

            boolean result = false;
            if(broken){
                if(p == s || passes.contains(numbers[p - 1])) {
                    ans.set(d);
                    result = true;
                }else fails.add(d);
            }
            else{
                if(fails.contains(numbers[p + 1])){
                    ans.set(numbers[p + 1]);
                    result = true;
                }else passes.add(d);
            }

            return result;
        });

        return ans.get();
     }
}