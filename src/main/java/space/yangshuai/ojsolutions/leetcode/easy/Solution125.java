package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by shuai.yang on 2015/5/21.
 */
public class Solution125 {

    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            char first, last;
            while (isAlphanumeric(s.charAt(start)) <= 0) {
                start++;
                if (start > s.length() - 1)
                    return true;
            }
            first = s.charAt(start);

            while (isAlphanumeric(s.charAt(end)) <= 0) {
                end--;
                if (end < 0)
                    return false;
            }
            last = s.charAt(end);

            if (start == end)
                return true;

            if (alphanumericEqual(first, last)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean alphanumericEqual(char first, char last) {

        if (first == last)
            return true;

        if (isAlphanumeric(first) == 1 || isAlphanumeric(first) == isAlphanumeric(last))
            return false;

        if (isAlphanumeric(first) == 2 && first + 32 == last)
            return true;

        if (isAlphanumeric(first) == 3 && first - 32 == last)
            return true;

        return false;
    }

    private int isAlphanumeric(char c) {

        if (c >= 48 && c <= 57)
            return 1;
        if (c >= 65 && c <= 90)
            return 2;
        if (c >= 97 && c <= 122)
            return 3;

        return 0;
    }

    public static void main(String[] args) {

        Solution125 solution = new Solution125();

        System.out.println(solution.isPalindrome("ProblemA man, a plan, a canal: Panama"));
    }
}
