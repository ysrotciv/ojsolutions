package space.yangshuai.ojsolutions.leetcode.weekly.contest30;

/**
 * Created by rotciv on 2017/4/30.
 */
public class Solution560 {

    public int subarraySum(int[] nums, int k) {

        int length = nums.length;
        int[] m = new int[length];
        int count = 0;

        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                if (i > j) {
                    continue;
                }
                if (i == j) {
                    m[j] = nums[i];
                } else {
                    m[j] = m[j - 1] + nums[j];
                }
                if (m[j] == k) {
                    count++;
                }
            }
        }

        return count;
    }

}
