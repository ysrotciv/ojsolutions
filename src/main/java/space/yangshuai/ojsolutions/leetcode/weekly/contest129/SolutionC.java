package space.yangshuai.ojsolutions.leetcode.weekly.contest129;

public class SolutionC {

    public int maxScoreSightseeingPair(int[] A) {

        int head = 0;
        int headValue = A[0];

        int max = 0;

        for (int i = 1; i < A.length; ++i) {
            int temp = headValue + A[i] + head - i;
            if (temp > max) {
                max = temp;
            }
            if (A[i] + i > head + headValue) {
                head = i;
                headValue = A[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
