package space.yangshuai.ojsolutions.leetcode.lessons.stack;

import java.util.LinkedList;

/**
 * @author yangshuai on 2019-04-24.
 */
public class MyStack {

    LinkedList<Integer> main = new LinkedList<>();
    LinkedList<Integer> vice = new LinkedList<>();
    private int size;

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        size++;
        main.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (size == 1) {
            size--;
            return main.pop();
        }
        for (int i = 0; i < size - 1; ++i) {
            vice.add(main.pop());
        }
        int result = main.pop();
        main = vice;
        vice = new LinkedList<>();
        size--;
        return result;
    }

    /** Get the top element. */
    public int top() {
        for (int i = 0; i < size - 1; ++i) {
            vice.add(main.pop());
        }
        int result = main.pop();
        vice.add(result);
        main = vice;
        vice = new LinkedList<>();
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.top();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
    }

}
