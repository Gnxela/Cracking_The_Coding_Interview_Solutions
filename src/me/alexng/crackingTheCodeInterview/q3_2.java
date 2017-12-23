package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.Stack;

public class q3_2 {

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(5);
        stack.push(4);
        stack.push(7);
        stack.push(2);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }

    //Rather than rewriting the entire thing just extend it
    static class StackWithMin extends Stack<Integer> {

        Stack<Integer> minStack = new Stack<>();

        @Override
        public void push(Integer data) {
            if (data <= min())
                minStack.push(data);
            super.push(data);
        }

        @Override
        public Integer pop() {
            if (peek() == minStack.peek()) {
                minStack.pop();
            }
            return super.pop();
        }

        public int min() {
            if (minStack.isEmpty()) {
                return Integer.MAX_VALUE;
            }
            return minStack.peek();
        }
    }
}



