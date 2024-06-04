package Easy.RomanToInteger;

import java.util.HashMap;


public class Solution {

    public static int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();    
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                value -= map.get(s.charAt(i));
            } else {
                value += map.get(s.charAt(i));
            }
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(romanToInteger("II")); // Output: 2
    }
}
