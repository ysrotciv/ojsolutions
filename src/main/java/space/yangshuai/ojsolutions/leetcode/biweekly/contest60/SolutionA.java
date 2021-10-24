package space.yangshuai.ojsolutions.leetcode.biweekly.contest60;

public class SolutionA {

    public int findMiddleIndex(int[] nums) {

        int length = nums.length;
        if (length == 1) {
            return 0;
        }

        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        leftSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = nums[i] + leftSum[i - 1];
        }

        rightSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = nums[i] + rightSum[i + 1];
        }

        if (rightSum[1] == 0) {
            return 0;
        }
        for (int i = 2; i < length; i++) {
            if (leftSum[i - 2] == rightSum[i]) {
                return i - 1;
            }
        }
        if (leftSum[length - 2] == 0) {
            return length - 1;
        }

        return -1;
    }
}
