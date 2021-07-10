package space.yangshuai.ojsolutions.leetcode.medium;

public class Solution73 {

    public void setZeroes(int[][] matrix) {

        boolean colFlag = false;
        int m = matrix.length, n = matrix[0].length;


        for (int i = 0; i < m; i++) {

            if (matrix[i][0] == 0) {
                colFlag = true;
            }

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (colFlag) {
                matrix[i][0] = 0;
            }
        }

    }

}
