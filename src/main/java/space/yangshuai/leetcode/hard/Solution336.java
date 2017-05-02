package space.yangshuai.leetcode.hard;

import java.util.*;

/**
 * Created by rotciv on 2017/2/15.
 */
public class Solution336 {

    public List<List<Integer>> palindromePairs(String[] words) {

        return null;
    }

    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution336().isPalindrome("battab"));
        System.out.println(new Solution336().isPalindrome("battaab"));
        Map<Character, List<String>> headMap = new HashMap<>();
        System.out.println(headMap.get('c'));
        String[] words = new String[]{"a", ""};
        System.out.println(new Solution336().palindromePairs(words));
    }

}
