package space.yangshuai.ojsolutions.leetcode.easy;

import java.util.Stack;

/**
 * Created by Administrator on 2015/12/20.
 */
public class Solution232 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackR = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        if (stack.size() < stackR.size())
            convert();
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
        if (stackR.size() < stack.size())
            convert();
        return stackR.pop();
    }

    // Get the front element.
    public int peek() {
        if (stackR.size() < stack.size())
            convert();
        return stackR.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return Math.max(stack.size(), stackR.size()) == 0;
    }

    private void convert() {

        int size = Math.max(stack.size(), stackR.size());

        if (stack.size() < stackR.size()) {
            for (int i = 0; i < size; i++) {
                stack.push(stackR.pop());
            }
        } else {
            for (int i = 0; i < size; i++) {
                stackR.push(stack.pop());
            }
        }
    }
}
