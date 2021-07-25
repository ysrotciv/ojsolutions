package space.yangshuai.ojsolutions.leetcode.easy;

public class Solution746 {

    public int minCostClimbingStairs(int[] cost) {
        int[] arr = new int[cost.length];
        System.arraycopy(cost, 0, arr, 0, 2);
        for (int i = 2; i < cost.length; i++) {
            arr[i] = Math.min(arr[i - 1], arr[i - 2]) + cost[i];
        }
        return Math.min(arr[cost.length - 1], arr[cost.length - 2]);
    }

}
