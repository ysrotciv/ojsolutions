package space.yangshuai.ojsolutions.leetcode.biweekly.contest60;

import java.util.ArrayList;
import java.util.List;

public class SolutionB {

    public int[][] findFarmland(int[][] land) {

        int width = land[0].length;
        int height = land.length;

        List<int[]> list = new ArrayList<>();
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if (land[r][c] == 1) {
                    int[] cor = returnCorners(c, r, width, height, land);
                    list.add(cor);
                    erase(cor, land);
                }
            }
        }

        int[][] res = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private int[] returnCorners(int c, int r, int width, int height, int[][] land) {
        int right = c;
        while (right + 1 < width && land[r][right + 1] == 1) {
            right++;
        }
        int bottom = r;
        while (bottom + 1 < height && land[bottom + 1][right] == 1) {
            bottom++;
        }
        return new int[]{r, c, bottom, right};
    }

    private void erase(int[] cor, int[][] land) {
        for (int c = cor[1]; c <= cor[3]; c++) {
            for (int r = cor[0]; r <= cor[2]; r++) {
                land[r][c] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{{0,1}, {1, 0}};
        new SolutionB().findFarmland(data);
    }

}
