package space.yangshuai.ojsolutions.leetcode.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shuai.yang on 2015/1/15.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode(int val, int left, int right) {
        this.val = val;
        this.left = new TreeNode(left);
        this.right = new TreeNode(right);
    }
    public TreeNode(int val, int value, boolean left) {
        this.val = val;
        if (left) {
            this.left = new TreeNode(value);
        } else {
            this.right = new TreeNode(value);
        }
    }

    public static TreeNode getNode(String raw) {
        raw = raw.trim();
        String[] arr = raw.substring(1, raw.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        List<TreeNode> preLine = new ArrayList<>();
        List<TreeNode> currentLine = new ArrayList<>();
        preLine.add(root);
        int index = 1;
        while (index < arr.length) {
            Iterator<TreeNode> iterator = preLine.iterator();
            while (iterator.hasNext()) {
                TreeNode node = iterator.next();
                String leftVal = arr[index++];
                if (!leftVal.equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(leftVal));
                    currentLine.add(node.left);
                }
                if (index < arr.length) {
                    String rightVal = arr[index++];
                    if (!rightVal.equals("null")) {
                        node.right = new TreeNode(Integer.parseInt(rightVal));
                        currentLine.add(node.right);
                    }
                }
            }
            preLine.clear();
            preLine.addAll(currentLine);
            currentLine.clear();
        }
        return root;
    }

    public static List<TreeNode> getList(String raw) {

        List<TreeNode> ans = new ArrayList<>();
        raw = raw.trim().substring(2, raw.length() - 2);

        for (String str : raw.split("],\\[")) {
            String[] arr = str.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            List<TreeNode> preLine = new ArrayList<>();
            List<TreeNode> currentLine = new ArrayList<>();
            preLine.add(root);
            ans.add(root);
            int index = 1;
            while (index < arr.length) {
                Iterator<TreeNode> iterator = preLine.iterator();
                while (iterator.hasNext()) {
                    TreeNode node = iterator.next();
                    String leftVal = arr[index++];
                    if (!leftVal.equals("null")) {
                        node.left = new TreeNode(Integer.parseInt(leftVal));
                        currentLine.add(node.left);
                    }
                    if (index < arr.length) {
                        String rightVal = arr[index++];
                        if (!rightVal.equals("null")) {
                            node.right = new TreeNode(Integer.parseInt(rightVal));
                            currentLine.add(node.right);
                        }
                    }
                }
                preLine.clear();
                preLine.addAll(currentLine);
                currentLine.clear();
            }
        }

        return ans;
    }
}
