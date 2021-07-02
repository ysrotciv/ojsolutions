package space.yangshuai.ojsolutions.leetcode.lessons.string;

/**
 * @author yangshuai on 2020/12/4.
 */
public class ReverseInteger {

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        long y = (long)x;
        boolean negative = false;
        while (true) {
            if (y % 10 == 0) {
                y /= 10;
            } else {
                break;
            }
        }
        if (y < 0) {
            negative = true;
            y = -y;
        }
        String input = String.valueOf(y);
        char[] arr = input.toCharArray();
        for (int i = 0; i < input.length() / 2; ++i) {
            char temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        String result = String.valueOf(arr);
        if (negative) {
            result = "-" + result;
        }

        long longResult = Long.parseLong(result);
        if (longResult > Integer.MAX_VALUE || longResult < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int)longResult;
        }
    }

    public static void main(String[] args) {
        new ReverseInteger().reverse(-2147483648);
    }
}
