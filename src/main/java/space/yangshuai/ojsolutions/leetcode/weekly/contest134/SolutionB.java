package space.yangshuai.ojsolutions.leetcode.weekly.contest134;

import java.util.LinkedList;

/**
 * @author yangshuai on 2019-04-28.
 */
public class SolutionB {

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {

        if (grid.length == 0) {
            return grid;
        }

        if (color == grid[r0][c0]) {
            return grid;
        }
        int currentColor = grid[r0][c0];

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r0, c0});

        while (queue.size() > 0) {
            int[] node = queue.pop();
            add(grid, queue, currentColor, new int[]{node[0] - 1, node[1]}, color);
            add(grid, queue, currentColor, new int[]{node[0] + 1, node[1]}, color);
            add(grid, queue, currentColor, new int[]{node[0], node[1] - 1}, color);
            add(grid, queue, currentColor, new int[]{node[0], node[1] + 1}, color);
        }

        return grid;
    }

    private void add(int[][] grid, LinkedList<int[]> queue, int color, int[] node, int newColor) {
        if (node[0] >= 0 && node[0] < grid.length && node[1] >= 0 && node[1] < grid[0].length) {
            if (grid[node[0]][node[1]] == color) {
                queue.add(node);
                color(grid, color, node, newColor);
            }
        }

    }

    private void color(int[][] grid, int color, int[] node, int newColor) {
        if (node[0] == 0 || node[0] == grid.length - 1 || node[1] == 0 || node[1] == grid[0].length - 1) {
            grid[node[0]][node[1]] = newColor;
            return;
        }
        int[] up = new int[]{node[0] - 1, node[1]};
        int[] down = new int[]{node[0] + 1, node[1]};
        int[] left = new int[]{node[0], node[1] - 1};
        int[] right = new int[]{node[0], node[1] + 1};
        if (inGrid(up, grid) && grid[up[0]][up[1]] != color) {
            grid[node[0]][node[1]] = newColor;
            return;
        }
        if (inGrid(down, grid) && grid[down[0]][down[1]] != color) {
            grid[node[0]][node[1]] = newColor;
            return;
        }
        if (inGrid(left, grid) && grid[left[0]][left[1]] != color) {
            grid[node[0]][node[1]] = newColor;
            return;
        }
        if (inGrid(right, grid) && grid[right[0]][right[1]] != color) {
            grid[node[0]][node[1]] = newColor;
        }
    }

    private boolean inGrid(int[] node, int[][] grid) {
        if (node[0] < 0 || node[0] > grid.length) {
            return false;
        }
        if (node[1] < 0 || node[1] > grid[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1}, {1, 2}};
        new SolutionB().colorBorder(grid, 0, 0, 3);
    }

}
