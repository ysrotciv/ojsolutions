package space.yangshuai.ojsolutions.leetcode.lessons.array.initialdefinition;

/**
 * @author yangshuai on 2019-04-03.
 */
public class MoveZero {

    public void moveZeroes(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0 && i != index) {
                nums[index++] = nums[i];
                nums[i] = 0;
            }
        }

    }

}
