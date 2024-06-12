package Medium._75SortColors;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int i = -1, j = nums.length, k = 0;
        while (k < j) {
            if (nums[k] == 0) {
                swap(nums, ++i, k++);
            } else if (nums[k] == 2) {
                swap(nums, --j, k);
            } else {
                ++k;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {2, 0, 1};
        sl.sortColors(nums);
        System.out.println(Arrays.toString(nums)); // Output: [0, 1, 2]

//        int[] nums1 = {2, 0, 2, 1, 1, 0};
//        sl.sortColors(nums1);
//        System.out.println(Arrays.toString(nums1)); // Output: [0, 0, 1, 1, 2, 2]
    }
}
