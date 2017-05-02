package space.yangshuai.leetcode.easy;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution191 {

    public int hammingWeight(int n) {

        long value = n;

        if (n < 0) {
            value = 1l + n - Integer.MIN_VALUE + Integer.MAX_VALUE;
        }

        int count = 0;

        while (value > 0) {
            if (value % 2 == 1)
                count++;
            value /= 2;
        }

        return count;
    }

    public static void main (String[] args) {
        System.out.println(new Solution191().hammingWeight((int)4294967295l));

    }
}
