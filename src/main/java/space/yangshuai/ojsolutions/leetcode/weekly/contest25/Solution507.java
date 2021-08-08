package space.yangshuai.ojsolutions.leetcode.weekly.contest25;

/**
 * Created by rotciv on 2017/3/26.
 */
public class Solution507 {

    public boolean checkPerfectNumber(int num) {

        if (num <= 1) return false;

        int sum = 1;

        for (int i = 2; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                sum += i;
                int other = num / i;
                if (other != i) sum += other;
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution507().checkPerfectNumber(99999995));
    }

}
