package space.yangshuai.ojsolutions.leetcode.weekly.contest26;

import java.util.*;

/**
 * Created by rotciv on 2017/4/2.
 */
public class Solution547 {

    public int findCircleNum(int[][] M) {

        if (M.length <= 1) {
            return M.length;
        }

        Set<Integer> src = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> friends = new HashSet<>();

        for (int i = 0; i < M.length; ++i) {
            src.add(i);
        }

        int count = 0;

        while (src.size() > 0) {

            int first = src.iterator().next();
            queue.add(first);

            while (queue.size() > 0) {
                int current = queue.poll();
                friends.clear();
                for (int friend: src) {
                    if (M[friend][current] == 1) {
                        friends.add(friend);
                        queue.add(friend);
                    }
                }
                src.removeAll(friends);
            }

            count++;
        }

        return count;
    }

}
