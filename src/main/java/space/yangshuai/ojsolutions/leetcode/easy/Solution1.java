package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangshuai on 2019-02-19.
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexes = new HashMap<>(nums.length << 1);
        for (int i = 0; i < nums.length; ++i) {
            int head = nums[i];
            if (indexes.get(head) != null) {
                return new int[]{i, indexes.get(head)};
            }
            indexes.put(target - head, i);
        }

        return null;
    }

}
