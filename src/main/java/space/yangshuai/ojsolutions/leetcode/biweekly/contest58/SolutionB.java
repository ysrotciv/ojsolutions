package space.yangshuai.ojsolutions.leetcode.biweekly.contest58;

public class SolutionB {

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {

        int r = rMove + 1;
        int c = cMove;
        StringBuilder stringBuilder = new StringBuilder();
        while (r < 8) {
            char co = board[r][c];
            if (co == '.') {
                break;
            }
            stringBuilder.append(board[r][c]);
            if (co == color) {
                break;
            }
            r++;
        }
        if (goodLine(stringBuilder.toString().toCharArray(), color)) {
            return true;
        }

        r = rMove - 1;
        c = cMove;
        stringBuilder = new StringBuilder();
        while (r >= 0) {
            char co = board[r][c];
            if (co == '.') {
                break;
            }
            stringBuilder.append(board[r][c]);
            if (co == color) {
                break;
            }
            r--;
        }
        if (goodLine(stringBuilder.toString().toCharArray(), color)) {
            return true;
        }

        r = rMove;
        c = cMove + 1;
        stringBuilder = new StringBuilder();
        while (c < 8) {
            char co = board[r][c];
            if (co == '.') {
                break;
            }
            stringBuilder.append(board[r][c]);
            if (co == color) {
                break;
            }
            c++;
        }
        if (goodLine(stringBuilder.toString().toCharArray(), color)) {
            return true;
        }

        r = rMove;
        c = cMove - 1;
        stringBuilder = new StringBuilder();
        while (c >= 0) {
            char co = board[r][c];
            if (co == '.') {
                break;
            }
            stringBuilder.append(board[r][c]);
            if (co == color) {
                break;
            }
            c--;
        }
        if (goodLine(stringBuilder.toString().toCharArray(), color)) {
            return true;
        }

        r = rMove + 1;
        c = cMove + 1;
        stringBuilder = new StringBuilder();
        while (c < 8 && r < 8) {
            char co = board[r][c];
            if (co == '.') {
                break;
            }
            stringBuilder.append(board[r][c]);
            if (co == color) {
                break;
            }
            c++;
            r++;
        }
        if (goodLine(stringBuilder.toString().toCharArray(), color)) {
            return true;
        }

        r = rMove - 1;
        c = cMove - 1;
        stringBuilder = new StringBuilder();
        while (c >= 0 && r >= 0) {
            char co = board[r][c];
            if (co == '.') {
                break;
            }
            stringBuilder.append(board[r][c]);
            if (co == color) {
                break;
            }
            c--;
            r--;
        }
        if (goodLine(stringBuilder.toString().toCharArray(), color)) {
            return true;
        }

        r = rMove + 1;
        c = cMove - 1;
        stringBuilder = new StringBuilder();
        while (c >= 0 && r < 8) {
            char co = board[r][c];
            if (co == '.') {
                break;
            }
            stringBuilder.append(board[r][c]);
            if (co == color) {
                break;
            }
            c--;
            r++;
        }
        if (goodLine(stringBuilder.toString().toCharArray(), color)) {
            return true;
        }

        r = rMove - 1;
        c = cMove + 1;
        stringBuilder = new StringBuilder();
        while (c < 8 && r >= 0) {
            char co = board[r][c];
            if (co == '.') {
                break;
            }
            stringBuilder.append(board[r][c]);
            if (co == color) {
                break;
            }
            c++;
            r--;
        }
        if (goodLine(stringBuilder.toString().toCharArray(), color)) {
            return true;
        }

        return false;
    }

    private boolean goodLine(char[] arr, char color) {
        if (arr.length < 2) {
            return false;
        }
        if (arr[arr.length - 1] != color) {
            return false;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (color == arr[i]) {
                return false;
            }
        }
        return true;
    }

}
