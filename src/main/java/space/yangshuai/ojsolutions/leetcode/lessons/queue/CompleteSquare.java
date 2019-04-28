package space.yangshuai.ojsolutions.leetcode.lessons.queue;

import java.util.LinkedList;

/**
 * @author yangshuai on 2019-04-22.
 */
public class CompleteSquare {

    int[] arr;
    LinkedList<Node> queue = new LinkedList<>();

    public int numSquares(int n) {

        int max = (int)Math.floor(Math.sqrt(n));
        arr = new int[max];
        for (int i = 0; i < max; ++i) {
            arr[i] = (i + 1) * (i + 1);
        }

        queue.add(new Node(n, 0, n));
        while (queue.size() > 0) {
            Node node = queue.pop();
            if (node.value == 0) {
                return node.level;
            } else {
                search(node);
            }
        }

        return -1;
    }

    private class Node {
        int previous;
        int value;
        int level;
        Node (int value, int level, int previous) {
            this.level = level;
            this.value = value;
            this.previous = previous;
        }
    }

    private void search(Node node) {
        for (int i = arr.length - 1; i >= 0; --i) {
            if (arr[i] <= node.value && arr[i] <= node.previous) {
                Node newNode = new Node(node.value - arr[i], node.level + 1, arr[i]);
                queue.add(newNode);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CompleteSquare().numSquares(7168));
    }

}
