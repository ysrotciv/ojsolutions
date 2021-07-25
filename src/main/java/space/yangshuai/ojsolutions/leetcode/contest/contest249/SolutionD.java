package space.yangshuai.ojsolutions.leetcode.contest.contest249;

import space.yangshuai.ojsolutions.leetcode.common.TreeNode;

import java.util.*;

public class SolutionD {

    public TreeNode canMerge(List<TreeNode> trees) {
        HashMap<Integer, TreeNode> map = new HashMap<>(); // root val -> root ref
        HashSet<Integer> set = new HashSet<>(); // set for leaf
        for (TreeNode tree : trees) {
            map.put(tree.val, tree);
            if (tree.left != null || tree.right != null) {
                canMerge(tree, set);
            }
        }
        for (TreeNode tree : trees) {
            if (!set.contains(tree.val)) {
                if (tree.left != null || tree.right != null) {
                    canMerge(tree, map);
                }
                return map.size() == 1 && isValidBST(tree) ? tree : null;
            }
        }
        return null;
    }

    private void canMerge(TreeNode tree, HashSet<Integer> set) {
        if (tree != null) {
            if (tree.left == null && tree.right == null) {
                set.add(tree.val);
            }
            canMerge(tree.left, set);
            canMerge(tree.right, set);
        }
    }

    private void canMerge(TreeNode tree, HashMap<Integer, TreeNode> map) {
        if (tree != null) {
            if (tree.left == null && tree.right == null && map.containsKey(tree.val)) {
                tree.left = map.get(tree.val).left;
                tree.right = map.remove(tree.val).right;
            }
            canMerge(tree.left, map);
            canMerge(tree.right, map);
        }
    }

    private boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        String raw = "[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]";
        TreeNode.getList(raw);
        /*TreeNode node1 = new TreeNode(10, 9, true);
        TreeNode node2 = new TreeNode(9, 8, true);
        TreeNode node3 = new TreeNode(8, 7, true);
        List<TreeNode> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        new SolutionD().canMerge(list);*/
    }

}
