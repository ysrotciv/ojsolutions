package space.yangshuai.ojsolutions.leetcode.easy;

public class Solution121 {

    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price - buy > max) {
                max = price - buy;
            }
            if (price < buy) {
                buy = price;
            }
        }
        return max;
    }
}
