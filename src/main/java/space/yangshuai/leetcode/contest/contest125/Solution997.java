package space.yangshuai.leetcode.contest.contest125;

public class Solution997 {

    public int findJudge(int N, int[][] trust) {

        int[] arr = new int[N];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            arr[a - 1] = -1;
            if (arr[b - 1] != -1) {
                arr[b - 1]++;
            }
        }

        int count = 0;
        int result = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == N - 1) {
                count++;
                result = i + 1;
            }
        }

        if (count == 1) {
            return result;
        }

        return -1;
    }
}
