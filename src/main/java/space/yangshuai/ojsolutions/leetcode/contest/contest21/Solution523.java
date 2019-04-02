package space.yangshuai.ojsolutions.leetcode.contest.contest21;

/**
 * Created by rotciv on 2017/2/25.
 */
public class Solution523 {

    public boolean checkSubarraySum(int[] nums, int k) {

        if (nums == null) return false;
        if (nums.length < 2) return false;

        if (k == 0) {
            for (int i = 0; i < nums.length - 1; ++i) {
                if (nums[i] == 0 && nums[i + 1] == 0) return true;
            }
            return false;
        }

        if (k == 1) return true;

        for (int i = 2; i <= nums.length; ++i) {
            for (int j = 0; j <= nums.length - i; ++j) {
                int sum = 0;
                for (int l = j; l < j + i; ++l) {
                    sum += nums[l];
                }
                if (sum % k == 0) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution523().checkSubarraySum(new int[]{1, 2, 3}, 5));
    }
}
