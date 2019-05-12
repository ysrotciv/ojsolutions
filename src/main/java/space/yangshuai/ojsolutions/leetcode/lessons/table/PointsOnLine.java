package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangshuai on 2019-05-10.
 */
public class PointsOnLine {

    public int maxPoints(int[][] points) {

        int max = 0;
        Map<Double, Integer> map = new HashMap<>(points.length >> 1);

        if (points.length < 1) {
            return 0;
        }

        for (int i = 0; i < points.length; ++i) {
            int equalCount = 0;
            for (int j = 0; j < points.length; ++j) {
                if (i == j) {
                    continue;
                }
                if (equal(points[i], points[j])) {
                    equalCount++;
                } else {
                    double ratio = ratio(points[i], points[j]);
                    map.put(ratio, map.getOrDefault(ratio, 0) + 1);
                }
            }
            for (int count : map.values()) {
                if (count + equalCount > max) {
                    max = count + equalCount;
                }
            }
            if (equalCount > max) {
                max = equalCount;
            }
            map.clear();
        }

        return max + 1;
    }

    private boolean equal(int[] src, int[] target) {
        return src[0] == target[0] && src[1] == target[1];
    }

    private double ratio(int[] src, int[] target) {
        if (src[1] == target[1]) {
            return Double.MAX_VALUE;
        }
        return ((double)src[0] - target[0]) / ((double)src[1] - target[1]);
    }

    public static void main(String[] args) {
        int result = new PointsOnLine().maxPoints(new int[][]{{0, 0}, {0, 0}});
        System.out.println(result);
    }

}
