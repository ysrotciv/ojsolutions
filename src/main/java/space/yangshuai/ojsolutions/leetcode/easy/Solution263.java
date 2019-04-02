package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution263 {

    public boolean isUgly(int num) {

        if (num < 1)
            return false;

        if (num < 7)
            return true;

        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }

        if (num > 1)
            return false;

        return true;
    }
}
