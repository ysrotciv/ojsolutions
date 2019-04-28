package space.yangshuai.ojsolutions.leetcode.lessons.stack;

/**
 * @author yangshuai on 2019-04-24.
 */
public class SumOfTarget {

    private int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        sum(S, 0, nums, 0);
        return count;
    }

    private void sum(int S, int pre, int[] nums, int index) {
        if (index == nums.length - 1) {
            if (pre + nums[index] == S) {
                count += 1;
            }
             if (pre - nums[index] == S) {
                 count += 1;
             }
        } else {
            sum(S, pre + nums[index], nums,index + 1);
            sum(S, pre - nums[index], nums,index + 1);
        }
    }

}
