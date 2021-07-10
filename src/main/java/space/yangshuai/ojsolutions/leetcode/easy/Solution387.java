package space.yangshuai.ojsolutions.leetcode.easy;

public class Solution387 {

    public int firstUniqChar(String s) {
        int[] flag = new int[26];

        for (char c : s.toCharArray()) {
            flag[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (flag[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
