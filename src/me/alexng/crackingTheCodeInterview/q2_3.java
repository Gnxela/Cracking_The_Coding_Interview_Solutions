package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.SNode;

public class q2_3 {

    public static void main(String[] args) {
        SNode n = new SNode(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(4);
        n.appendToTail(5);
        n.appendToTail(6);
        n.appendToTail(7);
        n.appendToTail(8);
        n.appendToTail(9);
        n.appendToTail(10);
        n.appendToTail(11);
        n.appendToTail(12);
        n.appendToTail(13);
        n.appendToTail(14);
        n.appendToTail(15);

        deleteMiddle(n);

        SNode current = n;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void deleteMiddle(SNode list) {
        SNode current = list;
        SNode runner = list;
        while (runner.next != null && runner.next.next != null) {
            current = current.next;
            runner = runner.next.next;
        }
        current.next = current.next.next;
    }

}



