package space.yangshuai.ojsolutions.leetcode.lessons.array;

/**
 * @author yangshuai on 2019-04-03.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; --i) {
            int temp = digits[i];
            temp++;
            if (temp == 10) {
                digits[i] = 0;
            } else {
                digits[i] = temp;
                return digits;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(result, 1, digits, 0, digits.length);

        return result;
    }


}
