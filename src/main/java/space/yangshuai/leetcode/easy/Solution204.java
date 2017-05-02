package space.yangshuai.leetcode.easy;

import java.util.*;

/**
 * Created by shuai.yang on 2015/5/21.
 */
public class Solution204 {

    public int countPrimes(int n) {

        if (n <= 2)
            return 0;

        boolean[] array = new boolean[n];
        Arrays.fill(array, Boolean.TRUE);
        array[0] = false;
        array[1] = false;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (array[i]) {
                for (int j = i * i; j < n; j += i) {
                    array[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean i : array) {
            if (i)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Solution204 solution = new Solution204();
        System.out.println(solution.countPrimes(499979));

        System.out.println(System.currentTimeMillis() - start);
    }
}
