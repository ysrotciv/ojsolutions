package space.yangshuai.ojsolutions.leetcode.weekly.contest133;

public class SolutionB {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int width = Math.max(r0, R - r0 - 1);
        int height = Math.max(c0, C - c0 - 1);

        int max = width + height;

        int[][] result = new int[R * C][2];
        int index = 1;
        result[0] = new int[]{r0, c0};

        for (int i = 1; i <= max; ++i) {
            for (int j = 0; j <= i / 2; ++j) {
                if (r0 + j < R && c0 + i - j < C && index < result.length) {
                    result[index++] = new int[]{r0 + j, c0 + i - j};
                }
                if (r0 - (i - j) >= 0 && c0 + j < C && index < result.length) {
                    result[index++] = new int[]{r0 - (i - j), c0 + j};
                }
                if (r0 - j >= 0 && c0 - (i - j) >= 0 && index < result.length) {
                    result[index++] = new int[]{r0 - j, c0 - (i - j)};
                }
                if (r0 + (i - j) < R && c0 - j >= 0 && index < result.length) {
                    result[index++] = new int[]{r0 + (i - j), c0 - j};
                }
                if (j != 0 && j * 2 != i) {

                    if (r0 + j < R && c0 - (i - j) >= 0 && index < result.length) {
                        result[index++] = new int[]{r0 + j, c0 - (i - j)};
                    }
                    if (r0 + (i - j) < R && c0 + j < C && index < result.length) {
                        result[index++] = new int[]{r0 + (i - j), c0 + j};
                    }
                    if (r0 - j >= 0 && c0 + (i - j) < R && index < result.length) {
                        result[index++] = new int[]{r0 - j, c0 + (i - j)};
                    }
                    if (r0 - (i - j) >= 0 && c0 - j >= 0 && index < result.length) {
                        result[index++] = new int[]{r0 - (i - j), c0 - j};
                    }

                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new SolutionB().allCellsDistOrder(3, 3, 0, 2);
    }

}
