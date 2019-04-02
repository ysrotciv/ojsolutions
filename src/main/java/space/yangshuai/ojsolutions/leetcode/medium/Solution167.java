package space.yangshuai.ojsolutions.leetcode.medium;

/**
 * Created by Yang on 2017/1/3.
 */
public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {

        int length = numbers.length;
        int start = 0;
        int end = length - 1;

        while (true) {
            if (numbers[start] + numbers[end] == target)
                return new int[]{start + 1, end + 1};
            else if (numbers[start] + numbers[end] > target)
                end--;
            else
                start++;
        }

    }

}
