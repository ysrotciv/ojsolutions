package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.*;

/**
 * @author yangshuai on 2019-05-08.
 */
public class SumOfThree {

    private Set<String> set = new HashSet<>();

    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);

        int previous = nums[0];
        int length = nums.length;

        for (int i = 0; i < length - 2; ++i) {
            if (i > 0 && previous == nums[i]) {
                continue;
            }
            int sum = 0 - nums[i];
            if (sum < 0) {
                break;
            }
            add(list, i + 1, length - 1, nums, sum);
            previous = nums[i];
        }

        return list;
    }

    private void add(List<List<Integer>> list, int head, int tail, int[] nums, int value) {
        while (head < tail) {
            int headValue = nums[head];
            int tailValue = nums[tail];
            if (headValue + tailValue == value) {
                head++;
                tail--;
                String str = String.format("%d,%d,%d", 0 - value, headValue, tailValue);
                if (!set.contains(str)) {
                    set.add(str);
                    list.add(Arrays.asList(0 - value, headValue, tailValue));
                }
            } else if (headValue + tailValue < value) {
                head++;
            } else {
                tail--;
            }
        }
    }

    public static void main(String[] args) {
        new SumOfThree().threeSum(new int[]{-1,0,1,2,-1,-4});
    }

}
