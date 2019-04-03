package space.yangshuai.ojsolutions.leetcode.lessons.array;

import java.util.Arrays;

/**
 * @author yangshuai on 2019-04-03.
 */
public class ExistsDuplication {

    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }

}
