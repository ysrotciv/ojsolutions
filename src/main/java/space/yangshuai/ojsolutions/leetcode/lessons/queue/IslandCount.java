package space.yangshuai.ojsolutions.leetcode.lessons.queue;

import space.yangshuai.ojsolutions.leetcode.common.utils.ArrayParser;

import java.util.LinkedList;

/**
 * @author yangshuai on 2019-04-22.
 */
public class IslandCount {

    public int numIslands(char[][] grid) {

        int height = grid.length;
        if (height == 0) {
            return 0;
        }

        int width = grid[0].length;


        int[][] status = new int[grid.length][grid[0].length];
        int result= 0;

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (status[i][j] == 1 || grid[i][j] == '0') {
                    continue;
                } else {
                    result++;
                    tag(grid, status, i, j, height, width);
                }
            }
        }

        return result;
    }

    private void tag(char[][] grid, int[][] status, int x, int y, int height, int width) {

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        status[x][y] = 1;

        while (queue.size() > 0) {
            Node node = queue.pop();
            x = node.x;
            y = node.y;
            if (y - 1 >= 0 && status[x][y - 1] == 0 && grid[x][y - 1] == '1') {
                queue.add(new Node(x, y - 1));
                status[x][y - 1] = 1;
            }
            if (x + 1 < height && status[x + 1][y] == 0 && grid[x + 1][y] == '1') {
                queue.add(new Node(x + 1, y));
                status[x + 1][y] = 1;
            }
            if (y + 1 < width && status[x][y + 1] == 0 && grid[x][y + 1] == '1') {
                queue.add(new Node(x, y + 1));
                status[x][y + 1] = 1;
            }
            if (x - 1 >= 0 && status[x - 1][y] == 0 && grid[x - 1][y] == '1') {
                queue.add(new Node(x - 1, y));
                status[x - 1][y] = 1;
            }
        }
    }

    private class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        char[][] arr = ArrayParser.parse("[[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"1\",\"0\",\"1\"],[\"1\",\"1\",\"1\",\"0\",\"1\"]]");
        int result = new IslandCount().numIslands(arr);
        System.out.println(result);
    }

}
