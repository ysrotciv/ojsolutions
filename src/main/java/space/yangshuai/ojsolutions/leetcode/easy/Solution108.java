package space.yangshuai.ojsolutions.leetcode.easy;

import space.yangshuai.ojsolutions.leetcode.common.TreeNode;

public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return initTree(nums, left, right);
    }

    private TreeNode initTree(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (left < mid) {
            node.left = initTree(nums, left, mid - 1);
        }
        if (mid < right) {
            node.right = initTree(nums, mid + 1, right);
        }
        return node;
    }
}
