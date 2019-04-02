package space.yangshuai.ojsolutions.leetcode.contest.contest28;

/**
 * Created by rotciv on 2017/4/16.
 */
public class Solution553 {

    public String optimalDivision(int[] nums) {

        if (nums.length == 1) {
            return nums[0] + "";
        }

        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                builder.append(nums[i]);
            } else if (i == 1) {
                builder.append("/(");
                builder.append(nums[i]);
            } else {
                builder.append('/');
                builder.append(nums[i]);
            }
        }
        builder.append(')');

        return builder.toString();
    }



    public static void main(String[] args) {
        System.out.println(new Solution553().optimalDivision(new int[]{1000,100,10,2}));
    }
}
