package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Solution409 {

    public int longestPalindrome(String s) {

        int[] arr = new int[58];
        for (char c : s.toCharArray()) {
            arr[c - 'A']++;
        }
        int res = 0;
        for (int value : arr) {
            res += value - (value & 1);
        }
        return res == s.length() ? res : res + 1;
    }
}
