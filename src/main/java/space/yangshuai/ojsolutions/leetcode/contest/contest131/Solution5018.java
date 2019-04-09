package space.yangshuai.ojsolutions.leetcode.contest.contest131;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangshuai on 2019-04-07.
 */
public class Solution5018 {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        return Arrays.stream(queries).map(query -> check(query, pattern)).collect(Collectors.toList());
    }

    private boolean check(String query, String pattern) {

        int index = 0;
        int pChar = pattern.charAt(index);

        for (int i = 0; i < query.length(); ++i) {
            char c = query.charAt(i);
            if (c != pChar) {
                if (Character.isUpperCase(c)){
                    return false;
                }
            } else {
                index++;
                if (index >= pattern.length()) {
                    pChar = '&';
                } else {
                    pChar = pattern.charAt(index);
                }
            }
        }

        return index == pattern.length();
    }


}
