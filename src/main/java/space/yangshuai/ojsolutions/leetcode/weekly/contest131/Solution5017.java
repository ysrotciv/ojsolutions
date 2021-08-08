package space.yangshuai.ojsolutions.leetcode.weekly.contest131;

import space.yangshuai.ojsolutions.leetcode.common.TreeNode;

/**
 * @author yangshuai on 2019-04-07.
 */
public class Solution5017 {

    private long result = 0L;

    private static int MOD = 1000000007;

    public int sumRootToLeaf(TreeNode root) {

        if (root.left != null) {
            add(root.left, root.val);
        }
        if (root.right != null) {
            add(root.right, root.val);
        }

        if (root.left == null && root.right == null) {
            return root.val;
        }

        return (int)result;
    }

    private void add(TreeNode node, long value) {

        long temp = (value * 2 + node.val) % MOD;

        if (node.left == null && node.right == null) {
            result = (result + temp) % MOD;
            return;
        }
        if (node.left != null) {
            add(node.left, temp);
        }
        if (node.right != null) {
            add(node.right, temp);
        }

    }

    public static void main(String[] args) {
        String arg = "[1,1,1,null,null,0,1,null,null,1,1,null,null,null,1]";
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        treeNode.left = null;
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(1);
        treeNode2.right = treeNode;

        TreeNode treeNode3 = new TreeNode(1);
        treeNode3.left = new TreeNode(0);
        treeNode3.right = treeNode2;

        TreeNode treeNode4 = new TreeNode(1);
        treeNode4.left = new TreeNode(1);
        treeNode4.right = treeNode3;

        int result = new Solution5017().sumRootToLeaf(treeNode4);
        System.out.println(result);
    }
}


