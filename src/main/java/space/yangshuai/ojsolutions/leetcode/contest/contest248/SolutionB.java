package space.yangshuai.ojsolutions.leetcode.contest.contest248;

import java.util.Arrays;

public class SolutionB {

    public int eliminateMaximum(int[] dist, int[] speed) {
        if (dist.length == 1) {
            return 1;
        }
        float[] times = new float[dist.length];
        for (int i = 0; i < dist.length; i++) {
            times[i] = (float)dist[i] / speed[i];
        }
        Arrays.sort(times);
        int res = 1;
        for (int i = 1; i < times.length; i++) {
            if (times[i] > i) {
                res++;
            } else {
                return res;
            }
        }
        return res;
    }

}
