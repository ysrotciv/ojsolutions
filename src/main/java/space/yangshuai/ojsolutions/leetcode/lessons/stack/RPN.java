package space.yangshuai.ojsolutions.leetcode.lessons.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author yangshuai on 2019-04-23.
 */
public class RPN {

    public int evalRPN(String[] tokens) {

        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "/", "*"));

        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (set.contains(token)) {
                if ("+".equals(token)) {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a + b));
                } else if ("-".equals(token)) {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a - b));
                } else if ("*".equals(token)) {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a * b));
                } else if ("/".equals(token)) {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(a / b));
                }
            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        new RPN().evalRPN(new String[]{"2","1","+","3","*"});
    }
}
