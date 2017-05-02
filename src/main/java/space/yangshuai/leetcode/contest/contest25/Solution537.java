package space.yangshuai.leetcode.contest.contest25;

/**
 * Created by rotciv on 2017/3/26.
 */
public class Solution537 {

    public String complexNumberMultiply(String a, String b) {

        String[] fArr = a.split("\\+");
        String[] sArr = b.split("\\+");

        int fA = Integer.valueOf(fArr[0]);
        int sA = Integer.valueOf(sArr[0]);

        int fB = Integer.valueOf(fArr[1].substring(0, fArr[1].length() - 1));
        int sB = Integer.valueOf(sArr[1].substring(0, sArr[1].length() - 1));

        return fA * sA + (fB * sB * -1) + "+" + (fA * sB + sA * fB) + "i";
    }

    public static void main(String[] args) {
        System.out.println(new Solution537().complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
