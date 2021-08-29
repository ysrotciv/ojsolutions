package space.yangshuai.ojsolutions.leetcode.weekly.contest255;

import java.util.Arrays;

public class SolutionA {

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int s = nums[0];
        int b = nums[nums.length - 1];

        while (b % s != 0) {
            int temp = b % s;
            b = s;
            s = temp;
        }

        return s;
    }
}
