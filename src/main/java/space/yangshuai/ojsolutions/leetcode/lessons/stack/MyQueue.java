package space.yangshuai.ojsolutions.leetcode.lessons.stack;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author yangshuai on 2019-04-24.
 */
public class MyQueue {

    Stack<Integer> head = new Stack<>();
    Stack<Integer> tail = new Stack<>();
    private int size = 0;

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (!empty() && !tail.isEmpty()) {
            swap(tail, head);
        }
        size++;
        head.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        if (tail.isEmpty()) {
            swap(head, tail);
        }
        size--;
        return tail.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        if (tail.isEmpty()) {
            swap(head, tail);
        }
        return tail.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size == 0;
    }

    private void swap(Stack a, Stack b) {
        while (!a.isEmpty()) {
            b.push(a.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_3 = obj.peek();
        int param_2 = obj.pop();
        boolean param_4 = obj.empty();
    }
}
