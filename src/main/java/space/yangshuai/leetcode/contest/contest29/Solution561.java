package space.yangshuai.leetcode.contest.contest29;

import java.util.Arrays;

/**
 * Created by rotciv on 2017/4/23.
 */
public class Solution561 {

    public int arrayPairSum(int[] nums) {

        int sum = 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution561().arrayPairSum(new int[]{1, 4, 3, 2}));
    }

}
