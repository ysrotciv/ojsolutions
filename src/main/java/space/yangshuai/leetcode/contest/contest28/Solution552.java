package space.yangshuai.leetcode.contest.contest28;

/**
 * Created by rotciv on 2017/4/16.
 */
public class Solution552 {

    public int checkRecord(int n) {
        if (n % 3 == 2) {

            int p = (n + 1) / 3;
            int l = n - p;
            int sumA = (p + n) * (n - p + 1) / 2;
            double sumP = Math.pow(2, l);

            return (int) (sumP % (Math.pow(10,9) + 7) + sumA);
        } else if (n % 3 == 1) {
            int p = (n + 2) / 3;
            int l = n - p;
            int sumA = (p + n) * (n - p + 1) / 2;
            double sumP = Math.pow(2, l);
            return (int) ((sumA + sumP) * ((l + 1) / 2) %(Math.pow(10, 9) + 7));
        } else {

        }
        return 0;
    }

}
