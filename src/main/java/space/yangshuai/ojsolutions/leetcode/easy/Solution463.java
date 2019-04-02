package space.yangshuai.ojsolutions.leetcode.easy;

/**
 * Created by Yang on 2017/1/3.
 */
public class Solution463 {

    public int islandPerimeter(int[][] grid) {

        int sum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) sum += pointPerimeter(grid, i, j);
        }
        return sum;
    }

    public static int pointPerimeter(int[][] grid, int i, int j) {

        if (grid[i][j] == 0)
            return 0;

        int perimeter = 0;
        int high = grid.length;
        int width = grid[0].length;


        if (high == 1) {
            if (grid[i][j] == 1) perimeter+= 1;
        } else {

            if (i == high - 1) {
                perimeter++;
            } else if (grid[i + 1][j] == 0) {
                perimeter++;
            }

        }

        if (width == 1) {
            if (grid[i][j] == 1) perimeter+= 1;
        } else {

            if (j == width - 1) {
                perimeter++;
            } else if (grid[i][j + 1] == 0) {
                perimeter++;
            }

        }

        return perimeter * 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution463().islandPerimeter(new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }

}
