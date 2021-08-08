package space.yangshuai.ojsolutions.leetcode.medium;

public class Solution198 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] money = new int[nums.length];
        money[0] = nums[0];
        money[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        }

        return money[money.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution198().rob(new int[]{2,1,1,2}));
    }

}
