package space.yangshuai.ojsolutions.leetcode.lessons.stack;

import java.util.LinkedList;

/**
 * @author yangshuai on 2019-05-08.
 */
public class Matrix {

    LinkedList<int[]> queue;
    private int length, width;
    private int[][] visited;

    public int[][] updateMatrix(int[][] matrix) {

        length = matrix.length;
        width = matrix[0].length;

        visited = new int[length][width];

        queue = new LinkedList<>();
        for (int x = 0; x < length; ++x) {
            for (int y = 0; y < width; ++y) {
                if (matrix[x][y] == 0) {
                    queue.add(new int[]{x, y});
                    visited[x][y] = 1;
                }
            }
        }

        while (queue.size() > 0) {
            int[] node = queue.pop();
            int x = node[0];
            int y = node[1];
            int value = matrix[x][y];
            set(x + 1, y, value, matrix);
            set(x - 1, y, value, matrix);
            set(x, y + 1, value, matrix);
            set(x, y - 1, value, matrix);
        }

        return matrix;
    }

    private void set(int x, int y, int value, int[][] matrix) {

        if (x < 0 || x >= length) {
            return;
        }
        if (y < 0 || y >= width) {
            return;
        }

        if (visited[x][y] == 1) {
            return;
        }

        matrix[x][y] = value + 1;
        visited[x][y] = 1;
        queue.add(new int[]{x, y});
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        new Matrix().updateMatrix(matrix);
    }
}
