package space.yangshuai.leetcode.easy;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution70 {

    public int climbStairs(int n) {

        n++;
        double phi = (1 + Math.pow(5, 0.5)) / 2;
        return (int)(Math.round(Math.pow(phi, n) / Math.pow(5, 0.5)));
    }

    public static void main(String[] args) {

        System.out.println(new Solution70().climbStairs(44));
    }
}
