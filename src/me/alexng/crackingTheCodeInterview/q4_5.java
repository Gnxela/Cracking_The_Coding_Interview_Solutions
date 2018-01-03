package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.BinaryNode;

public class q4_5 {

    public static void main(String[] args) {
        BinaryNode<Integer> n = new BinaryNode<>(8);
        n.createLeft(8).createLeft(2);
        n.left.createRight(9);
        n.createRight(82);

        System.out.println(isBinarySearchTree(n));
    }

    public static boolean isBinarySearchTree(BinaryNode<Integer> n) {
        if (n.right != null) {
            if (n.right.data <= n.data || !isBinarySearchTree(n.right))
                return false;
        }
        if (n.left != null) {
            if (n.left.data > n.data || !isBinarySearchTree(n.left))
                return false;
        }
        return true;
    }

}
