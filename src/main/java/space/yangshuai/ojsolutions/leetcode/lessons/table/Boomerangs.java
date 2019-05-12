package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangshuai on 2019-05-10.
 */
public class Boomerangs {

    public int numberOfBoomerangs(int[][] points) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>(points.length >> 1);

        if (points.length < 3) {
            return 0;
        }

        for (int i = 0; i < points.length; ++i) {
            for (int j = 0; j < points.length; ++j) {
                if (i == j) {
                    continue;
                }
                int disPow = distance(points[i], points[j]);
                map.put(disPow, map.getOrDefault(disPow, 0) + 1);
            }
            for (int dis : map.values()) {
                if (dis > 1) {
                    count += dis * (dis - 1);
                }
            }
            map.clear();
        }

        return count;
    }

    private int distance(int[] src, int[] target) {
        return (int)(Math.pow((src[0] - target[0]), 2) + Math.pow((src[1] - target[1]), 2));
    }

}
