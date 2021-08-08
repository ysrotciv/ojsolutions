package space.yangshuai.ojsolutions.leetcode.weekly.contest137;

import java.util.Stack;

public class SolutionB {

    public String removeDuplicates(String S) {

        if (S.length() == 1) {
            return S;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String result = new SolutionB().removeDuplicates("aaaaaa");
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(result);
    }

}
