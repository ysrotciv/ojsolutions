package space.yangshuai.leetcode.contest.contest29;

import space.yangshuai.leetcode.common.TreeNode;

/**
 * Created by rotciv on 2017/4/23.
 */
public class Solution563 {

    private int tilt = 0;

    public int findTilt(TreeNode root) {

        sum(root);
        abs(root);
        tilt(root);
        return tilt;
    }

    private void tilt(TreeNode node) {
        if (node == null) {
            return;
        }
        tilt += node.val;
        tilt(node.left);
        tilt(node.right);
    }

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.val;
        }
        int result = sum(node.left) + sum(node.right);
        node.val += result;

        return node.val;
    }

    private void abs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.right != null) {
            node.val = Math.abs(node.left.val - node.right.val);
        } else if (node.left != null) {
            node.val = Math.abs(node.left.val);
        } else if (node.right != null) {
            node.val = Math.abs(node.right.val);
        } else {
            node.val = 0;
        }

        abs(node.left);
        abs(node.right);
    }

}
