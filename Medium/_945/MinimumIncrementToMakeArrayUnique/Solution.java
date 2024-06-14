package Medium._945.MinimumIncrementToMakeArrayUnique;

class Solution {
    public int minIncrementForUnique(int[] nums) {
//        int left=0;
//        int right=nums.length-1;
        int moves=0;
      for(int i=0;i< nums.length-1;i++){
          for(int j=i+1;j<=nums.length-1;j++)
           if(nums[i]==nums[j]){
              moves++;
              nums[j]++;
              i=-1;
              break;
          }
      }return moves;
    }

    public static void main(String[] args) {
        int [] arr={1,2,2};
        Solution solution=new Solution();
        int result = solution.minIncrementForUnique(arr);
        System.out.println(result);
    }
}