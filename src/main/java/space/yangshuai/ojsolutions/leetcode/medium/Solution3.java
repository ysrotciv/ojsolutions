package space.yangshuai.ojsolutions.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {

        int startIndex = 0;
        Map<Character, Integer> charIndexes = new HashMap<>();
        int maxLength = 0;
        int currentLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charIndexes.containsKey(c) && charIndexes.get(c) >= startIndex) {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                startIndex = charIndexes.get(c) + 1;
                currentLength = i + 1 - startIndex;
            } else {
                currentLength++;
            }
            charIndexes.put(c, i);

        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));
    }

}
