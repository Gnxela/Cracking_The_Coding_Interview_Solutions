package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.BinaryNode;
import me.alexng.crackingTheCodeInterview.util.SNode;

public class q4_3 {

    public static void main(String[] args) {
        BinaryNode<Integer> n = new BinaryNode<>(8);
        n.left = new BinaryNode(81);
        n.right = new BinaryNode(82);
        n.left.left = new BinaryNode(811);
        n.left.right = new BinaryNode(812);
        n.right.left = new BinaryNode(821);
        n.right.right = new BinaryNode(822);
        n.right.right.right = new BinaryNode(8222);

        SNode<Integer> level = getLevel(n, 3);
        while (level != null) {
            System.out.println(level.data);
            level = level.next;
        }
    }

    /**
     * Adds to list from left to right.
     *
     * @param base
     * @param level 0 - x
     * @return
     */
    private static SNode<Integer> getLevel(BinaryNode<Integer> base, int level) {
        if (base == null) {
            return null;
        }
        if (level == 0) {
            return new SNode<>(base.data);
        }

        SNode<Integer> node = getLevel(base.left, level - 1);
        if (node == null) {
            node = getLevel(base.right, level - 1);
        } else {
            node.appendToTail(getLevel(base.right, level - 1));
        }

        return node;
    }

}
