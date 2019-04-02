package space.yangshuai.ojsolutions.leetcode.contest.contest30;

import java.util.Arrays;

/**
 * Created by rotciv on 2017/4/30.
 */
public class Solution567 {

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] f = new int[26];
        for(int i = 0;i < n;i++){
            f[s1.charAt(i)-'a']++;
        }
        int[] g = new int[26];
        for(int i = 0;i < m;i++){
            g[s2.charAt(i)-'a']++;
            if(i >= n){
                g[s2.charAt(i-n)-'a']--;
            }
            if(Arrays.equals(f, g))return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution567().checkInclusion("abcda",
                "axaxaxaxaxbxbxbxbxcbadasdfdasf"));
    }

}
