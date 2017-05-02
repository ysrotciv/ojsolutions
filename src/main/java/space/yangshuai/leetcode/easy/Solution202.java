package space.yangshuai.leetcode.easy;

import java.util.Stack;

/**
 * Created by shuai.yang on 2015/5/21.
 */
public class Solution202 {

    public boolean isHappy(int n) {

        Stack<Integer> stack = new Stack<Integer>();
        int result = n;

        while(true) {
            result = calculateHappyNumber(result);

            if (result == 1)
                return true;

            if (stack.search(result) == -1) {
                stack.push(result);
            } else {
                return false;
            }
        }
    }

    private int calculateHappyNumber(int n) {

        int result = 0;
        char[] chars = String.valueOf(n).toCharArray();
        for (char c : chars) {
            result += Math.pow(Character.getNumericValue(c), 2);
        }

        return result;
    }

    public static void main(String[] args) {

        Solution202 solution = new Solution202();
        System.out.println(solution.isHappy(1));
    }
}
