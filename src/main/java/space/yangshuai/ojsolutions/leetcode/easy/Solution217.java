package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution217().containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

}
