package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by Administrator on 2015/12/19.
 */
public class Solution258 {

    public int addDigits(int num) {
        if (num == 0)
            return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }
}
