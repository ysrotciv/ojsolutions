package space.yangshuai.leetcode.hard;

/**
 * Created by rotciv on 2017/3/2.
 */
public class Solution273 {

    public String numberToWords(int num) {

        if (num == 0)
            return "Zero";

        String result = "";
        int temp = num % 1000;

        result += convert(temp, "");

        if (num > 999) {
            temp = num / 1000 % 1000;
            if (temp != 0)
                result = convert(temp, "Thousand") + " " + result;
        }

        if (num > 999999) {
            temp = num / 1000000 % 1000;
            if (temp != 0)
                result = convert(temp, "Million") + " " + result;
        }

        if (num > 999999999) {
            temp = num / 1000000000 % 1000;
            result = convert(temp, "Billion") + " " + result;
        }

        return result.trim();
    }

    private String convert(int num, String suffix) {

        String[] inHundred = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] ty = new String[]{"", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        String result = "";

        int bit = num / 100;
        if (bit != 0) {
            result += inHundred[bit - 1] + " Hundred";
        }
        bit = num % 100;
        if (bit != 0) {
            if (bit < 20) {
                result += " " + inHundred[bit - 1];
            } else {
                bit = num % 100 / 10;
                result += " " + ty[bit - 1];
                bit = num % 10;
                if (bit != 0)
                    result += " " + inHundred[bit - 1];
            }
        }

        if (suffix != "" && result != "")
            result += " " + suffix;
        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(new Solution273().numberToWords(1000010));
    }
}
