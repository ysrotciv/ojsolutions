package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.Arrays;

public class Solution455 {

    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for (int num : g) {
            while (true) {
                if (index >= s.length) {
                    return res;
                }
                if (s[index] >= num) {
                    res++;
                    index++;
                    break;
                } else {
                    index++;
                }
            }
        }
        return res;
    }

}
