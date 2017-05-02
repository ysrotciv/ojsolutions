package space.yangshuai.leetcode.medium;

/**
 * Created by rotciv on 2017/2/14.
 */
public class Solution12 {

    public String intToRoman(int num) {

        String[][] m = new String[][]{
                {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"","M","MM","MMM"}
        };

        String result = "";
        result += m[3][num / 1000 % 10];
        result += m[2][num / 100 % 10];
        result += m[1][num / 10 % 10];
        result += m[0][num % 10];

        return result;
    }

}
