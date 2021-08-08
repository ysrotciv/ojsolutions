package space.yangshuai.ojsolutions.leetcode.medium;

public class Solution213 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, nums.length - 2), robRange(nums, 1, nums.length - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int[] money = new int[nums.length];
        money[start] = nums[start];
        money[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        }
        return money[end];
    }

    public static void main(String[] args) {
        System.out.println(new Solution213().rob(new int[]{2, 3, 2}));
    }

}
