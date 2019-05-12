package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangshuai on 2019-05-10.
 */
public class DupElementVersionThree {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

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
        new DupElementVersionThree().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
    }

}
