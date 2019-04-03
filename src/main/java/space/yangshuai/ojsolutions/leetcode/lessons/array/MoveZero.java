package space.yangshuai.ojsolutions.leetcode.lessons.array;

import java.util.Arrays;

/**
 * @author yangshuai on 2019-04-03.
 */
public class MoveZero {

    public void moveZeroes(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                if (i != index) {
                    nums[index++] = nums[i];
                    nums[i] = 0;
                } else {
                    index++;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new MoveZero().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
