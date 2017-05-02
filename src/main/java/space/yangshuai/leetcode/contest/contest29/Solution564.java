package space.yangshuai.leetcode.contest.contest29;

/**
 * Created by rotciv on 2017/4/23.
 */
public class Solution564 {

    private String getString(String n) {

        int i , length = n.length();
        StringBuilder builder = new StringBuilder();
        for (i = 0;i < length / 2;i ++) {
            builder.append(n.charAt(i));
        }
        if (length % 2 == 1) {
            builder.append(n.charAt(length / 2));
        }
        for (i = length / 2 - 1;i >= 0;i --) {
            builder.append(n.charAt(i));
        }
        return builder.toString();

    }

    public String nearestPalindromic(String n) {

        long minDiff = - 1 , ans = - 1;
        int i , length = n.length();
        String s = getString(n);
        long target = Long.parseLong(n);
        long value = Long.parseLong(s);
        char[] array = s.toCharArray();

        if (value != target) {
            long diff = Math.abs(value - target);
            if (diff < minDiff || minDiff < 0) {
                minDiff = diff;
                ans = value;
            } else if (diff == minDiff) {
                if (value < ans) {
                    ans = value;
                }
            }
        }

        int pos = length / 2;
        if (length % 2 == 0) {
            pos --;
        }
        int tempPos = pos;
        // 从pos开始变大一个或者变小一个
        // 变大
        while (pos >= 0 && array[pos] == '9') {
            pos --;
        }
        if (pos < 0) {
            long temp = 1;
            for (i = 0;i < length;i ++) {
                temp *= 10;
            }
            temp ++;
            long diff = Math.abs(temp - target);
            if (diff < minDiff || minDiff < 0) {
                minDiff = diff;
                ans = temp;
            } else if (diff == minDiff) {
                if (temp < ans) {
                    ans = temp;
                }
            }
        } else {
            int pos1 = pos;
            int pos2 = length - pos - 1;
            array[pos1] ++;
            if (pos1 != pos2)
                array[pos2] ++;
            long temp = Long.parseLong(new String(array));
            long diff = Math.abs(temp - target);
            if (diff < minDiff || minDiff < 0) {
                minDiff = diff;
                ans = temp;
            } else if (diff == minDiff) {
                if (temp < ans) {
                    ans = temp;
                }
            }
            array[pos1] --;
            if (pos1 != pos2)
                array[pos2] --;
        }

        // 变小
        pos = tempPos;
        while (pos >= 0 && array[pos] == '0') {
            pos --;
        }
        int pos1 = pos , pos2 = length - pos - 1;
        array[pos1] --;
        if (pos1 != pos2)
            array[pos2] --;
        // 如果是第一个
        if (pos == 0 && array[pos] == '0') {
            long temp = 0;
            for (i = 0;i < length - 1;i ++) {
                temp = temp * 10 + 9;
            }
            long diff = Math.abs(temp - target);
            if (diff < minDiff || minDiff < 0) {
                minDiff = diff;
                ans = temp;
            } else if (diff == minDiff) {
                if (temp < ans) {
                    ans = temp;
                }
            }
        } else {
            long temp = Long.parseLong(new String(array));
            long diff = Math.abs(temp - target);
            if (diff < minDiff || minDiff < 0) {
                minDiff = diff;
                ans = temp;
            } else if (diff == minDiff) {
                if (temp < ans) {
                    ans = temp;
                }
            }
        }

        return Long.toString(ans);

    }

    public static void main(String[] args) {
        System.out.println(new Solution564().nearestPalindromic("1283"));
    }

}
