package Easy.RemoveElement;

public class Solution {
    public static int removeElement(int[] nums, int val) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[n] = nums[i];
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 2};
        int newLength = removeElement(nums, 2);
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
