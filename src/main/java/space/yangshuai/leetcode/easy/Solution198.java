package space.yangshuai.leetcode.easy;

import java.util.Arrays;

/**
 * Created by shuai.yang on 2015/5/21.
 */
public class Solution198 {

    private int sum = 0;
    private int[] nums;
    private int[] temp;

    public int rob(int[] nums) {

        this.nums = nums;
        temp = new int[nums.length];
        Arrays.fill(temp, -1);

        robHouse(0, 0);
        robHouse(0, 1);

        return sum;
    }

    private void robHouse(int sum, int index) {
        if (index > nums.length - 1) {
            if (sum > this.sum)
                this.sum = sum;
        } else {
            sum += nums[index];
            if (sum > temp[index]) {
                temp[index] = sum;
            } else if (temp[index] > -1) {
                return;
            }
            robHouse(sum, index + 2);
            robHouse(sum, index + 3);
        }
    }

    public static void main(String[] args) {

        int[] input = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//        int[] input = new int[]{111, 10, 1, 3, 3, 4};
        Solution198 solution = new Solution198();
        System.out.println(solution.rob(input));
    }
}
