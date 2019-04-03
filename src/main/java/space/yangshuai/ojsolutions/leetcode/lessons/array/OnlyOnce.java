package space.yangshuai.ojsolutions.leetcode.lessons.array;

/**
 * @author yangshuai on 2019-04-03.
 */
public class OnlyOnce {

    public int singleNumber(int[] nums) {

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
