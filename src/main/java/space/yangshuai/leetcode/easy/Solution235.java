package space.yangshuai.leetcode.easy;

import space.yangshuai.leetcode.common.TreeNode;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode left;
        TreeNode right;
        if (p.val >= q.val) {
            left = q;
            right = p;
        } else {
            left = p;
            right = q;
        }

        return search(root, left, right);
    }

    private TreeNode search(TreeNode root, TreeNode left, TreeNode right) {

        if (root.val >= left.val && root.val <= right.val)
            return root;

        if (root.val >= right.val) {
            return search(root.left, left, right);
        } else {
            return search(root.right, left, right);
        }
    }

    public static void main (String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode child_1 = new TreeNode(3);
        TreeNode child_2 = new TreeNode(6);
        TreeNode child_1_1 = new TreeNode(2);
        TreeNode child_1_2 = new TreeNode(4);
        TreeNode child_1_1_1 = new TreeNode(1);
        root.left = child_1;
        root.right = child_2;
        child_1.left = child_1_1;
        child_1.right = child_1_2;
        child_1_1.left = child_1_1_1;
        TreeNode result = new Solution235().lowestCommonAncestor(root, child_1_1_1, child_1_2);
        System.out.println(result.val);
    }
}
