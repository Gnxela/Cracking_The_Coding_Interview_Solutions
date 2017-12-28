package me.alexng.crackingTheCodeInterview.util;

public class BinaryNode {
    public BinaryNode left, right;
    public String name;

    public BinaryNode(String name) {
        this.name = name;
    }

    public BinaryNode createLeft(String name) {
        left = new BinaryNode(name);
        return left;
    }

    public BinaryNode createRight(String name) {
        right = new BinaryNode(name);
        return right;
    }


}