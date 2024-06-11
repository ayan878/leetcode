package Medium._235_Contigeous_Subsrray_Sum;

//class Solution {
//    public boolean checkSubarraySum(int[] nums, int k) {
//        int len=nums.length;
//        int sum=0;
//        for(int i=0;i<len;i++){
//
//                  if((nums[i]+nums[])%k==0){
//                      return true;
//                  }
//
//            sum+=nums[i];
//            System.out.println(sum);
//            if(sum%k==0){
//                return true;
//            }
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        int[] arr= {23,2,6,4,7};
////        {23,6,9};
//        Solution sl=new Solution();
//        System.out.println(sl.checkSubarraySum(arr,6));
//    }
//}

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if((nums[i]+nums[i+1])%k==0){
                return true;
            }

        }

        for (int i=0;i< nums.length;i++){
            sum+=nums[i];
            if(sum%k==0){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr= {23,6,9};
//        {23,6,9};
        Solution sl=new Solution();
        System.out.println(sl.checkSubarraySum(arr,6));
    }
}