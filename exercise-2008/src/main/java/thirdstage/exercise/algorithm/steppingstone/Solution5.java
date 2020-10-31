package thirdstage.exercise.algorithm.steppingstone;

import java.util.stream.IntStream;
import java.util.*;

class Solution5 {

    public int solution(int[] stones, int k) {

        final int[] stones2 = stones;
        final int q = k;
        final int l = stones2.length;
        final int[] numbers = IntStream.of(stones2).sorted().distinct().toArray();
        //printNumbers(0, numbers);

        if(numbers.length == 1) return numbers[0];
        if(q == 1) return numbers[0];
        if(q == l) return numbers[l - 1];

        int cnt = 0, failAt = 0;
        for(int i = 0, n = numbers.length; i < n; i++){
            final int d = numbers[i];

            cnt = 0;
            for(int j = 0; j < l; j++){
                if(stones[j] - d > 0) cnt = 0;
                else if(++cnt == q){ failAt = i; break; }
            }
            if(failAt != 0) break;
        }

        int start = (failAt == 0) ? 0 : numbers[failAt - 1];
        int end = numbers[failAt];

        return end;

     }
}