package space.yangshuai.ojsolutions.leetcode.lessons.array.basicalgrithm;

public class MaxKthNumber {

    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;

        int index = quickSort(nums, l, r, k);

        return nums[index];
    }

    private int quickSort(int[] arr, int l, int r, int k) {

        int index = partition(arr, l, r);
        if (index + 1 == k) {
            return index;
        } else if (index + 1 > k) {
            return quickSort(arr, l, index - 1, k);
        } else {
            return quickSort(arr, index + 1, r, k);
        }

    }

    private int partition(int[] arr, int l, int r) {

        int value = arr[l];
        int i = l;
        int j = l + 1;
        while (j <= r) {
            if (arr[j] >= value) {
                swap(arr, ++i, j);
            }
            j++;
        }
        swap(arr, l, i);
        return i;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3,1,2,4,5,5,6};
        new MaxKthNumber().findKthLargest(arr, 4);
    }
}
