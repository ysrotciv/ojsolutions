package space.yangshuai.ojsolutions.leetcode.lessons.stack;

import java.util.List;

/**
 * @author yangshuai on 2019-04-24.
 */
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}