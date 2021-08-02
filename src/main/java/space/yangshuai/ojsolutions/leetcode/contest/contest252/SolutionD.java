package space.yangshuai.ojsolutions.leetcode.contest.contest252;

public class SolutionD {

    public int countSpecialSubsequences(int[] nums) {

        int MOD = 1000000007;
        int f0 = 0, f1 = 0, f2 = 0;

        for (int num : nums) {
            if (num == 0) {
                f0 = (f0 * 2 + 1) % MOD;
            } else if (num == 1) {
                f1 = (f0 + f1 * 2 % MOD) % MOD;
            } else {
                f2 = (f1 + f2 * 2 % MOD) % MOD;
            }
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionD().countSpecialSubsequences(new int[]{0,1,2,2}));
    }
}
