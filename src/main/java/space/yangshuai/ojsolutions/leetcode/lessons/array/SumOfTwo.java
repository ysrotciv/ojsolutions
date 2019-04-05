package space.yangshuai.ojsolutions.leetcode.lessons.array;

import java.util.Arrays;

public class SumOfTwo {

    public int[] twoSum(int[] nums, int target) {

        Arrays.sort(nums);
        int head = 0;
        int tail = nums.length - 1;
        int sum = nums[head] + nums[tail];
        while (sum != target) {
            if (sum > target) {
                tail--;
            } else {
                head++;
            }
        }

        return new int[]{head, tail};
    }

}
