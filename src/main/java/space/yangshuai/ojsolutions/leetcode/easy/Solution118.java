package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        res.add(pre);
        for (int i = 1; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            int left = 0;
            for (int num : pre) {
                current.add(left + num);
                left = num;
            }
            current.add(left);
            res.add(current);
            pre = current;
        }
        return res;
    }
}
