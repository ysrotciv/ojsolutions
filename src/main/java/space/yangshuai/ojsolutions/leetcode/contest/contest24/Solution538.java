package space.yangshuai.leetcode.contest.contest24;


import space.yangshuai.ojsolutions.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by rotciv on 2017/3/19.
 */
public class Solution538 {

    public TreeNode convertBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.right != null) queue.add(node.right);
            if (node.left != null) queue.add(node.left);
        }

        list.sort((o1, o2) -> o2 - o1);
        int sum = 0;
        int temp = Integer.MIN_VALUE;
        for (Integer value : list) {
            if (value != temp) {
                map.put(value, sum);
                temp = value;
            }
            sum += value;
        }

        queue.clear();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            node.val = map.get(node.val);
            if (node.right != null) queue.add(node.right);
            if (node.left != null) queue.add(node.left);
        }

        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(5);
        list.add(1);
        list.sort((o1, o2) -> o2 - o1);

        for (int value: list) {
            System.out.println(value);
        }
    }


}
