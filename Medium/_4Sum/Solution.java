package Medium._4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    List<Integer> newSet = new ArrayList<>(Arrays.asList(nums[i]));
                    newSet.addAll(set);
                    res.add(newSet);
                }
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
                if (seen.contains(target - nums[i])) {
                    res.add(Arrays.asList(target - nums[i], nums[i]));
                }
            }
            seen.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<Integer>> result1 = s.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(result1);

        List<List<Integer>> result2 = s.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        System.out.println(result2);
    }
}
