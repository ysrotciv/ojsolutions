package space.yangshuai.ojsolutions.leetcode.medium;

import java.util.*;

/**
 * @author yangshuai on 2019-02-20.
 */
public class Solution15 {

    private static Map<Integer, Integer> counter;

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        counter = new HashMap<>(nums.length << 1);

        for (int i : nums) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }
        int head = 0, tail = nums.length - 1;
        removeCounter(nums[head]);
        removeCounter(nums[tail]);

        while (head != tail) {
            int x = nums[head];
            int y = nums[tail];
            int target = 0 - x - y;
            if (counter.containsKey(target)) {
                removeCounter(target);
                list.add(Arrays.asList(x, y, target));
                removeCounter(nums[++head]);
                removeCounter(nums[--tail]);
            } else if (x + y >= 0) {
                removeCounter(nums[--tail]);
            } else {
                removeCounter(nums[++head]);
            }
        }

        return list;
    }

    private void removeCounter(int num) {
        if (counter.get(num) == 1) {
            counter.remove(num);
        } else {
            counter.put(num, counter.get(num) - 1);
        }
    }

    public static void main(String[] args) {
        new Solution15().threeSum(new int[]{-1,0,1,2,-1,-4});
    }

}
