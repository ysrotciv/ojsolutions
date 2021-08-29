package space.yangshuai.ojsolutions.leetcode.medium;

public class Solution918 {

    public int maxSubarraySumCircular(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] tail = new int[length];
        int[] tailMax = new int[length];
        int[] head = new int[length];

        tail[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            tail[i] = tail[i + 1] + nums[i];
        }
        tailMax[length - 1] = tail[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            tailMax[i] = Math.max(tailMax[i + 1], tail[i]);
        }

        head[0] = nums[0];
        for (int i = 1; i < length; i++) {
            head[i] = head[i - 1] + nums[i];
        }

        for (int i = 1; i < length; i++) {
            max = Math.max(max, tailMax[i] + head[i - 1]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution918().maxSubarraySumCircular(new int[]{-5, -3, -5}));
    }
}
