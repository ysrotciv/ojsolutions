package space.yangshuai.ojsolutions.leetcode.weekly.contest256;

import java.util.Arrays;

public class SolutionA {

    public int minimumDifference(int[] nums, int k) {

        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int temp = nums[i + k - 1] - nums[i];
            if (temp < diff) {
                diff = temp;
            }
        }
        return diff;
    }

}
