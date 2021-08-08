package space.yangshuai.ojsolutions.leetcode.weekly.contest252;

public class SolutionA {

    public boolean isThree(int n) {
        if (n < 4) {
            return false;
        }
        if (n == 4) {
            return true;
        }
        int sqrt = (int)Math.sqrt(n);
        if (sqrt * sqrt != n) {
            return false;
        }

        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println(i + ":" + new SolutionA().isThree(i));
        }
    }

}
