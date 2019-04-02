package space.yangshuai.ojsolutions.leetcode.common;

/**
 * Created by Yang on 2017/1/3.
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array = new int[]{2,3,4,5,6,7,8,1};
        quickSort(array, 0, array.length - 1);

        for (int num : array) {
            System.out.println(num);
        }

    }

    public static void quickSort(int[] nums, int low, int high) {

        if (high <= low) return;
        int j = partition(nums, low, high);
        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, high);
    }

    public static int partition(int[] nums, int low, int high) {

        int compare = nums[low];
        int start = low + 1;
        int end = high;

        while (true) {
            while (nums[start] <= compare) {
                if (start == high) break;
                start++;
            }

            while (nums[end] >= compare) {
                if (end == low) break;
                end--;
            }

            if (start >= end) break;

            swap(nums, start, end);
        }

        swap(nums, low, end);

        return end;
    }

    public static void swap(int[] nums, int i, int j) {
       int temp = nums[i];
       nums[i] = nums[j];
       nums[j] = temp;
    }
}
