package space.yangshuai.ojsolutions.leetcode.easy;


/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution27 {

    public int removeElement(int[] nums, int val) {

        int lastIndex = nums.length - 1;

        for (int i = 0; i < lastIndex + 1; i++) {
            if (nums[i] == val) {
                nums[i] = nums[lastIndex];
                lastIndex--;
                i--;
            }
        }

        return lastIndex + 1;
    }
}
