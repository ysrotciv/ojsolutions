package space.yangshuai.ojsolutions.leetcode.weekly.contest137;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionD {

    public int lastStoneWeightII(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                }
                return 1;
            }
        });

        for (int stone : stones) {
            queue.add(stone);
        }

        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if (a != b) {
                queue.add(Math.abs(a - b));
            }
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }

    public static void main(String[] args) {
        new SolutionA().lastStoneWeight(new int[]{31,26,33,21,40});

    }
}
