package space.yangshuai.ojsolutions.leetcode.lessons.array.basicalgrithm;

import java.util.Arrays;

/**
 * @author yangshuai on 2019-04-07.
 */
public class ColorClassification {

    public void sortColors(int[] nums) {

        int i = 0;
        int lt = -1;
        int gt = nums.length;

        while (i < gt) {
            if (nums[i] == 0) {
                lt++;
                swap(nums, lt, i);
                i++;
            } else if (nums[i] == 2) {
                gt--;
                swap(nums, gt, i);
            } else {
                i++;
            }
        }

    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0};
        int[] arr2 = new int[]{2, 0};
        int[] arr3 = new int[]{0, 0};
        int[] arr4 = new int[]{1, 1};
        int[] arr5 = new int[]{2, 0, 2, 1, 1, 0};
        new ColorClassification().sortColors(arr1);
        System.out.println(Arrays.toString(arr1));
        /*new ColorClassification().sortColors(arr2);
        System.out.println(Arrays.toString(arr2));
        new ColorClassification().sortColors(arr3);
        System.out.println(Arrays.toString(arr3));
        new ColorClassification().sortColors(arr4);
        System.out.println(Arrays.toString(arr4));*/
//        new ColorClassification().sortColors(arr5);
//        System.out.println(Arrays.toString(arr5));
    }
}
