package space.yangshuai.leetcode.easy;

import space.yangshuai.leetcode.common.TreeNode;

/**
 * Created by Administrator on 2015/12/19.
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root.right == null && root.left == null)
            return;
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null)
            invertTree(root.left);
        if (root.right != null)
            invertTree(root.right);
    }
}
