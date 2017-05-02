package space.yangshuai.leetcode.easy;

/**
 * Excel Sheet Column Number
 * Created by shuai.yang on 2015/1/15.
 */
public class Solution171 {

    public static void main(String[] args) {
        Solution171 solution = new Solution171();
        String test = "AA";
        System.out.println(solution.titleToNumber(test));
    }

    public int titleToNumber(String s) {

        char[] chars = s.toCharArray();
        int size = chars.length;
        int result = 0;
        int temp;

        for (int i = 0; i < size; i++) {
            temp = chars[i];
            result += (temp - 64) * (int)Math.pow(26, size - i - 1);
        }
        return result;
    }
}
