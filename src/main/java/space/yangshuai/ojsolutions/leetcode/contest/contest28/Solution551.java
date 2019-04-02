package space.yangshuai.ojsolutions.leetcode.contest.contest28;

/**
 * Created by rotciv on 2017/4/16.
 */
public class Solution551 {

    public boolean checkRecord(String s) {
        int lNum = 0;
        int aNum = 0;
        for (char c: s.toCharArray()) {
            if (c == 'A') {
                aNum++;
                if (aNum > 1) {
                    return false;
                }
                lNum = 0;
            } else if (c == 'L') {
                lNum++;
                if (lNum > 2) {
                    return false;
                }
            } else {
                lNum = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution551().checkRecord("PPALLPLLPAP"));
    }
}
