package space.yangshuai.ojsolutions.leetcode.medium;

public class Solution918 {

    public int maxSubarraySumCircular(int[] nums) {

        int[] doubleArr = new int[nums.length << 1];
        System.arraycopy(nums, 0, doubleArr, 0, nums.length);
        System.arraycopy(nums, 0, doubleArr, nums.length, nums.length);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < i + nums.length; j++) {
                max = Math.max(max, doubleArr[j]);
                sum += doubleArr[j];
                if (sum < 0) {
                    sum = 0;
                } else {
                    max = Math.max(max, sum);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution918().maxSubarraySumCircular(new int[]{5,-3,5}));
    }
}
