package space.yangshuai.ojsolutions.leetcode.lessons.array.initialdefinition;

/**
 * @author yangshuai on 2019-04-05.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                if (i != index) {
                    nums[index++] = nums[i];
                    nums[i] = val;
                } else {
                    index++;
                }
            }
        }
        return index;
    }
}
