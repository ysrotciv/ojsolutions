package space.yangshuai.ojsolutions.leetcode.contest.contest249;

public class SolutionC {

    public int colorTheGrid(int m, int n) {
        long[] dp = new long[1001];
        if (m == 1) {
            dp[1] = 3;
            for (int i = 2; i <= n; i++) {
                dp[i] = 2 * dp[i - 1] % 1000000007;
            }
        } else if (m == 2) {
            dp[0] = 2;
            for (int i = 1; i <= n; i++) {
                dp[i] = 3 * dp[i - 1] % 1000000007;
            }
        } else if (m == 3) {
            dp[0] = 3;
            dp[1] = 12;
            for (int i = 2; i <= n; i++) {
                dp[i] = ((5 * dp[i - 1] - 2 * dp[i - 2]) % 1000000007 + 1000000007) % 1000000007;
            }
        } else if (m == 4) {
            dp[0] = 4;
            dp[1] = 24;
            dp[2] = 162;
            for (int i = 3; i <= n; i++) {
                dp[i] = ((9 * dp[i - 1] - 15 * dp[i - 2] + 6 * dp[i - 3]) % 1000000007 + 1000000007) % 1000000007;
            }
        } else {
            dp[0] = 6;
            dp[1] = 48;
            dp[2] = 486;
            dp[3] = 5118;
            dp[4] = 54450;
            for (int i = 5; i <= n; i++) {
                dp[i] = ((16 * dp[i - 1] - 65 * dp[i - 2] + 92 * dp[i - 3] - 48 * dp[i - 4] + 8 * dp[i - 5])
                        % 1000000007 + 1000000007) % 1000000007;
            }
        }
        return (int) dp[n];
    }

}
