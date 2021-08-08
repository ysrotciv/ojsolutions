package space.yangshuai.ojsolutions.leetcode.weekly.contest248;

public class SolutionA {

    public int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[nums[i]];
        }
        return arr;
    }
}
