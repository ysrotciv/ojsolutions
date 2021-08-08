package space.yangshuai.ojsolutions.leetcode.medium;

public class Solution5 {

    public String longestPalindrome(String s) {

        int length = s.length();
        if (length < 2) {
            return s;
        }
        if (length == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }
        boolean[][] table = new boolean[length][length];
        int startIndex = 0;
        int maxLength = 1;
        char[] arr = s.toCharArray();

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if (arr[i] != arr[j]) {
                    table[i][j] = false;
                    continue;
                }
                table[i][j] = j - i < 3 || table[i + 1][j - 1];
                if (table[i][j] && (j - i + 1) > maxLength) {
                    startIndex = i;
                    maxLength = j - i + 1;
                }
            }
        }

        return s.substring(startIndex, maxLength + startIndex);
    }

    public static void main(String[] args) {
        System.out.println(new Solution5().longestPalindrome("cbbd"));
    }
}
