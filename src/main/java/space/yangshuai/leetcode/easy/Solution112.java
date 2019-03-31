package space.yangshuai.leetcode.easy;

import space.yangshuai.leetcode.common.TreeNode;

/**
 * Path Sum
 * Created by shuai.yang on 2015/1/15.
 */
public class Solution112 {

    int temp;

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            if (temp + root.val == sum)
                return true;
            return false;
        } else {
            temp += root.val;
            if (hasPathSum(root.left, sum) || hasPathSum(root.right, sum)) {
                return true;
            } else {
                temp -= root.val;
                return false;
            }
        }
    }
}

/** the second way, has the similar speed with the first one */
/*public class Solution112Second {

    private boolean hasSum(TreeNode root, int sum, int temp) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.val + temp == sum;
        } else {
            temp += root.val;
            return hasSum(root.left, sum, temp) || hasSum(root.right, sum, temp);
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasSum(root, sum, 0);
    }
}*/
