package Medium._846_Hands_of_Straights;

import java.util.PriorityQueue;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int card : hand) {
            pq.offer(card);
        }
        System.out.println(pq);

        while (!pq.isEmpty()) {
            int first = pq.poll();
            for (int i = 1; i < groupSize; i++) {
                    System.out.println(first+1);
                if (!pq.remove(first + i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand={1,2,3,6,2,3,4,7,8};
        System.out.println(isNStraightHand(hand,3));
    }

}
