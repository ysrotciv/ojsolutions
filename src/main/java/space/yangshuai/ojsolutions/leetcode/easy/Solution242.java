package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution242 {

    static int MIN = 97;

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;

        int[] a = new int[26];
        int[] b = new int[26];

        for (int i = 0; i < s.length(); i++) {
            a[Integer.valueOf(s.charAt(i)) - MIN]++;
            b[Integer.valueOf(t.charAt(i)) - MIN]++;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }

        return true;
    }
}
