package space.yangshuai.ojsolutions.leetcode.easy;

public class Solution557 {

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                reverseString(arr, start, i - 1);
                start = i + 1;
            }
        }
        reverseString(arr, start, s.length() - 1);
        return new String(arr);
    }

    private void reverseString(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
