package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.*;

/**
 * @author yangshuai on 2019-05-08.
 */
public class SumOfFour {

    private Set<String> set = new HashSet<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);

        int previous = nums[0];
        int length = nums.length;

        for (int i = 0; i < length - 3; ++i) {
            if (i > 0 && previous == nums[i]) {
                continue;
            }
            int sum = target - nums[i];
            if (nums[i] > 0 && sum <= 0) {
                break;
            }
            threeSum(list, i + 1, nums, sum, nums[i]);
            previous = nums[i];
        }

        return list;
    }

    public List<List<Integer>> threeSum(List<List<Integer>> list, int head, int[] nums, int value, int first) {

        for (int i = head; i < nums.length - 2; ++i) {
            if (i > head && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = value - nums[i];
            if (nums[i] > 0 && sum <= 0) {
                break;
            }
            add(list, i + 1, nums, sum, first, nums[i]);
        }

        return list;
    }

    private void add(List<List<Integer>> list, int head, int[] nums, int value, int first, int second) {
        int tail = nums.length - 1;
        while (head < tail) {
            int headValue = nums[head];
            int tailValue = nums[tail];
            if (headValue + tailValue == value) {
                head++;
                tail--;
                String str = String.format("%d,%d,%d,%d", first, second, headValue, tailValue);
                if (!set.contains(str)) {
                    set.add(str);
                    list.add(Arrays.asList(first, second, headValue, tailValue));
                }
            } else if (headValue + tailValue < value) {
                head++;
            } else {
                tail--;
            }
        }
    }

//    public static void main(String[] args) {
//        new SumOfFour().threeSum(new int[]{-1,0,1,2,-1,-4});
//    }

}
