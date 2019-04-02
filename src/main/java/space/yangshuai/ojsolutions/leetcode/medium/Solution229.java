package space.yangshuai.ojsolutions.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotciv on 2017/1/6.
 */
public class Solution229 {

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }

        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }


        int firstCandidate = 0;
        int secondCandidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) firstCandidate = num;
            if (firstCandidate == num) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    firstCandidate = num;
                    count++;
                }
            }
        }

        secondCandidate = firstCandidate;
        count = 0;

        for (int num : nums) {
            if (count == 0) {
                if (secondCandidate == num)
                    continue;
                else
                    secondCandidate = num;
            }
            if (secondCandidate == num) {
                count++;
            } else {
                if (num == firstCandidate) continue;
                count--;
                if (count == 0) {
                    if (num == firstCandidate)
                        continue;
                    else
                        secondCandidate = num;
                }
            }
        }

        if (isCandidate(nums, firstCandidate))
            list.add(firstCandidate);

        if (secondCandidate != firstCandidate && isCandidate(nums, secondCandidate))
            list.add(secondCandidate);

        return list;
    }

    private boolean isCandidate(int[] nums, int candidate) {
        int count = 0;

        for (int num : nums) {
            if (num == candidate) count++;
        }

        return count > nums.length / 3;
    }

    public static void main(String[] args) {
        new Solution229().majorityElement(new int[]{1, 1, 1, 2, 3, 4, 5, 7});
    }

}
