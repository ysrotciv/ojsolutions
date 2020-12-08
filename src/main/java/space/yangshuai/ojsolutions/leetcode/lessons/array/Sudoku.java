package space.yangshuai.ojsolutions.leetcode.lessons.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yangshuai on 2020/12/8.
 */
public class Sudoku {

    public boolean isValidSudoku(char[][] board) {

        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] boxes = new int[9][9];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                int value = Character.getNumericValue(board[i][j]);
                if (rows[i][value - 1] == 1) {
                    return false;
                } else {
                    rows[i][value - 1] = 1;
                }
                if (columns[j][value - 1] == 1) {
                    return false;
                } else {
                    columns[j][value - 1] = 1;
                }

                int boxIndex = i / 3 * 3 + j / 3;
                if (boxes[boxIndex][value - 1] == 1) {
                    return false;
                } else {
                    boxes[boxIndex][value - 1] = 1;
                }
            }
        }
        return true;
    }
}
