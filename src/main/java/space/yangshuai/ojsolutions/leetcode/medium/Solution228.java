package space.yangshuai.ojsolutions.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotciv on 2017/1/7.
 */
public class Solution228 {

    public List<String> summaryRanges(int[] nums) {

        ArrayList<String> list = new ArrayList<>();
        if (nums.length == 0) return list;

        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }

        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            } else if (start == nums[i - 1]) {
                list.add(String.valueOf(start));
                start =  nums[i];
            } else {
                list.add(start + "->" + nums[i - 1]);
                start = nums[i];
            }
        }

        if (start == nums[nums.length - 1]) {
            list.add(String.valueOf(start));
        } else {
            list.add(start + "->" + nums[nums.length - 1]);
        }

        return list;
    }

}
