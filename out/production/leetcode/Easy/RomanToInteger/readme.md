# Roman to Integer Conversion

## Introduction
The Roman numeral system uses combinations of letters from the Latin alphabet (I, V, X, L, C, D, M) to represent values. This guide explains how to convert Roman numerals to integers.

## Roman Numeral Values
- I = 1
- V = 5
- X = 10
- L = 50
- C = 100
- D = 500
- M = 1000

## Conversion Rules

### Simple Addition
When the Roman numerals are in non-increasing order, simply add all the values. 

**Example:**
- CCLXXXIII = 100 + 100 + 50 + 10 + 10 + 10 + 1 + 1 + 1 = 283

### Subtraction Rule
If a lower value precedes a higher value, subtract the lower value from the higher value and then add the result to the total.

**Example:**
- CDXCVII
  - Start with 500 (D)
  - Subtract 100 from 500 (C before D) → -100 + 500 = 400
  - Add 10 (X)
  - Add 100 (C)
  - Add 5 (V)
  - Add 1 + 1 (II)
  - Total: 400 + 10 + 100 + 5 + 1 + 1 = 497

### Algorithm
1. Initialize a total value to 0.
2. Iterate through each character in the Roman numeral string.
3. For each character, compare its value to the value of the next character:
   - If the current character’s value is less than the next character’s value, subtract the current character’s value from the total.
   - Otherwise, add the current character’s value to the total.

## Example Code

Here is the implementation in Java:

```java
package Easy.RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public static int romanToInteger(String s) {
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                value -= romanMap.get(s.charAt(i));
            } else {
                value += romanMap.get(s.charAt(i));
            }
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(romanToInteger("II")); // Output: 2
    }
}
```
