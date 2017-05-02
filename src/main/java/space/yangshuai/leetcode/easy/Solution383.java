package space.yangshuai.leetcode.easy;

import java.util.Arrays;

/**
 * Created by rotciv on 2017/2/14.
 */
public class Solution383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() == 0) return true;
        if (magazine.length() == 0) return false;

        char[] ransom = ransomNote.toCharArray();
        char[] maga = magazine.toCharArray();
        Arrays.sort(ransom);
        Arrays.sort(maga);

        int i = 0, j = 0;
        while (true) {
            if (ransom[i] == maga[j]) {
                i++;
                j++;
            } else {
                j++;
            }
            if (i == ransom.length) return true;
            if (j == maga.length) return false;

        }
    }

}
