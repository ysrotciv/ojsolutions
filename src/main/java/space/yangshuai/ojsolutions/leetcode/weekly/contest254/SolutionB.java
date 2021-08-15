package space.yangshuai.ojsolutions.leetcode.weekly.contest254;

import java.util.Arrays;

public class SolutionB {

    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] + nums[i + 1] == 2 * nums[i]) {
                if (nums.length - 1 >= i + 2) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i + 2];
                    nums[i + 2] = temp;
                } else {
                    int temp = nums[i + 1];
                    if (nums.length == 3) {
                        nums[i + 1] = nums[i];
                        nums[i] = temp;
                    } else {
                        nums[i + 1] = nums[0];
                        nums[0] = temp;
                    }
                }
            }
        }
        return nums;
    }

}
