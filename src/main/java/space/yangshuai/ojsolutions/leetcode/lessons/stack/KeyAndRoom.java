package space.yangshuai.ojsolutions.leetcode.lessons.stack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshuai on 2019-05-08.
 */
public class KeyAndRoom {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int[] visited = new int[rooms.size()];
        visited[0] = 1;

        LinkedList<List<Integer>> queue = new LinkedList<>();

        queue.add(rooms.get(0));

        while (queue.size() > 0) {
            List<Integer> keys = queue.pop();
            for (int key : keys) {
                if (visited[key] == 0) {
                    queue.add(rooms.get(key));
                    visited[key] = 1;
                }
            }
        }

        for (int room : visited) {
            if (room == 0) {
                return false;
            }
        }

        return true;
    }

}
