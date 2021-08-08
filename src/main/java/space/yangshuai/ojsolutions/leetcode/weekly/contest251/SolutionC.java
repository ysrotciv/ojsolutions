package space.yangshuai.ojsolutions.leetcode.weekly.contest251;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SolutionC {

    int max = 0;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int[][] scores = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                scores[i][j] = compare(students[i], mentors[j]);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(i);
        }
        for (int i = 0; i < m; i++) {
            Set<Integer> tmp = new HashSet<>(set);
            tmp.remove(i);
            cal(0, scores, tmp, i, 0);
        }
        return max;
    }

    private void cal(int sum, int[][] scores, Set<Integer> set, int w, int h) {
        Iterator<Integer> iterator = set.stream().iterator();
        if (h == scores.length - 1) {
            sum += scores[h][w];
            if (sum >= max) {
                max = sum;
            }
        }
        sum += scores[h][w];
        while (iterator.hasNext()) {
            int index = iterator.next();
            Set<Integer> tmp = new HashSet<>(set);
            tmp.remove(index);
            cal(sum, scores, tmp, index, h + 1);
        }
    }

    private int compare(int[] student, int[] mentor) {
        int res = 0;
        int length = student.length;
        for (int i = 0; i < length; i++) {
            if (student[i] == mentor[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] students = new int[][]{{1,1,0},{1,0,1},{0,0,1}};
        int[][] mentors = new int[][]{{1,0,0},{0,0,1},{1,1,0}};
        new SolutionC().maxCompatibilitySum(students, mentors);
    }

}
