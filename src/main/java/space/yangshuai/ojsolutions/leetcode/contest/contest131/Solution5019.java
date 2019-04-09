package space.yangshuai.ojsolutions.leetcode.contest.contest131;

/**
 * @author yangshuai on 2019-04-07.
 */
public class Solution5019 {

    public int videoStitching(int[][] clips, int T) {

        int result = 0;
        int start = 0;
        int max = 0;

        while (true) {

            for (int[] clip : clips) {
                int begin = clip[0];
                if (begin <= start) {
                    int end = clip[1];
                    if (end > max) {
                        max = end;
                    }
                }
            }

            if (max > start) {
                start = max;
                result++;
                if (start >= T) {
                    return result;
                }
            } else {
                return -1;
            }

        }

    }

}
