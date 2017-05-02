package space.yangshuai.leetcode.easy;

import java.util.LinkedList;

/**
 * Created by rotciv on 2017/1/5.
 */
public class Solution414 {

    public int thirdMax(int[] nums) {

        LinkedList<Integer> tops = new LinkedList();

        for (int num : nums) {

            if (compare(tops, num, 0)) continue;

            if (compare(tops, num, 1)) continue;

            if (compare(tops, num, 2)) continue;

        }

        if (tops.size() < 3)
            return tops.get(0);

        return tops.get(2);
    }

    private boolean compare(LinkedList<Integer> tops, int num, int index) {
        if (tops.size() == index) {
            tops.add(num);
            return true;
        }
        if (num > tops.get(index)) {
            tops.add(index, num);
            if (tops.size() > 3) tops.remove(3);
            return true;
        }
        if (num == tops.get(index))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution414().thirdMax(new int[]{5, 2, 2}));
    }
}
