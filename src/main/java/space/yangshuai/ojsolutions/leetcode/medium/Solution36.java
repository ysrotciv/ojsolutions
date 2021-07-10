package space.yangshuai.ojsolutions.leetcode.medium;

public class Solution36 {

    public boolean isValidSudoku(char[][] board) {

        int[][] rowMap = new int[9][9];
        int[][] colMap = new int[9][9];
        int[][] blockMap = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int c = board[i][j];
                if (c == '.') {
                    continue;
                }
                c = c - '1';

                int[] rowArr = rowMap[i];
                if (rowArr[c] == 1) {
                    return false;
                }
                rowArr[c] = 1;

                int[] colArr = colMap[j];
                if (colArr[c] == 1) {
                    return false;
                }
                colArr[c] = 1;

                int[] blockArr = blockMap[(i / 3) * 3 + j / 3];
                if (blockArr[c] == 1) {
                    return false;
                }
                blockArr[c] = 1;
            }
        }

        return true;
    }
}
