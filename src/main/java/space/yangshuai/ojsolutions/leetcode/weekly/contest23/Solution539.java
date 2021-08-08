package space.yangshuai.ojsolutions.leetcode.weekly.contest23;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rotciv on 2017/3/12.
 */
public class Solution539 {

    public int findMinDifference(List<String> timePoints) {

        int[] seconds = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); ++i) {
            String[] arr = timePoints.get(i).split(":");
            seconds[i] = Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
        }

        Arrays.sort(seconds);

        int min = 24 * 60  + seconds[0] - seconds[timePoints.size() - 1];
        for (int i = 0; i < seconds.length - 1; ++i) {
            if (seconds[i + 1] - seconds[i] < min) min = seconds[i + 1] - seconds[i];
        }

        return min;
    }

    public static void main(String[] args) {
    }
}
