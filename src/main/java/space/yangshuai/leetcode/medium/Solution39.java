package space.yangshuai.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotciv on 2017/1/7.
 */
public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList;
        quickSort(candidates, 0, candidates.length -1);

        for (int i = candidates.length - 1; i >= 0; i--) {
            if (candidates[i] > target) continue;
            subList = new ArrayList<>();
            if (candidates[i] == target) {
                subList.add(candidates[i]);
                list.add(subList);
                continue;
            } else {
                int index = i;
                int remain = target;
                while (true) {
                    if (index > candidates.length - 1) break;
                    if (candidates[index] <= remain) {
                        remain = target - remain;
                        subList.add(index);
                        if (remain == 0) list.add(subList);
                        break;
                    } else {
                        index++;
                    }
                }
            }
        }

        return null;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int index = partition(nums, low, high);
        partition(nums, low, index - 1);
        partition(nums, index + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int compare = nums[low];
        int start = low + 1;
        int end = high;

        while (true) {
            while (compare > nums[start]) {
                if (start == high) break;
                start++;
            }
            while (compare < nums[end]) {
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

}
