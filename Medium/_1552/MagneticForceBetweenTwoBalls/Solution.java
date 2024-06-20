package Medium._1552.MagneticForceBetweenTwoBalls;

import java.util.Arrays;

import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1; // minimum possible distance
        int right = position[position.length - 1] - position[0]; // maximum possible distance

        while (left < right) {
            int mid = (left + right + 1) / 2; // candidate distance
            if (canPlaceBalls(position, m, mid)) {
                left = mid; // try for a larger distance
            } else {
                right = mid - 1; // try for a smaller distance
            }
        }
        return left;
    }

    private boolean canPlaceBalls(int[] position, int m, int minDist) {
        int count = 1; // place the first ball
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= minDist) {
                count++;
                lastPos = position[i];
                if (count >= m) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] position1 = {1, 2, 3, 4, 7};
        int m1 = 3;
        System.out.println(sol.maxDistance(position1, m1)); // Output: 3

        int[] position2 = {5, 4, 3, 2, 1};
        int m2 = 2;
        System.out.println(sol.maxDistance(position2, m2)); // Output: 4

        int[] position3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int m3 = 4;
        System.out.println(sol.maxDistance(position3, m3)); // Output: 3
    }

}