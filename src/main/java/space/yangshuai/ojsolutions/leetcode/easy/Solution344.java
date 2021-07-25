package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by Administrator on 2016/8/6.
 */
public class Solution344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

}
