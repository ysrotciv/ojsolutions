package space.yangshuai.leetcode.medium;

/**
 * Created by Yang on 2017/1/3.
 */
public class Solution419 {

    public int countBattleships(char[][] board) {

        int sum = 0;
        int high = board.length;
        int width = board[0].length;

        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == '.') continue;
                if (i != 0 && board[i - 1][j] == '.') continue;
                if (j != 0 && board[i][j - 1] == '.') continue;
                sum ++;
            }
        }

        return sum;
    }

}
