package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.BinaryNode;

public class q4_2 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        BinaryNode<Integer> n = new BinaryNode<>(array[array.length / 2]);
        placeNode(n, array);

        inOrder(n);
    }

    static void inOrder(BinaryNode<Integer> n) {
        if (n != null) {
            inOrder(n.left);
            System.out.print(n.data + " ");
            inOrder(n.right);
        }
    }

    static void placeNode(BinaryNode<Integer> node, int[] array) {
        if (array.length == 1) {
            return;
        }
        if (array.length == 2) {
            if (node.data > array[0]) {
                node.left = new BinaryNode(array[0]);
            } else {
                node.right = new BinaryNode(array[0]);
            }
            return;
        }
        int len = array.length - 1;
        int[] a1 = null;
        int[] a2 = null;
        if (len % 2 == 0) {
            a1 = new int[len / 2];
            a2 = new int[len / 2];
            for (int i = 0; i < a1.length; i++) {
                a1[i] = array[i];
                a2[i] = array[a1.length + 1 + i];
            }
        } else {
            a1 = new int[len / 2 + 1];
            a2 = new int[len / 2];
            for (int i = 0; i < a1.length; i++) {
                a1[i] = array[i];
            }
            for (int i = 0; i < a2.length; i++) {
                a2[i] = array[a1.length + 1 + i];
            }

        }
        node.left = new BinaryNode<>(a1[a1.length / 2]);
        node.right = new BinaryNode<>(a2[a2.length / 2]);
        placeNode(node.left, a1);
        placeNode(node.right, a2);
    }

}
