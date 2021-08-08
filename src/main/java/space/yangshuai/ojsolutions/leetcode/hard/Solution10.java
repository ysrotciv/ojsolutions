package space.yangshuai.ojsolutions.leetcode.hard;

import java.util.Objects;

public class Solution10 {

    public boolean isMatch(String s, String p) {

        if (Objects.equals(p, ".*")) {
            return true;
        }

        int sIndex = s.length() - 1;
        int pIndex = p.length() - 1;

        while (sIndex >= 0 && pIndex >= 0) {
            char c = p.charAt(pIndex);
            if (p.charAt(pIndex) == '*') {
                c = p.charAt(pIndex - 1);
                if (c == '.') {
                    return pIndex + 1 == p.length() - 1;
                } else {
                    while (sIndex < s.length() && s.charAt(sIndex) == c) {
                        sIndex++;
                    }
                }
                pIndex += 2;
            } else {
                if (p.charAt(sIndex) != '.' && s.charAt(sIndex) != c) {
                    return false;
                }
                sIndex++;
                pIndex += 1;
            }
        }

        return pIndex == p.length() && sIndex == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution10().isMatch("aaa", "a*a"));
    }
}
