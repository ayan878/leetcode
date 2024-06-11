package Easy._1122.RelativeSortArray;

import java.util.Arrays;

class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = 1001;
        int[] count = new int[max];

        // Count the occurrences of each element in arr1
        for (int num : arr1) {
            count[num]++;
        }

        int[] result = new int[arr1.length];
        int index = 0;

        // Place elements from arr2 into the result array in the specified order
        for (int num : arr2) {
            while (count[num] > 0) {
                result[index++] = num;
                count[num]--;
            }
        }

        // Place remaining elements in ascending order
        for (int i = 0; i < max; i++) {
            while (count[i] > 0) {
                result[index++] = i;
                count[i]--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] sortedArr = sl.relativeSortArray(arr1, arr2);

        System.out.println(Arrays.toString(sortedArr));
    }
}
