package space.yangshuai.ojsolutions.leetcode.hard;

/**
 * Created by rotciv on 2017/1/5.
 */
public class Solution287 {

    public int findDuplicate(int[] nums) {

        int length = nums.length;

        for (int i = 0; i < length; i++) {

            for (int j = i + 1; j < length; j++) {

                if (nums[i] == nums[j])
                    return nums[i];
            }
        }

        return 0;
    }

}
