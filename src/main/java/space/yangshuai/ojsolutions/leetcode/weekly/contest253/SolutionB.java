package space.yangshuai.ojsolutions.leetcode.weekly.contest253;

import java.util.Collections;
import java.util.PriorityQueue;

public class SolutionB {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(piles.length, Collections.reverseOrder());
        for (int pile : piles) {
            queue.add(pile);
        }

        while (k > 0) {
            if (queue.peek() == 1) {
                break;
            }
            int value = queue.poll();
            queue.add(value - value / 2);
            k--;
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            ans += queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionB().minStoneSum(new int[]{1}, 3));
    }

}
