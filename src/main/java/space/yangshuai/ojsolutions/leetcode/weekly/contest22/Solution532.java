package space.yangshuai.ojsolutions.leetcode.weekly.contest22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by rotciv on 2017/3/5.
 */
public class Solution532 {

    public int findPairs(int[] nums, int k) {

        if (nums.length < 2) return 0;
        if (k < 0) return 0;

        Arrays.sort(nums);

        Set<String> set = new HashSet<>();
        int low = 0;
        int high = 1;
        int count = 0;

        while (high < nums.length) {
            int diff = nums[high] - nums[low];
            if (diff == k && !set.contains(nums[low] + "->" + nums[high])) {
                count++;
                set.add(nums[low] + "->" + nums[high]);
                low++;
                high++;
            } else if (diff > k) {
                low++;
                if (low == high) high++;
            } else {
                high++;
            }
        }

        return count;
    }


    public static void main(String[] args) {

        System.out.println(new Solution532().findPairs(new int[]{1, 3, 1, 5, 4}, -1));
    }

}
