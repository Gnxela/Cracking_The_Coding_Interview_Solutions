package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.BinaryNode;
import me.alexng.crackingTheCodeInterview.util.SNode;

import java.util.HashMap;

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
        n.left.left.left = new BinaryNode(8111);

        SNode<Integer> level = getLevels(n, 3).get(3);
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

    public static HashMap<Integer, SNode<Integer>> getLevels(BinaryNode<Integer> base, int level) {
        HashMap<Integer, SNode<Integer>> map = new HashMap<>();
        map.put(0, new SNode<>(base.data));
        return getLevels(base, map, level, 0);
    }

    private static HashMap<Integer, SNode<Integer>> getLevels(BinaryNode<Integer> base, HashMap<Integer, SNode<Integer>> map, int level, int running) {
        if (base == null) {
            return null;
        }

        SNode node = map.get(++running);
        if (node == null) {//Logic is a bit ugly but works
            if (base.left != null) {
                node = new SNode(base.left.data);
                if (base.right != null) {
                    node.appendToTail(base.right.data);
                }
            } else if (base.right != null) {
                node = new SNode(base.right.data);
            }
            map.put(running, node);
        } else {
            if (base.left != null)
                node.appendToTail(base.left.data);
            if (base.right != null)
                node.appendToTail(base.right.data);
        }

        if (level != running) {
            getLevels(base.left, map, level, running);
            getLevels(base.right, map, level, running);
        }

        return map;
    }

}
