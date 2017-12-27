package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.LimitedStack;
import me.alexng.crackingTheCodeInterview.util.SNode;

/**
 * My implementation included functionality that wasn't specified in the question. Whether when pushing the SetOfStacks should try and full old stacks before creating new stacks.
 * Make my answer a little longer.
 */
public class q3_3 {

    public static void main(String[] args) {
        SetOfStacks<Integer> stacks = new SetOfStacks<>(8);
        for (int i = 0; i < 100; i++) {
            stacks.push(i);
        }

        stacks.pop(3);
        stacks.push(10198274);

        SNode<LimitedStack<Integer>> current = stacks.stack;
        int i = 1;
        while (current != null) {
            LimitedStack<Integer> stack = current.data;
            System.out.print(i + ": ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
            current = current.next;
            i++;
        }
        System.out.println((--i) + " total stacks.");
    }

    static class SetOfStacks<T> {

        int maxSize;
        SNode<LimitedStack<T>> stack;

        public SetOfStacks(int maxSize) {
            this.maxSize = maxSize;
            stack = new SNode(new LimitedStack<>(maxSize));
        }

        public void push(T data) {
            SNode<LimitedStack<T>> current = stack;
            while (current.next != null && current.data.isFull()) {
                current = current.next;
            }
            if (current.data.isFull()) {
                current.appendToTail(new LimitedStack<T>(maxSize));
                current.next.data.push(data);//If the stack is full, we should be at the end of the linked list
            } else {
                current.data.push(data);
            }
        }

        public T pop() {
            SNode<LimitedStack<T>> current = stack;
            while (current.next != null && !current.next.data.isEmpty()) {
                current = current.next;
            }
            return current.data.pop();
        }

        /**
         * index 0 = stack 1
         * index 1 = stack 2
         */
        public T pop(int index) {
            SNode<LimitedStack<T>> current = stack;
            while (current != null && index-- > 0) {
                current = current.next;
            }
            if (current == null)
                throw new IndexOutOfBoundsException();
            return current.data.pop();
        }


        public T peek() {
            SNode<LimitedStack<T>> current = stack;
            while (current.next != null && !current.next.data.isEmpty()) {
                current = current.next;
            }
            return current.data.peek();
        }

        public boolean isEmpty() {
            SNode<LimitedStack<T>> current = stack;
            while (current != null && current.data.isEmpty()) {
                current = current.next;
            }
            return true;
        }
    }
}



