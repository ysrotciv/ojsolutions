package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.Stack;

/**
 * Created by rotciv on 2017/2/16.
 */
public class Solution20 {

    public boolean isValid(String s) {

        if (s.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        String template = "([{";

        for (char c: s.toCharArray()) {
            if (template.contains(c + "")) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return false;
                char temp = stack.pop();
                if (temp == '(' && c == ')') continue;
                if (temp == '[' && c == ']') continue;
                if (temp == '{' && c == '}') continue;
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(new Solution20().isValid(""));
    }
}
