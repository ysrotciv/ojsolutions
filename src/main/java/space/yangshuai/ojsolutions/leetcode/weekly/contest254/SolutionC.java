package space.yangshuai.ojsolutions.leetcode.weekly.contest254;

import java.math.BigInteger;

public class SolutionC {

    public int minNonZeroProduct(int p) {

        int mod = 1000000007;

        return BigInteger.valueOf((1L << p) - 2)
                .modPow(BigInteger.valueOf((1L << p - 1) - 1), BigInteger.valueOf(mod))
                .multiply(BigInteger.valueOf((1L << p) - 1))
                .mod(BigInteger.valueOf(mod))
                .intValue();

    }
}
