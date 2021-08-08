package space.yangshuai.ojsolutions.leetcode.weekly.contest21;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by rotciv on 2017/2/25.
 */
public class Solution529 {

    Queue<String> queue = new ArrayDeque<>();
    Set<String> set = new HashSet<>();

    public char[][] updateBoard(char[][] board, int[] click) {

        int x = click[0];
        int y = click[1];

        if (board[x][y] == 'M') board[x][y] = 'X';
        if (board[x][y] == 'E') {
            int count = mineNum(board, x, y);
            if (count > 0) {
                board[x][y] = Character.forDigit(count, 10);
            } else {
                board[x][y] = 'B';
                if (x  - 1 >= 0 && y - 1 >= 0) {
                    set.add((x - 1) + " " + (y - 1));
                    queue.add((x - 1) + " " + (y - 1));
                }
                if (x - 1 >= 0) {
                    set.add((x - 1) + " " + y);
                    queue.add((x - 1) + " " + y);
                }
                if (x - 1 >= 0 && y + 1 < board[0].length) {
                    set.add((x - 1) + " " + (y + 1));
                    queue.add((x - 1) + " " + (y + 1));
                }
                if (y - 1 >= 0) {
                    set.add(x + " " + (y - 1));
                    queue.add(x + " " + (y - 1));
                }
                if (y + 1 < board[0].length) {
                    set.add(x + " " + (y + 1));
                    queue.add(x + " " + (y + 1));
                }
                if (x + 1 < board.length && y - 1 >= 0) {
                    set.add((x + 1) + " " + (y - 1));
                    queue.add((x + 1) + " " + (y - 1));
                }
                if (x + 1 < board.length) {
                    set.add((x + 1) + " " + y);
                    queue.add((x + 1) + " " + y);
                }
                if (x + 1 < board.length && y + 1 < board[0].length) {
                    set.add((x + 1) + " " + (y + 1));
                    queue.add((x + 1) + " " + (y + 1));
                }
                reveal(board);
            }
        }

        return board;
    }

    private void reveal(char[][] board) {
        while (queue.size() > 0) {
            String[] arr = queue.poll().split(" ");
            int x = Integer.valueOf(arr[0]);
            int y = Integer.valueOf(arr[1]);
            int count = mineNum(board, x, y);
            if (count > 0) {
                board[x][y] = Character.forDigit(count, 10);
            } else if (count == 0) {
                board[x][y] = 'B';
                if (x  - 1 >= 0 && y - 1 >= 0 && !set.contains((x - 1) + " " + (y - 1))) {
                    set.add((x - 1) + " " + (y - 1));
                    queue.add((x - 1) + " " + (y - 1));
                }
                if (x - 1 >= 0 && !set.contains((x - 1) + " " + y)) {
                    set.add((x - 1) + " " + y);
                    queue.add((x - 1) + " " + y);
                }
                if (x - 1 >= 0 && y + 1 < board[0].length && !set.contains((x - 1) + " " + (y + 1))) {
                    set.add((x - 1) + " " + (y + 1));
                    queue.add((x - 1) + " " + (y + 1));
                }
                if (y - 1 >= 0 && !set.contains(x + " " + (y - 1))) {
                    set.add(x + " " + (y - 1));
                    queue.add(x + " " + (y - 1));
                }
                if (y + 1 < board[0].length && !set.contains(x + " " + (y + 1))) {
                    set.add(x + " " + (y + 1));
                    queue.add(x + " " + (y + 1));
                }
                if (x + 1 < board.length && y - 1 >= 0 && !set.contains((x + 1) + " " + (y - 1))) {
                    set.add((x + 1) + " " + (y - 1));
                    queue.add((x + 1) + " " + (y - 1));
                }
                if (x + 1 < board.length && !set.contains((x + 1) + " " + y)) {
                    set.add((x + 1) + " " + y);
                    queue.add((x + 1) + " " + y);
                }
                if (x + 1 < board.length && y + 1 < board[0].length && !set.contains((x + 1) + " " + (y + 1))) {
                    set.add((x + 1) + " " + (y + 1));
                    queue.add((x + 1) + " " + (y + 1));
                }
            }
        }

    }

    private int mineNum(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1) return -1;
        int count = 0;
        if (x - 1 >= 0 && y - 1 >= 0 && board[x - 1][y - 1] == 'M') count++;
        if (x - 1 >= 0 && board[x - 1][y] == 'M') count++;
        if (x - 1 >= 0 && y + 1 < board[0].length && board[x - 1][y + 1] == 'M') count++;
        if (y - 1 >= 0 && board[x][y - 1] == 'M') count++;
        if (y + 1 < board[0].length && board[x][y + 1] == 'M') count++;
        if (x + 1 < board.length && y - 1 >= 0 && board[x + 1][y - 1] == 'M') count++;
        if (x + 1 < board.length && board[x + 1][y] == 'M') count++;
        if (x + 1 < board.length && y + 1 < board[0].length && board[x + 1][y + 1] == 'M') count++;
        return count;
    }

    public static void main(String[] args) {
        int a = 8;
//        System.out.println(new Solution529());
        System.out.println(Character.forDigit(8, 10));
        System.out.println(a);
    }
}
