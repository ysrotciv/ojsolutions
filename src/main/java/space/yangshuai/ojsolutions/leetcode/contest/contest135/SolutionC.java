package space.yangshuai.ojsolutions.leetcode.contest.contest135;

/**
 * @author yangshuai on 2019-05-05.
 */
public class SolutionC {

    public int minScoreTriangulation(int[] A) {

        int length = A.length;
        int[][] arr = new int[length][length];

        arr[0][1] = 0;

        for (int diff = 2; diff < A.length; ++diff) {
            for (int i = 0; i < length; ++i) {
                int j = (i + diff) % length;
                arr[i][j] = Integer.MAX_VALUE;
                if (diff == 2) {
                    int mid = (i + 1) % length;
                    arr[i][j] = A[i] * A[mid] * A[j];
                    arr[mid][j] = 0;
                } else {
                    for (int k = i + 1; k < j; ++k) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j] + A[i] * A[j] * A[k]);
                    }
                }
            }
        }

        return arr[0][length - 1];
    }

    public static void main(String[] args) {
        new SolutionC().minScoreTriangulation(new int[]{3, 7, 4, 5});
    }
}
