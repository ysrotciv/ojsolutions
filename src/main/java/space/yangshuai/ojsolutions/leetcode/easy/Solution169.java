package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution169 {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int current = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == current) {
                count++;
                continue;
            }
            count--;
            if (count == 0) {
                current = nums[i];
                count++;
            }
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(new Solution169().majorityElement(new int[]{0, 3, 4, 0, 3, 3, 3}));
    }
}
