package space.yangshuai.ojsolutions.leetcode.lessons.array;

/**
 * @author yangshuai on 2019-04-02.
 */
public class RemoveDuplication {

    public int removeDuplicates(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        int index = 0;
        int previous = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != previous) {
                previous = nums[i];
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

}
