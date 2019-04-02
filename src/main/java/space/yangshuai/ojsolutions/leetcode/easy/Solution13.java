package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.HashMap;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution13 {

    public int romanToInt(String s) {

        HashMap<Character, Integer> dict = new HashMap<>();

        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        int value = 0;
        int tempValue = 0;
        boolean flag = false;

        for (int i = s.length() - 1; i >= 0; i--) {

            char temp = s.charAt(i);
            int charValue = dict.get(temp);


            if (tempValue == charValue) {
                if (flag) {
                    value -= charValue;
                } else {
                    value += charValue;
                }
            } else if (charValue < tempValue) {
                value -= charValue;
                flag = true;
            } else {
                if (flag) {
                    flag = false;
                }
                value += charValue;
            }
            tempValue = charValue;
        }

        return value;
    }

    public static void main(String[] args) {
        System.out.println(new Solution13().romanToInt("LXXX"));
    }
}
