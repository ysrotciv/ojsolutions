package space.yangshuai.ojsolutions.leetcode.contest.contest135;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yangshuai on 2019-05-05.
 */
public class SolutionD {

    int min = Integer.MAX_VALUE;
    int max = 0;

    class Node {
        int[] stones;
        int count;
        Node(int[] stones, int count) {
            this.stones = stones;
            this.count = count;
        }
    }

    public int[] numMovesStonesII(int[] stones) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.push(new Node(stones, 0));
        while (queue.size() > 0) {
            Node node = queue.pop();
            int length = node.stones.length;
            Arrays.sort(node.stones);
            int head = node.stones[0];
            int tail = node.stones[length - 1];
            if (tail - head == length - 1) {
                if (min > node.count) {
                    min = node.count;
                }
                continue;
            }
            Set<Integer> set = Arrays.stream(node.stones).boxed().collect(Collectors.toSet());
            for (int i = node.stones[1] + 1; i < tail; ++i) {
                if (!set.contains(i)) {
                    int[] newStones = new int[length];
                    System.arraycopy(node.stones, 0, newStones, 0, length);
                    newStones[0] = i;
                    queue.push(new Node(newStones, node.count + 1));
                    if (node.count + 1 > max) {
                        max = node.count + 1;
                    }
                }
            }
            for (int i = head + 1; i < node.stones[length - 2]; ++i) {
                if (!set.contains(i)) {
                    int[] newStones = new int[node.stones.length];
                    System.arraycopy(node.stones, 0, newStones, 0, length);
                    newStones[length - 1] = i;
                    queue.push(new Node(newStones, node.count + 1));
                    if (node.count + 1 > max) {
                        max = node.count + 1;
                    }
                }
            }
        }

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        new SolutionD().numMovesStonesII(new int[]{7, 4, 9});
    }

}
