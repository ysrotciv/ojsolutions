package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by Yang on 2017/1/3.
 */
public class Solution461 {

    public int hammingDistance(int x, int y) {

        int xor = x ^ y, count = 0;
        for (int i=0;i<32;i++) count += (xor >> i) & 1;
        return count;
    }

}
