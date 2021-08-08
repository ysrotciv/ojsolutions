package space.yangshuai.ojsolutions.leetcode.weekly.contest30;

/**
 * Created by rotciv on 2017/4/30.
 */
public class Solution568 {

    public int maxVacationDays(int[][] flights, int[][] days) {

        int cities = days.length;
        int weeks = days[0].length;

        int[][] m = new int[weeks][cities];
        int[][] arrive = new int[weeks][cities];
        int ans = 0;

        for (int i = 0; i < weeks; ++i) {
            for (int j = 0; j < cities; ++j) {
                if (i == 0) {
                    if (j == 0 || flights[0][j] > 0) {
                        m[i][j] = days[j][i];
                        arrive[i][j] = 1;
                    }
                } else {
                    int max = 0;
                    for (int k = 0; k < days.length; ++k) {
                        if ((k == j || flights[k][j] > 0) && arrive[i - 1][k] > 0) {
                            if (m[i - 1][k] > max) {
                                max = m[i - 1][k];
                            }
                            arrive[i][j] = 1;
                        }
                    }

                    if (arrive[i][j] > 0) {
                        m[i][j] = max + days[j][i];
                        if (m[i][j] > ans) {
                            ans = m[i][j];
                        }
                    }
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution568().maxVacationDays(
                new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 0}},
                new int[][]{{0, 0, 7},{2, 0, 0},{7,7,7}}));
    }

}
