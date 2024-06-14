package Easy._628.MaximumProductofThreeNumbers;

import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        int n = nums.length;
        // Calculate the two potential maximum products
        int maxProduct = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // Compare the two products and return the larger one
        return maxProduct;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] arr={-100,-98,-1,2,3,4};
        System.out.println(solution.maximumProduct(arr));
    }
}