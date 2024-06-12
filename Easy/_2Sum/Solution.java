package Easy._2Sum;

import java.util.Arrays;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // Create an array of pairs (value, original_index)
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i]; // for value
            pairs[i][1] = i;       // for index
        }

        // Sort the pairs array based on the values
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (pairs[j][0] > pairs[j + 1][0]) {
                    int[] temp = pairs[j];
                    pairs[j] = pairs[j + 1];
                    pairs[j + 1] = temp;
                }
            }
        }

        // Two-pointer technique
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = pairs[left][0] + pairs[right][0];
            if (sum == target) {
                return new int[]{pairs[left][1], pairs[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // If no solution is found, throw an exception
        throw new IllegalArgumentException("Input Invalid: No two sum solution found");
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 6, 5, 8};
        try {
            int[] result = Solution.twoSum(nums, 13);
            System.out.println(Arrays.toString(result)); // Example: [1, 3]
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
