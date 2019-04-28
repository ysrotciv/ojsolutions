package space.yangshuai.ojsolutions.leetcode.lessons.stack;

import java.util.ArrayList;

/**
 * @author yangshuai on 2019-04-22.
 */
public class MinStack {

    private ArrayList<Integer> list;
    private int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
        if (x < min) {
            min = x;
        }
    }

    public void pop() {
        if (!list.isEmpty()) {
            int top = top();
            list.remove(list.size() - 1);
            if (top == min) {
                min = Integer.MAX_VALUE;
                for (Integer e : list) {
                    if (e < min) {
                        min = e;
                    }
                }
            }
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }

}
