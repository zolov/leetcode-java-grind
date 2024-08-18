package ru.zolov.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Design a stack class that supports the push, pop, top, and getMin operations.
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * Each function should run in O(1) time.
 *
 * @author skaiur
 */
public class MInStackSolution {
    static class MinStack {

        private final Deque<Integer> stack;
        private final Deque<Integer> min;

        public MinStack() {
            this.min = new ArrayDeque<>();
            this.stack = new ArrayDeque<>();
        }

        public void push(int val) {
            stack.push(val);
            int minVal = Math.min(
                    val,
                    min.isEmpty() ? val : min.peek()
            );
            min.push(minVal);
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.getFirst();
        }

        public int getMin() {
            return this.min.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);

        System.out.println(minStack.getMin()); // return 0
        minStack.pop();
        System.out.println(minStack.top());    // return 2
        System.out.println(minStack.getMin()); // return 1
    }
}
