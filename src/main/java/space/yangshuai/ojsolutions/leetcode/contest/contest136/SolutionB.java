package space.yangshuai.ojsolutions.leetcode.contest.contest136;

import java.util.*;

public class SolutionB {

    public int[] gardenNoAdj(int N, int[][] paths) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] result = new int[N];
        result[0] = 1;

        for (int[] path : paths) {
            int head = path[0];
            int tail = path[1];

            List<Integer> list = map.getOrDefault(head, new ArrayList<>());
            list.add(tail);
            map.put(head, list);

            List<Integer> tailList = map.getOrDefault(tail, new ArrayList<>());
            tailList.add(head);
            map.put(tail, tailList);
        }

        Set<Integer> set;
        for (int i = 1; i < N; ++i) {
            set = new HashSet<>();
            List<Integer> points = map.get(i + 1);
            if (points == null) {
                result[i] = 1;
                continue;
            }
            for (int point : points) {
                if (result[point - 1] == 0) {
                    continue;
                } else {
                    set.add(result[point - 1]);
                }
            }

            for (int j = 1; j <= 4; ++j) {
                if (!set.contains(j)) {
                    result[i] = j;
                    break;
                }
            }
        }

        return result;
    }


}
