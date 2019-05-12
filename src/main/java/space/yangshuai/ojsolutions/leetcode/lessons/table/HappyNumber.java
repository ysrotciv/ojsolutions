package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangshuai on 2019-05-08.
 */
public class HappyNumber {

    public boolean isHappy(int n) {

        if (n == 1) {
            return true;
        }

        Set<Integer> calculated = new HashSet<>();
        calculated.add(n);

        while (true) {
            int sum = 0;
            while (n >= 10) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            sum += n * n;
            if (calculated.contains(sum)) {
                return false;
            } else if (sum == 1) {
                return true;
            } else {
                calculated.add(sum);
                n = sum;
            }
        }
    }

    public static void main(String[] args) {

        new HappyNumber().isHappy(19);
    }

}
