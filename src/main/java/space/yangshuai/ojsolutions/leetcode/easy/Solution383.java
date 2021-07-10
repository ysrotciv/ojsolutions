package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.Arrays;

/**
 * Created by rotciv on 2017/2/14.
 */
public class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() == 0) return true;
        if (magazine.length() == 0) return false;

        int[] ransomArr = new int[26];
        int[] magazineArr = new int[26];

        for (char c : ransomNote.toCharArray()) {
            ransomArr[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            magazineArr[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (ransomArr[i] > magazineArr[i]) {
                return false;
            }
        }

        return true;
    }

}
