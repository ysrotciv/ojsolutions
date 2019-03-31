package space.yangshuai.leetcode.easy;

import space.yangshuai.leetcode.common.TreeNode;

/**
 * Same Tree
 * Created by shuai.yang on 2015/1/15.
 */
public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        if (p.left == null && q.left != null)
            return false;

        if (p.left != null && q.left == null)
            return false;

        if (p.right == null && q.right != null)
            return false;

        if (p.right != null && q.right == null)
            return false;

        if (p.left == null && p.right == null && q.left == null && q.right == null)
            return true;

        if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right))
            return false;

        return true;
    }
}