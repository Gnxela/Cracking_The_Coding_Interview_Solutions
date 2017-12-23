package me.alexng.crackingTheCodeInterview.util;

import java.util.EmptyStackException;

public class Stack<T> {

    private Node<T> top;

    public void push(T data) {
        Node<T> node = new Node<T>(data);
        node.next = top;
        top = node;
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static class Node<T> {

        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

}
