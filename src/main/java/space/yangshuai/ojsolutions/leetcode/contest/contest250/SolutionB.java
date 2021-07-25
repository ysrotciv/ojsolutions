package space.yangshuai.ojsolutions.leetcode.contest.contest250;

public class SolutionB {

    public int addRungs(int[] rungs, int dist) {
        int pre = 0;
        int ans = 0;
        for (int rung : rungs) {
            int diff = rung - pre;
            if (diff > dist) {
                ans += diff / dist;
                if (diff % dist == 0) {
                    ans--;
                }
            }
            pre = rung;
        }
        return ans;
    }

    public static void main(String[] args) {
        new SolutionB().addRungs(new int[]{1,3,5,10}, 2);
    }

}
