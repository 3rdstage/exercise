package thirdstage.exercise.algorithm.steppingstone;

import java.util.stream.IntStream;
import java.util.*;

class Solution2 {
    public int solution(int[] stones, int k) {

        final int l = stones.length;

        final int min = IntStream.of(stones).min().getAsInt();
        if(k == 1) return min;

        final int[] numbers = IntStream.of(stones).map(x -> x - min).toArray();
        final int max = IntStream.of(stones).max().getAsInt();

        final IntStream downs = IntStream.range(0, max);

        final List<Integer> passes = new Vector<>();
        downs.forEach(d -> {
            int[] steps = (d == 0) ? IntStream.of(numbers).toArray() : IntStream.of(numbers).map(x -> (x > d) ? x - d : 0).toArray();
            //printNumbers(d, steps);

            int cnt = 0; // serial zeros
            boolean broken = false;
            for(int i = 0; i < l; i++){
                if(steps[i] != 0) cnt = 0;
                else{
                    cnt++;
                    if(cnt == k){
                        broken = true;
                        break;
                    }
                }
            }
            if(!broken){
                passes.add(d);
                //System.out.println("passed : " + d);
            }
        });

        return min + (passes.isEmpty() ? 0 : Collections.max(passes)) + 1;

    }

    private boolean canSkip(final int[] stones, final int max){
        final int l = stones.length;
        int cnt = 0;

        for(int i = 0; i < l; i++){
            if(stones[i] != 0){
                cnt = 0;
            }else{
                cnt++;
                if(cnt == max) return false;
            }
        }
        return true;
    }

    private void printNumbers(final int n, final int[] nums){
        String str = "(";
        for(int i = 0, l = nums.length; i < l; i++){
            str = str + nums[i] + ", ";
        }

        System.out.println("" + n + " - " + str + ")");
    }

}
