package space.yangshuai.ojsolutions.leetcode.contest.contest252;

public class SolutionB {

    public long numberOfWeeks(int[] milestones) {

        long max = 0;
        long sum = 0;
        for (int num : milestones) {
            sum += num;
            if (num > max) {
                max = num;
            }
        }

        if (max * 2 <= sum) {
            return sum;
        }
        return (sum - max) * 2L + 1;
    }

}
