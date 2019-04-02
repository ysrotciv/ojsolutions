package space.yangshuai.leetcode.easy;

import space.yangshuai.ojsolutions.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> temp = new ArrayList<>();
        List<Integer> values = new ArrayList<>();

        if (root == null) {
            return temp;
        }

        ArrayList<TreeNode> parents = new ArrayList<>();
        ArrayList<TreeNode> children;

        parents.add(root);
        values.add(root.val);
        temp.add(values);

        while (parents.size() > 0) {

            values = new ArrayList<>();
            children = new ArrayList<>();

            Iterator<TreeNode> iterator = parents.iterator();

            while (iterator.hasNext()) {

                TreeNode parent = iterator.next();

                if (parent.left != null) {
                    children.add(parent.left);
                    values.add(parent.left.val);
                }

                if (parent.right != null) {
                    children.add(parent.right);
                    values.add(parent.right.val);
                }
            }

            if (values.size() > 0)
                temp.add(values);
            parents = children;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }

        return result;
    }
}
