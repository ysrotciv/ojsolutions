package space.yangshuai.ojsolutions.leetcode.weekly.contest133;

import java.util.Arrays;

public class SolutionA {

    private class Interviewer implements Comparable<Interviewer> {

        public Interviewer(int a, int b) {
            this.offset = Math.abs(a - b);
            this.a = a;
            this.b = b;
        }

        private int offset;

        private int a;

        private int b;

        @Override
        public int compareTo(Interviewer o) {
            if (this.offset < o.offset) {
                return 1;
            } else if (this.offset > o.offset) {
                return -1;
            } else {
                return 0;
            }
        }
    }


    public int twoCitySchedCost(int[][] costs) {

        Interviewer[] interviewers = new Interviewer[costs.length];
        for (int i = 0; i < costs.length; ++i) {
            Interviewer interviewer = new Interviewer(costs[i][0], costs[i][1]);
            interviewers[i] = interviewer;
        }

        Arrays.sort(interviewers);

        int sum = 0;
        int aCount = 0;
        int bCount = 0;

        for (Interviewer interviewer : interviewers) {
            if (aCount == interviewers.length / 2) {
                sum += interviewer.b;
                continue;
            }
            if (bCount == interviewers.length / 2) {
                sum += interviewer.a;
                continue;
            }
            if (interviewer.a > interviewer.b) {
                sum += interviewer.b;
                bCount++;
            } else if (interviewer.a < interviewer.b) {
                sum += interviewer.a;
                aCount++;
            } else {
                sum += interviewer.a;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{10,20},{30,200},{400,50},{30,20}};
        new SolutionA().twoCitySchedCost(arr);
    }
}
