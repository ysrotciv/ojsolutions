package space.yangshuai.leetcode.contest.contest23;


import space.yangshuai.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Created by rotciv on 2017/3/12.
 */
public class Solution536 {

    public TreeNode str2tree(String s) {

        if (s.isEmpty()) return null;

        TreeNode root = null;
        TreeNode current = root;
        Stack<TreeNode> stack =  new Stack<>();

        boolean left = false;
        boolean negative = false;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int index = i + 1;
                while (index <= s.length() - 1 && Character.isDigit(s.charAt(index))) {
                    index++;
                }
                String sub = s.substring(i, index);
                i = index - 1;
                int value = Integer.valueOf(sub);
                if (negative) value *= -1;
                negative = false;
                current = new TreeNode(value);
                if (root == null) {
                    root = current;
                } else if (left) {
                    stack.peek().left = current;
                } else {
                    stack.peek().right = current;
                }
                stack.push(current);
            } else if (c == '(') {
                if (current.left == null) left = true;
                else left = false;
            } else if (c == ')') {
                stack.pop();
                current = stack.peek();
            } else {
                negative = true;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Solution536().str2tree("-4(2(3)(1))(6(5)(7))"));
    }
}
