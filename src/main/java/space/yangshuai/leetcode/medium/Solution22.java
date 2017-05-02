package space.yangshuai.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotciv on 2017/2/14.
 */
public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 1) {
            list.add("()");
            return list;
        }

        for (String str: allPermutation(n - 1, n - 1)) {
            list.add('(' + str + ')');
        }
        return list;
    }

    private ArrayList<String> allPermutation(int left, int right) {

        int length = left + right;
        ArrayList<String> list = new ArrayList<>();

        if (left == 1) {
            for (int i = 0; i <= right; i++) {
                String str = createInitString(false, length);
                StringBuilder builder = new StringBuilder(str);
                builder.setCharAt(i, '(');
                str = builder.toString();
                list.add(str);
            }
            return list;
        }
        if (right == 1) {
            for (int i = 1; i <= left; i++) {
                String str = createInitString(true, length);
                StringBuilder builder = new StringBuilder(str);
                builder.setCharAt(i, ')');
                str = builder.toString();
                list.add(str);
            }
            return  list;
        }


        ArrayList<String> leftList = allPermutation(left - 1, right);
        for (String str: leftList) {
            list.add('(' + str);
        }

        if (right + 1 > left) {
            ArrayList<String> rightList = allPermutation(left, right - 1);
            for (String str: rightList) {
                list.add(')' + str);
            }
        }

        return list;
    }

    private String createInitString(boolean left, int n) {
        char element = left ? '(' : ')';
        String result = "";
        for (int i = 0; i < n; i++) {
            result += element;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
//        System.out.println(solution22.createInitString(true, 10));
        System.out.println(solution22.generateParenthesis(3));
    }
}
