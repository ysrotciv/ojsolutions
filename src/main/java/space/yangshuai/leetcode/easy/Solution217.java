package space.yangshuai.leetcode.easy;

import java.util.HashSet;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {

        if (nums.length <= 1) return false;

        quickSort(nums, 0, nums.length - 1);

        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]) return true;
            temp = nums[i];
        }

        return false;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (high <= low) return;
        int index = partition(nums, low, high);
        quickSort(nums, low, index - 1);
        quickSort(nums, index + 1, high);
    }

    private int partition(int[] nums, int low, int high) {

        int compare = nums[low];
        int start = low + 1;
        int end = high;

        while (true) {

            while (nums[start] < compare) {
                if (start == high) break;
                start++;
            }
            while (nums[end] > compare) {
                if (end == low) break;
                end--;
            }

            if (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            } else {
                break;
            }
        }

        swap(nums, low, end);

        return end;
    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution217().containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

}
