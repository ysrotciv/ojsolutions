package space.yangshuai.ojsolutions.leetcode.medium;

public class Solution55 {

    public boolean canJump(int[] nums) {

        int mostFar = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (mostFar < i) {
                return false;
            }
            mostFar = Math.max(mostFar, i + nums[i]);
        }

        return mostFar >= nums.length - 1;
    }
}
