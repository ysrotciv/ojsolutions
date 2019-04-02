package space.yangshuai.leetcode.contest.contest21;



import space.yangshuai.ojsolutions.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by rotciv on 2017/2/25.
 */
public class Solution530 {

    public int getMinimumDifference(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int min = Integer.MAX_VALUE;

        while (true) {
            if (queue.size() == 0) break;
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i + 1] - arr[i] < min) {
                min = arr[i + 1] - arr[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode right = new TreeNode(3);
        root.right = right;
        TreeNode subLeft = new TreeNode(2);
        right.left = subLeft;
        System.out.println(new Solution530().getMinimumDifference(root));
    }
}
