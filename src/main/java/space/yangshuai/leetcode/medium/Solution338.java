package space.yangshuai.leetcode.medium;

/**
 * Created by Administrator on 2016/8/6.
 */
public class Solution338 {

    public static int[] countBits2(int num) {

        if (num == 0) {
            return new int[]{0};
        }

        int temp = 1;

        int[] result = new int[num + 1];
        result[0] = 0;

        int temp2;

        for (int i = 1; i < num + 1; i++) {

            if (result[i] != 0)
                continue;

            if (i == temp * 2) {

                temp = temp * 2;
                result[i] = 1;

            } else {

                if (i == 1) {
                    result[i] = 1;
                } else {

                    result[i] = result[i - temp] + 1;
                    temp2 = temp * 2;

                    while (temp2 + i <= num) {
                        result[i + temp2] = result[i] + 1;
                        temp2 *= 2;
                    }

                }

            }

        }

        return result;
    }

    public static int[] countBits(int num) {

        if (num == 0) {
            return new int[]{0};
        }

        if (num == 1) {
            return new int[]{0, 1};
        }

        if (num == 2) {
            return new int[]{0, 1, 1};
        }

        int temp = 2;

        int[] result = new int[num + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 1;

        for (int i = 3; i < num + 1; i++) {

            if (i == temp * 2) {
                result[i] = 1;
                temp *= 2;
            } else {
                result[i] = result[i - temp] + 1;
            }

        }

        return result;
    }

}
