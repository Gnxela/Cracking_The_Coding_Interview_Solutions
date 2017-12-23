package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.SNode;

public class q2_4 {

    public static void main(String[] args) {
        SNode n = new SNode(1);
        n.appendToTail(2);
        n.appendToTail(13);
        n.appendToTail(5);
        n.appendToTail(6);
        n.appendToTail(9);
        n.appendToTail(10);
        n.appendToTail(11);
        n.appendToTail(4);
        n.appendToTail(12);
        n.appendToTail(14);
        n.appendToTail(8);
        n.appendToTail(15);
        n.appendToTail(7);
        n.appendToTail(3);

        n = partition(n, 7);
        System.out.println(1);

        SNode current = n;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static SNode partition(SNode list, int partition) {
        SNode<Integer> before = null;
        SNode<Integer> after = null;
        SNode<Integer> current = list;
        while (current != null) {
            if (current.data < partition) {
                if (before == null) {
                    before = new SNode(current.data);
                } else {
                    before.appendToTail(current.data);
                }
            } else {
                if (after == null) {
                    after = new SNode(current.data);
                } else {
                    after.appendToTail(current.data);
                }
            }
            current = current.next;
        }
        if (before == null)//If nothing was added to before just return after.
            return after;
        current = after;
        while (current != null) {
            before.appendToTail(current.data);
            current = current.next;
        }
        return before;
    }

}



