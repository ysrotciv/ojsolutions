package space.yangshuai.leetcode.easy;

import space.yangshuai.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        ArrayList<TreeNode> parentList = new ArrayList<>();
        ArrayList<TreeNode> childrenList;
        ArrayList<Integer> valueList = new ArrayList<>();

        parentList.add(root);

        while (parentList.size() > 0) {

            childrenList = new ArrayList<>();
            valueList.clear();

            Iterator<TreeNode> iterator = parentList.iterator();

            while (iterator.hasNext()) {

                TreeNode node = iterator.next();

                if (node.left != null) {
                    childrenList.add(node.left);
                    valueList.add(node.left.val);
                } else {
                    valueList.add(0);
                }

                if (node.right != null) {
                    childrenList.add(node.right);
                    valueList.add(node.right.val);
                } else {
                    valueList.add(0);
                }
            }

            if (!symmetric(valueList))
                return false;

            parentList = childrenList;
        }

        return true;
    }

    private boolean symmetric(ArrayList<Integer> list) {

        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i).intValue();
        }


        int length = arr.length;

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[length - i - 1])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode first1 = new TreeNode(2);
        TreeNode first2 = new TreeNode(2);
        TreeNode second2 = new TreeNode(3);
        TreeNode second4 = new TreeNode(3);

        root.left = first1;
        root.right = first2;

        first1.right = second2;
        first2.right = second4;

        System.out.println(new Solution101().isSymmetric(root));
    }
}
