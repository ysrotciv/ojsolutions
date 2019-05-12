package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangshuai on 2019-05-10.
 */
public class DupElementVersionTwo {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>(k >> 1);

        for (int i = 0; i < Math.min(nums.length, k + 1); ++i) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        for (int i = k + 1; i < nums.length; ++i) {
            set.remove(nums[i - k - 1]);
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        new DupElementVersionTwo().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1);
    }

}
