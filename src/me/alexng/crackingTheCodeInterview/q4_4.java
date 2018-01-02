package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.BinaryNode;

public class q4_4 {

    public static void main(String[] args) {
        BinaryNode<Integer> n = new BinaryNode<>(8);
        n.createLeft(81).createLeft(811).createLeft(8111);
        n.createRight(82).createRight(822).createRight(8222);
        n.left.createRight(812);
        n.right.createLeft(821);
        /*n.createLeft(1);
        n.createRight(1);
        n.left.createLeft(1).createRight(1);
        n.right.createRight(1).createRight(1);*/

        System.out.println(isBalanced(n));
    }

    private static int getHeight(BinaryNode n) {
        if (n == null) return -1;

        int leftHeight = getHeight(n.left);
        if (leftHeight == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        int rightHeight = getHeight(n.right);
        if (rightHeight == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MAX_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static boolean isBalanced(BinaryNode n) {
        if (n == null) return true;
        return getHeight(n) != Integer.MAX_VALUE;
    }

}
