package space.yangshuai.ojsolutions.leetcode.easy;

public class Solution977 {

    public int[] sortedSquares(int[] nums) {

        int[] res = new int[nums.length];

        int left, right;
        if (nums[0] >= 0) {
            left = -1;
            right = 0;
        } else if (nums[nums.length - 1] <= 0) {
            left = nums.length - 1;
            right = nums.length;
        } else {
            left = 0;
            right = 1;
            while (!(nums[left] <= 0 && nums[right] >= 0)) {
                left++;
                right++;
            }
        }

        int index = 0;
        while (left >= 0 || right <= nums.length - 1) {
            if (left < 0) {
                res[index++] = nums[right] * nums[right++];
                continue;
            }
            if (right >= nums.length) {
                res[index++] = nums[left] * nums[left--];
                continue;
            }
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[index++] = nums[right] * nums[right++];
            } else {
                res[index++] = nums[left] * nums[left--];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4,-1,0,3,10};
        new Solution977().sortedSquares(arr);
    }
}
