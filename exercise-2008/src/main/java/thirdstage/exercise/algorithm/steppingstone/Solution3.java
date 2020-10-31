package thirdstage.exercise.algorithm.steppingstone;

import java.util.stream.IntStream;
import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {

        final int l = stones.length;
        final int[] sorted = IntStream.of(stones).sorted().distinct().toArray();
        //printNumbers(0, sorted);

        final IntStream numbers = IntStream.of(stones).sorted().distinct();

        final List<Integer> passes = new Vector<>();
        final List<Integer> fails = new Vector<>();
        numbers.forEach(d -> {
            int[] steps = (d == 0) ? IntStream.of(stones).toArray() : IntStream.of(stones).map(x -> (x > d) ? x - d : 0).toArray();
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
            }else{
                fails.add(d);
            }
        });

        if(passes.isEmpty()) return Collections.min(fails);

        final int start = Collections.max(passes) + 1;
        final int end = Collections.min(fails);
        //System.out.println("" + start + ", " + end);

        if(start == end) return end;

        final IntStream counts = IntStream.range(start, end);
        fails.clear();
        counts.forEach(d -> {
            int[] steps = (d == 0) ? IntStream.of(stones).toArray() : IntStream.of(stones).map(x -> (x > d) ? x - d : 0).toArray();
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
            if(broken){
                fails.add(d);
                //System.out.println("failed : " + d);
            }
        });

        if(fails.isEmpty()) return end;
        return Collections.min(fails);
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