package space.yangshuai.ojsolutions.leetcode.weekly.contest256;

import java.util.Arrays;

public class SolutionB {

    public String kthLargestNumber(String[] nums, int k) {
        int maxLength = 0;
        for (String num : nums) {
            if (num.length() > maxLength) {
                maxLength = num.length();
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length() < maxLength) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < maxLength - nums[i].length(); j++) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(nums[i]);
                nums[i] = stringBuilder.toString();
            }
        }
        Arrays.sort(nums);
        String ans = nums[nums.length - k];
        int index = -1;
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) != '0') {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return "0";
        }

        return ans.substring(index);
    }

}
