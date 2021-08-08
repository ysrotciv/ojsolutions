package space.yangshuai.ojsolutions.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Solution704 {

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(num, max);
        }
        map.forEach((k, v) -> {
            map.put(k, k * v);
        });
        int[] scores = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            scores[i] = map.getOrDefault(i, 0);
        }
        int[] ans = new int[scores.length];
        ans[1] = scores[1];
        for (int i = 2; i < scores.length; i++) {
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + scores[i]);
        }

        return ans[scores.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution704().deleteAndEarn(new int[]{2,2,1,1}));
    }

}
