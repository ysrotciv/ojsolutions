package space.yangshuai.ojsolutions.leetcode.easy;

public class Solution35 {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = (left + right) / 2;
            if (nums[index] < target) {
                left = index + 1;
            } else if (nums[index] > target) {
                right = index - 1;
            } else {
                return index;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        Solution35 solution35 = new Solution35();
        System.out.println(solution35.searchInsert(arr, 7));
    }
}
