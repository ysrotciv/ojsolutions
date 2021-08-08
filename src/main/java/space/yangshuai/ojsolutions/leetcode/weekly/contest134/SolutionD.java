package space.yangshuai.ojsolutions.leetcode.weekly.contest134;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author yangshuai on 2019-04-28.
 */
public class SolutionD {

    int LIMIT = 1000000;

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {

        Set<String> blockedSet = new HashSet<>(blocked.length >> 2);
        for (int[] node : blocked) {
            blockedSet.add(String.format("%d,%d", node[0], node[1]));
        }

        if (blocked.length == 0) {
            return true;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(new Node(source[0], source[1]));

        Stack<Node> temp = new Stack<>();

        while (stack.size() > 0) {

            Node node = stack.pop();
            if (isTarget(target, node)) {
                return true;
            }
            Node up = new Node(node.x - 1, node.y);
            Node down = new Node(node.x + 1, node.y);
            Node left = new Node(node.x, node.y - 1);
            Node right = new Node(node.x, node.y + 1);

            int xDiff = Math.abs(node.x - target[0]);
            int yDiff = Math.abs(node.y - target[1]);

            if (xDiff < yDiff) {
                if (node.x < target[0]) {
                    if (node.y < target[1]) {
                        pushStack(blockedSet, temp, right);
                        pushStack(blockedSet, temp, down);
                        pushStack(blockedSet, temp, up);
                        pushStack(blockedSet, temp, left);
                    } else {
                        pushStack(blockedSet, temp, left);
                        pushStack(blockedSet, temp, down);
                        pushStack(blockedSet, temp, up);
                        pushStack(blockedSet, temp, right);
                    }
                } else {
                    if (node.y < target[1]) {
                        pushStack(blockedSet, temp, right);
                        pushStack(blockedSet, temp, up);
                        pushStack(blockedSet, temp, down);
                        pushStack(blockedSet, temp, left);
                    } else {
                        pushStack(blockedSet, temp, left);
                        pushStack(blockedSet, temp, up);
                        pushStack(blockedSet, temp, down);
                        pushStack(blockedSet, temp, right);
                    }
                }
            } else {
                if (node.x < target[0]) {
                    if (node.y < target[1]) {
                        pushStack(blockedSet, temp, down);
                        pushStack(blockedSet, temp, right);
                        pushStack(blockedSet, temp, left);
                        pushStack(blockedSet, temp, up);
                    } else {
                        pushStack(blockedSet, temp, down);
                        pushStack(blockedSet, temp, left);
                        pushStack(blockedSet, temp, right);
                        pushStack(blockedSet, temp, up);
                    }
                } else {
                    if (node.y < target[1]) {
                        pushStack(blockedSet, temp, up);
                        pushStack(blockedSet, temp, right);
                        pushStack(blockedSet, temp, left);
                        pushStack(blockedSet, temp, down);
                    } else {
                        pushStack(blockedSet, temp, up);
                        pushStack(blockedSet, temp, left);
                        pushStack(blockedSet, temp, right);
                        pushStack(blockedSet, temp, down);
                    }
                }
            }

            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }

        }

        return false;
    }

    private void pushStack(Set<String> blockedSet, Stack<Node> stack, Node node) {
        if (!isBlocked(blockedSet, node)) {
            stack.push(node);
            blockedSet.add(String.format("%d,%d", node.x, node.y));
        }
    }


    private boolean isTarget(int[] target, Node node) {
        return Math.abs(target[0] - node.x) + Math.abs(target[1] - node.y) == 1;
    }

    private boolean isBlocked(Set<String> blockedSet, Node node) {

        if (node.x < 0 || node.x >= LIMIT) {
            return true;
        }
        if (node.y < 0 || node.y >= LIMIT) {
            return true;
        }

        return blockedSet.contains(String.format("%d,%d", node.x, node.y));
    }

    public static void main(String[] args) {
        int[][] blocked = new int[][]{{691938,300406},{710196,624190},{858790,609485},{268029,225806},{200010,188664},{132599,612099},{329444,633495},{196657,757958},{628509,883388}};
        int[] source = new int[]{655988,180910};
        int[] target = new int[]{267728,840949};
        new SolutionD().isEscapePossible(blocked, source, target);
    }

}
