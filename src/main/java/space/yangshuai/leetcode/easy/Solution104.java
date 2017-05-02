package space.yangshuai.leetcode.easy;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Maximum Depth of Binary Tree
 * Created by shuai.yang on 2015/1/15.
 */
public class Solution104 {

    public static void main(String[] args) {

    }

    List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
    List<TreeNode> tempList = new ArrayList<TreeNode>();
    boolean hasNode;

    int depth = 0;

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        treeNodeList.add(root);
        while(true) {

            depth++;
            hasNode = false;

            for (TreeNode node : treeNodeList) {
                if (node.left != null) {
                    tempList.add(node.left);
                    hasNode = true;
                }
                if (node.right != null) {
                    tempList.add(node.right);
                    hasNode = true;
                }
            }

            if (hasNode == false)
                break;

            treeNodeList = tempList;
            tempList = new ArrayList<TreeNode>();
        }

        return depth;
    }
}
