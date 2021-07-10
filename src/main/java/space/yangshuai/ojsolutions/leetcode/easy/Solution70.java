package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution70 {

    /*public int climbStairs(int n) {
        n++;
        double phi = (1 + Math.pow(5, 0.5)) / 2;
        return (int)(Math.round(Math.pow(phi, n) / Math.pow(5, 0.5)));
    }*/

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        int a = 2;
        int b = 3;
        int res = 0;
        for (int i = 4; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }


    public static void main(String[] args) {

        System.out.println(new Solution70().climbStairs(44));
    }
}
