package space.yangshuai.ojsolutions.leetcode.weekly.contest255;

import java.util.Arrays;

public class SolutionB {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(nums[i], 2);
        }
        Arrays.sort(arr);
        StringBuilder ans = new StringBuilder();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] != index) {
                ans = new StringBuilder(Integer.toBinaryString(i));
                break;
            }
            index++;
        }
        if (ans.length() == 0) {
            return Integer.toBinaryString((int) Math.pow(2, n) - 1);
        }
        while (ans.length() < n) {
            ans.insert(0, "0");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SolutionB().findDifferentBinaryString(new String[]{"00", "01"}));
    }

}
