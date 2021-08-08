package space.yangshuai.ojsolutions.leetcode.medium;

public class Solution45 {

    public int jump(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int mostFar = nums[0];
        int start = 1;
        int end = mostFar;
        int count = 1;
        while (mostFar < nums.length - 1) {
            for (int i = start; i <= end; i++) {
                mostFar = Math.max(mostFar, i + nums[i]);
            }
            start = end + 1;
            end = mostFar;
            count++;
        }
        return count;
    }

}
