package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution231 {

    public boolean isPowerOfTwo(int n) {

        if (n <= 0)
            return false;

        char[] arr = Integer.toBinaryString(n).toCharArray();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '1')
                return false;
        }

        return true;
    }
}
