package space.yangshuai.ojsolutions.leetcode.contest.contest134;

/**
 * @author yangshuai on 2019-04-28.
 */
public class SolutionA {

    public int[] numMovesStones(int a, int b, int c) {

        int last = Math.max(Math.max(a, b), c);
        int first = Math.min(Math.min(a, b), c);

        int mid;
        if (a != last && a != first) {
            mid = a;
        } else if (b != first && b != last) {
            mid = b;
        } else {
            mid = c;
        }

        int firstDiff = Math.abs(first - mid);
        int secondDiff = Math.abs(mid - last);

        int min = 0;
        if (firstDiff == 2 || secondDiff == 2) {
            min = 1;
        } else {
            if (firstDiff > 1) {
                min++;
            }
            if (secondDiff > 1) {
                min++;
            }
        }

        int max = firstDiff + secondDiff - 2;

        return new int[]{min, max};
    }

}
