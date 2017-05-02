package space.yangshuai.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rotciv on 2017/2/15.
 */
public class Solution17 {

    Map<Integer, String> map = new HashMap<>();


    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) return new ArrayList<>();

        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        return allPermutation(digits, 0);
    }

    private List<String> allPermutation(String digits, int index) {

        int length = digits.length();
        int digit = Integer.valueOf(digits.substring(index, index + 1));
        String value = map.get(digit);
        List<String> list = new ArrayList<>();
        if (index == length - 1) {
            for (char c: value.toCharArray()) {
                list.add(c + "");
            }
        } else {
            List<String> subList = allPermutation(digits, index + 1);
            for (char c: value.toCharArray()) {
                for (String str: subList) {
                    list.add(c + str);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution17().letterCombinations("23"));
    }
}
