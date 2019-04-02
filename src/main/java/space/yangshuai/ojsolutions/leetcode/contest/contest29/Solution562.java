package space.yangshuai.ojsolutions.leetcode.contest.contest29;

/**
 * Created by rotciv on 2017/4/23.
 */
public class Solution562 {

    public int longestLine(int[][] M) {

        if (M == null) {
            return 0;
        }
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }

        int rows = M.length;
        int cols = M[0].length;

        int[][] matrix = new int[rows][cols];

        int max = 0;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (j == 0) {
                    matrix[i][j] = M[i][j];
                } else {
                    if (M[i][j] == 1) {
                        matrix[i][j] = matrix[i][j - 1] + 1;
                    }
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        matrix = new int[rows][cols];
        for (int j = 0; j < cols; ++j) {
            for (int i = 0; i < rows; ++i) {
                if (i == 0) {
                    matrix[i][j] = M[i][j];
                } else {
                    if (M[i][j] == 1) {
                        matrix[i][j] = matrix[i - 1][j] + 1;
                    }
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        matrix = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (j == 0 || i == 0) {
                    matrix[i][j] = M[i][j];
                } else {
                    if (M[i][j] == 1) {
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    }
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        matrix = new int[rows][cols];
        for (int i = rows - 1; i >= 0; --i) {
            for (int j = 0; j < cols; ++j) {
                if (j == 0 || i == rows - 1) {
                    matrix[i][j] = M[i][j];
                } else {
                    if (M[i][j] == 1) {
                        matrix[i][j] = matrix[i + 1][j - 1] + 1;
                    }
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

}
