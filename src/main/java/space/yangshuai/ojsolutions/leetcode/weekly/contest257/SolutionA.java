package space.yangshuai.ojsolutions.leetcode.weekly.contest257;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SolutionA {

    public int countQuadruplets(int[] nums) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 3; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }

        int count = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    List<Integer> list = map.get(sum);
                    if (list != null) {
                        for (int num : list) {
                            if (num > k) {
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

}
