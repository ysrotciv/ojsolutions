package space.yangshuai.ojsolutions.leetcode.medium;

/**
 * Created by rotciv on 2017/1/5.
 */
public class Solution289 {

    public void gameOfLife(int[][] board) {

        int height = board.length;
        int width = board[0].length;

        int[][] newBoard = new int[height][width];

        if (width == 1 || height == 1) {
            matrixCopy(newBoard, board);
            return;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = board[i][j] << 1 | newStatus(i, j, board);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = board[i][j] & 1;
            }
        }

    }

    private int newStatus(int row, int col, int[][] board) {

        int height = board.length;
        int width = board[0].length;

        int upLeft, up, upRight, left, right, downLeft, down, downRight;

        if (row == 0 || col == 0) {
            upLeft = 0;
        } else {
            upLeft = board[row - 1][col - 1] >> 1;
        }

        if (row == 0) {
            up = 0;
        } else {
            up = board[row - 1][col] >> 1;
        }

        if (row == 0 || col == width - 1) {
            upRight = 0;
        } else {
            upRight = board[row - 1][col + 1] >> 1;
        }

        if (col == 0) {
            left = 0;
        } else {
            left = board[row][col - 1] >> 1;
        }

        if (col == width - 1) {
            right = 0;
        } else {
            right = board[row][col + 1];
        }

        if (row == height - 1 || col == 0) {
            downLeft = 0;
        } else {
            downLeft = board[row + 1][col - 1];
        }

        if (row == height - 1) {
            down = 0;
        } else {
            down = board[row + 1][col];
        }

        if (row == height - 1 || col == width - 1) {
            downRight = 0;
        } else {
            downRight = board[row + 1][col + 1];
        }

        /*int upIndex = row - 1;
        if (upIndex < 0) upIndex = height - 1;

        int downIndex = row + 1;
        if (downIndex >= height) downIndex = 0;

        int leftIndex = col - 1;
        if (leftIndex < 0) leftIndex = width - 1;

        int rightIndex = col + 1;
        if (rightIndex >= width) rightIndex = 0;

        int liveCount = board[upIndex][leftIndex] + board[upIndex][col] + board[upIndex][rightIndex]
                + board[row][leftIndex] + board[row][rightIndex]
                + board[downIndex][leftIndex] + board[downIndex][col] + board[downIndex][rightIndex];*/

        int liveCount = upLeft + up + upRight + left + right + downLeft + down + downRight;

        if (board[row][col] == 1) {
            if (liveCount < 2)
                return 0;
            if (liveCount < 4)
                return 1;
            return 0;
        } else if (liveCount == 3) {
            return 1;
        }

        return 0;
    }

    private void matrixCopy(int[][] src, int[][] dest) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[0].length; j++)
                dest[i][j] = src[i][j];
        }
    }

    public static void main(String[] args) {
        new Solution289().gameOfLife(new int[][]{{1, 1}, {1, 0}});
        int a = 1;

    }
}
