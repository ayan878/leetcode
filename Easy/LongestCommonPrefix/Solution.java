package Easy.LongestCommonPrefix;

public class Solution {

    // Using Brute Force method
    public static String longestCommonPrefixBruteForce(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    // Using Trie
    public static void longestCommonPrefixTrie(String[] args) {
        
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefixBruteForce(strs));
    }
}
