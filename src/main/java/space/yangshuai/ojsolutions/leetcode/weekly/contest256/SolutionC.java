package space.yangshuai.ojsolutions.leetcode.weekly.contest256;


import java.util.ArrayList;
import java.util.Arrays;

public class SolutionC {

    public int minSessions(int[] tasks, int sessionTime) {
        Arrays.sort(tasks);
        ArrayList<Integer> list = new ArrayList<>();
        for (int value : tasks) {
            list.add(value);
        }
        int count = 0;
        while (!list.isEmpty()) {
            int temp = sessionTime;
            for (int i = list.size() - 1; i >= 0; i--) {
                int value = list.get(i);
                if (value <= temp) {
                    temp -= value;
                    list.remove(i);
                }
                if (temp == 0) {
                    break;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionC().minSessions(new int[]{2,3,3,4,4,4,5,6,7,10}, 12));
    }
}
