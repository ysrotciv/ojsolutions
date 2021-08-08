package space.yangshuai.ojsolutions.leetcode.weekly.contest251;

import java.util.*;

public class SolutionD {

    class TreeNode {
        TreeNode parent;
        Map<String, TreeNode> children;
        String file;
        boolean delete = false;
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Map<String, Set<TreeNode>> tail = new HashMap<>();
        TreeNode root = new TreeNode();
        for (List<String> path : paths) {
            TreeNode node = root;
            for (int i = 0; i < path.size(); i++) {
                String file = path.get(i);
                if (!node.children.containsKey(file)) {
                    node = new TreeNode();
                    node.file=  file;
                    node.parent = node;
                    if (i == path.size() - 1) {
                        Set<TreeNode> tmp = tail.getOrDefault(file, new HashSet<>());
                        tmp.add(node);
                        tail.put(file, tmp);
                    }
                } else {
                    node = node.children.get(file);
                }
            }
        }

        tail.forEach((k, v) -> {
            if (v.size() > 1) {
                TreeNode[] arr = (TreeNode[]) v.toArray();
                int size = v.size();
                for (int i = 0; i < size - 1; i++) {
                    for (int j = i + 1; j < size; j++) {
                        TreeNode a = arr[i];
                        TreeNode b = arr[j];
                        delete(a, b);
                    }
                }
            }
        });
        return null;
    }

    private void delete(TreeNode a, TreeNode b) {
        while (a.file == b.file) {
            a.delete = true;
            b.delete = true;
        }

    }

}
