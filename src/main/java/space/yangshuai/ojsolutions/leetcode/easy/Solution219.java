package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rotciv on 2017/1/7.
 */
public class Solution219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> list;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                list = map.get(nums[i]);
                for (int index : list) {
                    if (Math.abs(index - i) <= k) return true;
                }
                list.add(i);
            } else {
                list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        return false;
    }


}
