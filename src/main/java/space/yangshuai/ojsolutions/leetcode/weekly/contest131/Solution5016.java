package space.yangshuai.ojsolutions.leetcode.weekly.contest131;

/**
 * @author yangshuai on 2019-04-07.
 */
public class Solution5016 {

    public String removeOuterParentheses(String S) {

        if (S.length() == 0) {
            return S;
        }

        StringBuilder result = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        int left = 0;

        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                left++;
            } else {
                left--;
            }
            builder.append(S.charAt(i));
            if (left == 0) {
                String temp = builder.toString();
                if (!temp.isEmpty()) {
                    result.append(temp, 1, temp.length() - 1);
                    builder = new StringBuilder();
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String result = new Solution5016().removeOuterParentheses("(()())(())(()(()))");
        System.out.println(result);
    }
}
