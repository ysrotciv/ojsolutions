package space.yangshuai.ojsolutions.leetcode.lessons.table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangshuai on 2019-05-10.
 */
public class SumOfFourVersionTwo {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int count = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                count += countMap.getOrDefault(0 - sum, 0);
            }
        }

        return count;
    }


    public static void main(String[] args) {
        new SumOfFourVersionTwo().fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0});
    }

}
