package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.SNode;

public class q2_2 {

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

        System.out.println(last(n, 3).data);
    }

    //1 last element.
    //2 returns second last
    public static SNode last(SNode list, int last) {
        SNode current = list;
        SNode runner = list;
        for (int i = 0; i < last - 1; i++) {
            if (runner.next != null) {
                runner = runner.next;
            } else {
                return null;//There are not 'last' elements in the list
            }
        }
        while (runner.next != null) {
            current = current.next;
            runner = runner.next;
        }
        return current;
    }

}



