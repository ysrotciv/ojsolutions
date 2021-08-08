package space.yangshuai.ojsolutions.leetcode.weekly.contest129;

public class SolutionB {

    public int smallestRepunitDivByK(int K) {

        int value = 0, length = 0;

        for (int i = 0; i < 1e6; i++) {
            value = (10 * value + 1) % K;
            length++;

            System.out.println(value);

            if (value == 0)
                return length;
        }

        return -1;
    }

    public static void main(String[] args) {
        new SolutionB().smallestRepunitDivByK(38);
    }
}
