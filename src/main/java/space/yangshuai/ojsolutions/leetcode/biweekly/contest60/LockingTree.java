package space.yangshuai.ojsolutions.leetcode.biweekly.contest60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class LockingTree {

    private class TreeNode {
        public TreeNode(int index) {
            this.index = index;
        }

        List<TreeNode> children = new ArrayList<>();
        int index;

        private void addChild(TreeNode child) {
            children.add(child);
        }
    }

    private int[] locks;
    private int[] parent;
    private TreeNode root;
    private HashMap<Integer, TreeNode> nodeMap;
    Stack<TreeNode> stack = new Stack<>();


    private boolean flag = false;

    public LockingTree(int[] parent) {
        this.parent = parent;
        locks = new int[parent.length];
        nodeMap = new HashMap<>(parent.length << 1);
        root = new TreeNode(0);
        nodeMap.put(0, root);
        for (int i = 1; i < parent.length; i++) {
            if (nodeMap.containsKey(i)) {
                continue;
            }
            TreeNode child = new TreeNode(i);
            TreeNode parentNode = nodeMap.get(parent[i]);
            if (parentNode != null) {
                parentNode.addChild(child);
                nodeMap.put(i, child);
            } else {
                add(i);
            }
        }
    }

    private void add(int num) {
        TreeNode child = new TreeNode(num);
        stack.add(child);
        int p = parent[num];
        while (!nodeMap.containsKey(p)) {
            stack.add(new TreeNode(p));
            p = parent[p];
        }
        TreeNode parentNode = nodeMap.get(p);
        while (!stack.isEmpty()) {
            TreeNode childNode = stack.pop();
            parentNode.addChild(childNode);
            parentNode = childNode;
        }
    }

    public boolean lock(int num, int user) {
        if (locks[num] == 0) {
            locks[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (locks[num] == user) {
            locks[num] = 0;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (locks[num] != 0) {
            return false;
        }
        lockedChildren(num);
        if (!flag) {
            return false;
        } else {
            flag = false;
        }
        if (existsLockedParent(num)) {
            return false;
        }
        locks[num] = user;
        unlockChildren(num);
        return true;
    }

    private void unlockChildren(int num) {
        TreeNode node = nodeMap.get(num);
        for (TreeNode child : node.children) {
            locks[child.index] = 0;
            unlockChildren(child.index);
        }
    }

    private boolean existsLockedParent(int num) {
        if (num == 0) {
            return false;
        }
        while (parent[num] != -1) {
            num = parent[num];
            if (locks[num] != 0) {
                return false;
            }
        }
        return true;
    }

    private void lockedChildren(int num) {
        TreeNode node = nodeMap.get(num);
        for (TreeNode child : node.children) {
            if (locks[child.index] != 0) {
                flag = true;
                return;
            } else {
                lockedChildren(child.index);
            }
        }
    }

    public static void main(String[] args) {
        LockingTree lockingTree = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
        lockingTree.lock(2, 2);    // 返回 true ，因为节点 2 未上锁。
        // 节点 2 被用户 2 上锁。
        lockingTree.unlock(2, 3);  // 返回 false ，因为用户 3 无法解锁被用户 2 上锁的节点。
        lockingTree.unlock(2, 2);  // 返回 true ，因为节点 2 之前被用户 2 上锁。
        // 节点 2 现在变为未上锁状态。
        lockingTree.lock(4, 5);    // 返回 true ，因为节点 4 未上锁。
        // 节点 4 被用户 5 上锁。
        lockingTree.upgrade(0, 1); // 返回 true ，因为节点 0 未上锁且至少有一个被上锁的子孙节点（节点 4）。
        // 节点 0 被用户 1 上锁，节点 4 变为未上锁。
        lockingTree.lock(0, 1);    // 返回 false ，因为节点 0 已经被上锁了。
    }
}


/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */