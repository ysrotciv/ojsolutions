package space.yangshuai.ojsolutions.leetcode.lessons.stack;

import java.util.Stack;

/**
 * @author yangshuai on 2019-04-23.
 */
public class DailyTemperature {

    public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < T.length; ++i) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DailyTemperature().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }
}
