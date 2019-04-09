package space.yangshuai.ojsolutions.leetcode.lessons.array.basicalgrithm;

import java.util.Arrays;

/**
 * @author yangshuai on 2019-04-07.
 */
public class ColorClassification {

    public void sortColors(int[] nums) {

        if (nums.length == 1) {
            return;
        }

        int head = 0;
        int tail = nums.length - 1;
        int start = head;
        int end = tail;

        while (true) {

            while (nums[start] != 2 && start < end) {
                if (nums[start] == 0) {
                    if (start != head) {
                        nums[head] = 0;
                        nums[start] = 1;
                    }
                    head++;
                }
                start++;
            }

            while (nums[end] != 0 && start < end) {
                if (nums[end] == 2) {
                    if (end != tail) {
                        nums[tail] = 2;
                        nums[end] = 1;
                    }
                    tail--;
                }
                end--;
            }

            if (start >= end) {
                return;
            }

            nums[head++] = 0;
            nums[tail--] = 2;
            start++;
            end--;
        }

    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{0};
        int[] arr2 = new int[]{2, 0};
        int[] arr3 = new int[]{0, 0};
        int[] arr4 = new int[]{1, 1};
        int[] arr5 = new int[]{2,0,2,1,1,0};
        /*new ColorClassification().sortColors(arr1);
        System.out.println(Arrays.toString(arr1));
        new ColorClassification().sortColors(arr2);
        System.out.println(Arrays.toString(arr2));
        new ColorClassification().sortColors(arr3);
        System.out.println(Arrays.toString(arr3));
        new ColorClassification().sortColors(arr4);
        System.out.println(Arrays.toString(arr4));*/
        new ColorClassification().sortColors(arr5);
        System.out.println(Arrays.toString(arr5));
    }
}
