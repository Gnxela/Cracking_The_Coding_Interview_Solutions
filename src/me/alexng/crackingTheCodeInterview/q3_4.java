package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.Stack;

import java.util.EmptyStackException;

public class q3_4 {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

    static class MyQueue<T> {

        private Stack<T> stack1 = new Stack<>();
        private Stack<T> stack2 = new Stack<>();

        public void add(T data) {
            stack1.push(data);
        }

        public T remove() {
            while (true) {
                try {
                    T data = stack1.pop();
                    stack2.push(data);
                } catch (EmptyStackException e) {
                    //We've reached the end of the stack.
                    T ret = stack2.pop();
                    while (true) {
                        try {
                            T data = stack2.pop();
                            stack1.push(data);
                        } catch (EmptyStackException e1) {
                            break;
                        }
                    }
                    return ret;
                }
            }
        }

    }
}



