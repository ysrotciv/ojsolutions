package space.yangshuai.ojsolutions.leetcode.weekly.contest253;

import java.util.HashMap;
import java.util.Map;

public class SolutionD {

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] dp = new int[obstacles.length];
        dp[0] = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(obstacles[0], 1);

        for (int i = 1; i < obstacles.length; i++) {
            int obstacle = obstacles[i];
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (obstacles[j] <= obstacle) {
                    max = Math.max(max, map.get(obstacles[j]) + 1);
                }
            }
            dp[i] = max;
            map.put(obstacle, max);
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionD().longestObstacleCourseAtEachPosition(new int[]{5,1,5,5,1,3,4,5,1,4}));
    }
}
