package space.yangshuai.leetcode.easy;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution169 {

    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) candidate = num;
            if (candidate == num)
                count++;
            else
                count--;
        }

        return candidate;
    }

    public static void main(String[] args) {
        new Solution169().majorityElement(new int[]{0, 3, 4, 0});
    }
}
