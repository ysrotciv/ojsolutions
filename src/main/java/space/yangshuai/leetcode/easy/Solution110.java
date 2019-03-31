package space.yangshuai.leetcode.easy;

import space.yangshuai.leetcode.common.TreeNode;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution110     {

    public boolean isBalanced(TreeNode root) {

        if (root == null)
            return true;

        if (Math.abs(height(root.left, 0) - height(root.right, 0)) > 1)
            return false;

        return (isBalanced(root.left) && isBalanced(root.right));
    }

    private int height(TreeNode node, int height) {

        if (node == null)
            return height;

        int left = height(node.left, height+1);
        int right = height(node.right, height+1);

        return Math.max(left, right);
    }
}
