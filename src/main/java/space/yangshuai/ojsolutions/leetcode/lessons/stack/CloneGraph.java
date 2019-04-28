package space.yangshuai.ojsolutions.leetcode.lessons.stack;

import java.util.*;

/**
 * @author yangshuai on 2019-04-24.
 */
public class CloneGraph {

    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        Node clone = new Node();
        clone.val = node.val;
        clone(node, clone);
        return clone;
    }

    private void clone(Node src, Node clone) {
        if (map.containsKey(src.val)) {
            return;
        }
        map.put(src.val, clone);
        if (src.neighbors == null) {
            return;
        }
        clone.neighbors = new ArrayList<>();
        for (Node node : src.neighbors) {
            if (map.containsKey(node.val)) {
                clone.neighbors.add(map.get(node.val));
            } else {
                Node item = new Node();
                item.val = node.val;
                clone.neighbors.add(item);
                clone(node, item);
            }
        }
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.val = 1;
        new CloneGraph().cloneGraph(node);
    }

}

