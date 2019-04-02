package space.yangshuai.ojsolutions.leetcode.contest.contest25;

import space.yangshuai.ojsolutions.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotciv on 2017/3/26.
 */
public class Solution545 {

    List<Integer> allLeaves = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.add(root.val);
        TreeNode temp;
        if (root.left != null) {
            temp = root.left;
            while (temp.left != null || temp.right != null) {
                list.add(temp.val);
                if (temp.left != null) temp = temp.left;
                else temp = temp.right;
            }
            findAllLeaves(root.left);
            list.addAll(allLeaves);
        }

        if (root.right != null) {
            allLeaves.clear();
            findAllLeaves(root.right);
            list.addAll(allLeaves);

            temp = root.right;
            List<Integer> right = new ArrayList<>();
            while (temp.right != null || temp.left != null) {
                right.add(temp.val);
                if (temp.right != null) temp = temp.right;
                else temp = temp.left;
            }

            for (int i = right.size() - 1; i >= 0; --i) {
                list.add(right.get(i));
            }
        }

        return list;
    }

    private void findAllLeaves(TreeNode root) {
        if (root.left != null) findAllLeaves(root.left);
        if (root.right != null) findAllLeaves(root.right);
        if (root.left == null && root.right == null) allLeaves.add(root.val);
    }
}
