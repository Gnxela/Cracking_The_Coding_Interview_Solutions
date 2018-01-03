package me.alexng.crackingTheCodeInterview.util;

public class BinaryNode<T> {
    public BinaryNode<T> left, right;
    public T data;

    public BinaryNode(T data) {
        this.data = data;
    }

    public BinaryNode createLeft(T name) {
        left = new BinaryNode(name);
        return left;
    }

    public BinaryNode createRight(T name) {
        right = new BinaryNode(name);
        return right;
    }


}