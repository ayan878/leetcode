# Longest Common Prefix Finder

This project provides two implementations to find the longest common prefix among a list of strings:
1. Brute Force Method
2. Trie (Prefix Tree) Method

## Brute Force Method

### Theory
The brute force method iteratively compares characters of the first string with all other strings. It shortens the prefix as soon as a mismatch is found or the shortest string length is reached.

### Implementation
1. Start with the first string as the initial prefix.
2. Compare this prefix with each string in the array.
3. If a mismatch is found, shorten the prefix by one character from the end.
4. Repeat until there are no mismatches or the prefix becomes empty.

### Condition
1. The loop continues until the prefix is not found at the start of the current string (`strs[i].indexOf(prefix) != 0`).
2. The traversal stops when the length of the prefix becomes zero or matches the length of the smallest string.

    {"flower", "flow", "flight"}

### Code
```java
public class LongestCommonPrefixBruteForce {
    public static String longestCommonPrefix(String[] strs) {
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

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }
}
