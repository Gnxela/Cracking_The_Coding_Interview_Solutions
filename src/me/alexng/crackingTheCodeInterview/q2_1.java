package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.SNode;

import java.util.ArrayList;

public class q2_1 {

    public static void main(String[] args) {
        SNode n = new SNode(3);
        n.appendToTail(3);
        n.appendToTail(3);
        n.appendToTail(3);
        n.appendToTail(3);
        n.appendToTail(3);
        n.appendToTail(3);
        n.appendToTail(3);
        n.appendToTail(7);
        n.appendToTail(2);
        n.appendToTail(7);
        n.appendToTail(8);
        n.appendToTail(8);
        n.appendToTail(1452);
        n.appendToTail(3);

        removeDupes(n);

        SNode current = n;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void removeDupes(SNode list) {
        if (list == null)
            return;
        ArrayList<Integer> data = new ArrayList<>();
        SNode<Integer> current = list;
        data.add(current.data);
        while (current.next != null) {
            if (data.contains(current.next.data)) {
                current.next = current.next.next;
            } else {
                data.add(current.next.data);
                current = current.next;
            }
        }
    }

}