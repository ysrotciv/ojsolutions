package space.yangshuai.ojsolutions.leetcode.contest.contest248;

public class SolutionC {

    public int countGoodNumbers(long n) {
        int[] arr = new int[]{0, 5,20,100,400};
        if (n < 5) {
            return arr[(int)n];
        }
        int MOD = 1000000007;
        long res = 1;
        while (n > 1) {
            long tmp = 20;
            long power = 2;
            while (power * 2 < n) {
                tmp = tmp * tmp % MOD;
                power *= 2;
            }
            n -= power;
            res = res * tmp % MOD;
        }
        if (n == 1) {
            res = res * 5 % MOD;
        }
        return (int)res;
    }
    public static void main(String[] args) {
//        System.out.println(new SolutionC().countGoodNumbers(806166225460393L));
        System.out.println(new SolutionC().countGoodNumbers(5));
    }

}
