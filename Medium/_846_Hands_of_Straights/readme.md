```markdown
# 846. Hand of Straights

**Difficulty**: Medium

## Problem Description

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size `groupSize`, and consists of `groupSize` consecutive cards.

Given an integer array `hand` where `hand[i]` is the value written on the `i`th card and an integer `groupSize`, return `true` if she can rearrange the cards, or `false` otherwise.

## Examples

### Example 1

**Input**: 
```
hand = [1, 2, 3, 6, 2, 3, 4, 7, 8]
groupSize = 3
```
**Output**: 
```
true
```
**Explanation**: 
Alice's hand can be rearranged as [1, 2, 3], [2, 3, 4], [6, 7, 8].

### Example 2

**Input**: 
```
hand = [1, 2, 3, 4, 5]
groupSize = 4
```
**Output**: 
```
false
```
**Explanation**: 
Alice's hand cannot be rearranged into groups of 4.

## Constraints

- \(1 \leq \text{hand.length} \leq 10^4\)
- \(0 \leq \text{hand}[i] \leq 10^9\)
- \(1 \leq \text{groupSize} \leq \text{hand.length}\)

## Solution

To solve this problem, we can use a `TreeMap` to keep track of the counts of each card and efficiently access the smallest card. Here's the step-by-step explanation and the code.

### Step-by-Step Explanation

1. **Input Validation**: 
   - Check if the length of the hand is divisible by `groupSize`. If not, return `false` because it's impossible to form groups of equal size.
   
2. **Using TreeMap**: 
   - Use a `TreeMap` to store card values and their counts. `TreeMap` keeps the keys sorted, allowing efficient access to the smallest card.
   
3. **Forming Groups**: 
   - While there are cards in the `TreeMap`, start forming groups from the smallest available card.
   - For each card, check if the next `groupSize - 1` consecutive cards are present. If any card is missing, return `false`.
   - Decrease the count of each card used in forming a group. If a card's count drops to zero, remove it from the `TreeMap`.

### Code

```java
import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        while (!cardCount.isEmpty()) {
            int first = cardCount.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int currentCard = first + i;
                if (!cardCount.containsKey(currentCard)) {
                    return false;
                }
                int count = cardCount.get(currentCard);
                if (count == 1) {
                    cardCount.remove(currentCard);
                } else {
                    cardCount.put(currentCard, count - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        System.out.println(sol.isNStraightHand(hand, groupSize));  // Output should be true

        int[] hand2 = {1, 2, 3, 4, 5};
        int groupSize2 = 4;
        System.out.println(sol.isNStraightHand(hand2, groupSize2));  // Output should be false
    }
}
```

### Explanation of the Code

- **Imports**: The code imports `TreeMap` to use its sorted map features.
- **Method `isNStraightHand`**:
    - **Input Validation**: Checks if the length of `hand` is divisible by `groupSize`.
    - **TreeMap Initialization**: Initializes a `TreeMap` to count the occurrences of each card.
    - **Populating the TreeMap**: Iterates over `hand` to populate the `TreeMap` with card counts.
    - **Forming Groups**:
        - Uses a while loop to process the smallest cards first.
        - For each smallest card, attempts to form a group by checking the next `groupSize - 1` consecutive cards.
        - Updates the card counts in the `TreeMap`.
        - Returns `false` if any required card is missing.
    - **Return Statement**: Returns `true` if all cards are successfully grouped.
- **Main Method**: Provides example test cases to verify the solution.

This solution ensures efficient processing and validation of the hand to determine if it can be rearranged into the required groups.
```