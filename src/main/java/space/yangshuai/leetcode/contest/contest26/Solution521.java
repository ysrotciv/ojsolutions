package space.yangshuai.leetcode.contest.contest26;

/**
 * Created by rotciv on 2017/4/2.
 */
public class Solution521 {

    public int findLUSlength(String a, String b) {

        if (a.length() != b.length()) {
            return max(a.length(), b.length());
        }

        if (!a.equals(b)) {
            return a.length();
        } else {
            return -1;
        }

    }

    private int max(int a, int b) {
        if (a > b) return a;
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution521().findLUSlength("aaa", "aaa"));
    }

}
