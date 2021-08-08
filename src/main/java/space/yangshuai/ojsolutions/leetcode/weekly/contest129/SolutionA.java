package space.yangshuai.ojsolutions.leetcode.weekly.contest129;

import java.util.Arrays;

public class SolutionA {

    public boolean canThreePartsEqualSum(int[] A) {

        int sum = Arrays.stream(A).sum();
        if (sum % 3 != 0) {
            return false;
        }

        int a = sum / 3;

        int count = 0;
        int temp = 0;
        for (int i : A) {
            temp += i;
            if (temp == a) {
                count ++;
                temp = 0;
            }
        }

        return count >= 3;
    }

    public static void main(String[] args) {

    }
}
