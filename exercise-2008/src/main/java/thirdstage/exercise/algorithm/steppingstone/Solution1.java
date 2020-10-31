package thirdstage.exercise.algorithm.steppingstone;

class Solution1 {
  public int solution(int[] stones, int k) {

      final int l = stones.length;

      int min = stones[0];
      for(int i = 1; i < l; i++){
        min = Math.min(min, stones[i]);
      }

      if(k < 2) return min;

      for(int i = 0; i < l; i++){
        stones[i] = stones[i] - min;
      }

      for(int i = 0; ; i++){
          //printNumbers(i, stones);
          if(this.canSkip(stones, k)){
              for(int j = 0; j < l; j++) {
                  if(stones[j] != 0) stones[j] = stones[j] - 1;
              }
          }else{
              return min + i;
          }
      }
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
}