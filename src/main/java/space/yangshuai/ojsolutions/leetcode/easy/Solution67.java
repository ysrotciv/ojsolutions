package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by rotciv on 2017/2/17.
 */
public class Solution67 {

    public String addBinary(String a, String b) {

        if (a.equals("0")) return b;
        if (b.equals("0")) return a;

        int lengthA = a.length();
        int lengthB = b.length();

        if (a.length() > b.length()) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                b = "0" + b;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                a = "0" + a;
            }
        }

        String result = "";
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        int flag = 0;


        for (int i = arr1.length - 1; i >= 0; i--) {
            int value1 = Character.getNumericValue(arr1[i]);
            int value2 = Character.getNumericValue(arr2[i]);
            int value = value1 + value2 + flag;
            flag = value / 2;
            result = value % 2 + result;
        }

        if (flag == 1) result = 1 + result;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution67().addBinary("101111", "10"));
    }

}
