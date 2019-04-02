package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by rotciv on 2017/2/15.
 */
public class Solution434 {

    public int countSegments(String s) {
        String trimed = s.trim();
        if (trimed.isEmpty()) return 0;
        return trimed.split("\\s+").length;
    }

}
