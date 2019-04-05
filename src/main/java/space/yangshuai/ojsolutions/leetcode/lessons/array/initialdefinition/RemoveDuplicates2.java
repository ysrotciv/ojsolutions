package space.yangshuai.ojsolutions.leetcode.lessons.array.initialdefinition;

/**
 * @author yangshuai on 2019-04-02.
 */
public class RemoveDuplicates2 {

    public int removeDuplicates(int[] nums) {

        int i = 0;
        int j = i + 2;

        while (j < nums.length) {
            if (nums[j] != nums[i]) {
                if (j != i + 2) {
                    nums[i + 2] = nums[j];
                }
                i++;
            }
            j++;
        }

        return i;
    }

}
