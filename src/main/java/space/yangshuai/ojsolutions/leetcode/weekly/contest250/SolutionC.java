package space.yangshuai.ojsolutions.leetcode.weekly.contest250;

public class SolutionC {

    public long maxPoints(int[][] points) {

        int m = points.length;
        int n = points[0].length;

        long[][] res = new long[m][n];
        for (int i = 0; i < n; i++) {
            res[0][i] = points[0][i];
        }

        for (int i = 1; i < m; i++) {
            long lineMax = 0;
            long maxIndex = 0;
            for (int j = 0; j < n; j++) {
                res[i][j] = points[i][j];
                long max = 0;
                for (int k = 0; k < n; k++) {
                    long pre = res[i - 1][k];
                    if (pre == -1) {
                        continue;
                    }
                    long temp = pre - Math.abs(j - k);
                    if (temp > max) {
                        max = temp;
                    }
                }
                res[i][j] += max;
                if (res[i][j] > lineMax) {
                    lineMax = res[i][j];
                    maxIndex = j;
                } else if (lineMax - (j - maxIndex) > res[i][j]) {
                    res[i][j] = -1;
                }
            }
        }
        long ans = 0;
        for (long value : res[m - 1]) {
            if (value > ans) {
                ans = value;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new SolutionC().maxPoints(new int[][]{{1,2,3},{1,5,1},{3,1,1}});
    }
}
