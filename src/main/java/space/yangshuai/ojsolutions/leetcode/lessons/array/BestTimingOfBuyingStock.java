package space.yangshuai.ojsolutions.leetcode.lessons.array;

/**
 * @author yangshuai on 2019-04-02.
 */
public class BestTimingOfBuyingStock {

    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        int buy = prices[0];
        int sell = buy;
        int profit = 0;

        for (int i = 1; i < prices.length; ++i) {

            int current = prices[i];

            if (current < sell) {
                if (sell > buy) {
                    profit += (sell - buy);
                }
                buy = current;
            }
            sell = current;

        }

        profit += (sell - buy);

        return profit;
    }

}
