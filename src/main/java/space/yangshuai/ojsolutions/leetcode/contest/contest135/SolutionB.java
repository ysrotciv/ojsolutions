package space.yangshuai.ojsolutions.leetcode.contest.contest135;

import space.yangshuai.ojsolutions.leetcode.common.TreeNode;

/**
 * @author yangshuai on 2019-05-05.
 */
public class SolutionB {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        add(root);
        set(root);
        return root;
    }

    public void add(TreeNode node) {
        if (node == null) return;
        sum += node.val;
        add(node.left);
        add(node.right);
    }

    public void set(TreeNode node) {
        if (node == null) {
            return;
        }
        set(node.left);
        int old = node.val;
        node.val = sum;
        sum -= old;
        set(node.right);
    }

}
