package space.yangshuai.ojsolutions.leetcode.lessons.array.basicalgrithm;

public class MergeArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int tail = m + n - 1;
        m--;
        n--;

        while (true) {
            if (n < 0) {
                return;
            }

            if (m < 0) {
                System.arraycopy(nums2, 0, nums1, 0, n + 1);
                return;
            }

            if (nums1[m] > nums2[n]) {
                nums1[tail] = nums1[m];
                m--;
            } else {
                nums1[tail] = nums2[n];
                n--;
            }
            tail--;
        }

    }

}
