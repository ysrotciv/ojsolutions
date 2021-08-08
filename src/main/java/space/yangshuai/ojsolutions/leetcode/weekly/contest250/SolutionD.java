package space.yangshuai.ojsolutions.leetcode.weekly.contest250;

public class SolutionD {

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = cal(parents, queries[i][0], queries[i][1]);
        }
        return ans;
    }

    private int cal(int[] parents, int node, int val) {
        int max = 0;
        while (node > -1) {
            max = Math.max(max, node ^ val);
            node = parents[node];
        }
        return max;
    }

}
