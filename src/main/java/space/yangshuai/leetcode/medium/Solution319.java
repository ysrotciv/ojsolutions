package space.yangshuai.leetcode.medium;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution319 {

    public int bulbSwitch(int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return (int) Math.floor(Math.sqrt(n));
    }

    public static void main(String[] args) {

        System.out.println(new Solution319().bulbSwitch(99999));
    }
}
