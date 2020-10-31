package thirdstage.exercise.algorithm.steppingstone;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

class Solution7 {

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

    final Set<Integer> passes = new HashSet<>();
    final Set<Integer> fails = new HashSet<>();
    final AtomicInteger ans = new AtomicInteger();

    final int total = q - p;
    final int z = (total < 20) ? 2 : 14;
    final int x = total/z;
    final int y = total%z;
    IntStream.range(0, x).sequential()
    .anyMatch(i -> {
      long founds = 0;
      final int[] rs = new int[z + ((i < y) ? 1 : 0)];

      for(int j = 0; j < z; j++){
        if(j < 4) rs[j] = p + j * x + i;
        else rs[j] = p + (j + 1)*x - 1 - i;
      }
      if(i < y) rs[z] = q - 1 - i;

      return IntStream.of(rs).parallel()
          .anyMatch(r -> tryFind(r, p, stones2, k2, numbers, passes, fails, ans));
    });

    return ans.get();
  }

  private boolean tryFind(
      final int r, final int p,
      final int[] stones, final int k, final int[] numbers,
      final Set<Integer> passes, final Set<Integer> fails,
      final AtomicInteger ans){

    final int l = stones.length;
    final int d = numbers[r];
    int cnt = 0;
    boolean broken = false;

    for(int i = 0; i < l; i++){
      if(stones[i] - d > 0) cnt = 0;
      else if(++cnt == k){ broken = true; break; }
    }

    boolean found = false;
    if(broken){
      if(r == p || passes.contains(numbers[r - 1])){
        ans.set(d);
        found = true;
      }else fails.add(d);
    }else {
      if(fails.contains(numbers[r + 1])){
        ans.set(numbers[r + 1]);
        found = true;
      }else passes.add(d);
    }

    return found;
  }

}