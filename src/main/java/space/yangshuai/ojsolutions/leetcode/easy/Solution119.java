package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long pre = 1;
        list.add((int)pre);
        for (int i = 1; i < rowIndex + 1; i++) {
            pre = pre * (rowIndex + 1 - i) / i;
            list.add((int)pre);
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution119().getRow(5));
    }
}
