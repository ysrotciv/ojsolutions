package space.yangshuai.leetcode.medium;

/**
 * Created by Yang on 2017/1/3.
 */
public class Solution477 {
    public static int totalHammingDistance(int[] nums) {

        int sum = 0;
        int count;
        int length = nums.length;

        for (int j = 0; j < 31; j++) {

            count  = 0;

            for (int i = 0; i < length; i++) {
                if ((nums[i] >> j & 1) == 1)
                    count++;
            }

            if (count != 0 && count != length) {
                sum += (length - count) * count;
            }

        }

        return sum;
    }

    public static void main(String[] args) {

        totalHammingDistance(new int[]{4, 14, 2});

    }
}
