package space.yangshuai.leetcode.easy;

/**
 * Created by rotciv on 2017/2/14.
 */
public class Solution459 {

    public boolean repeatedSubstringPattern(String str) {
        int length = str.length();
        outer: for (int i = 1; i <= str.length() / 2; i++) {
            if (length % i != 0) continue;
            String sub = str.substring(0, i);
            for (int j = 1; j < length / i; j++) {
                String substring = str.substring(j * i, j * i + i);
                if (!sub.equals(substring)) continue outer;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("abab".substring(0, 1));
        System.out.println(new Solution459().repeatedSubstringPattern("ababa"));
    }
}
