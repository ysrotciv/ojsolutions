package space.yangshuai.ojsolutions.leetcode.contest.contest30;

/**
 * Created by rotciv on 2017/4/30.
 */
public class Solution566 {

    private int rowIndex = 0;
    private int colIndex = 0;
    private int length = 0;
    private int[][] ans;

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int row = nums.length;
        int col = nums[0].length;
        length = c;
        ans = new int[r][c];

        if (col * row != r * c) {
            return nums;
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                insert(nums[i][j]);
            }
        }

        return ans;
    }

    private void insert(int value) {
        ans[rowIndex][colIndex] = value;
        colIndex++;
        if (colIndex > length - 1) {
            colIndex = 0;
            rowIndex++;
        }
    }
}
