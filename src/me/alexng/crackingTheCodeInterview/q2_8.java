package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.SNode;

public class q2_8 {

    //1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> ?
    public static void main(String[] args) {
        SNode n = new SNode(1);//1 -> 2 -> 3 -> |4 -> 5 -> 6 -> 7| -> |4 -> 5 -> ...
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(4);
        n.appendToTail(5);
        n.appendToTail(6);
        n.appendToTail(7);
        n.appendToTail(8);
        n.appendToTail(n.next);

        System.out.println(loop(n).data);
    }

    public static SNode loop(SNode list) {
        SNode runner1 = list;
        SNode runner2 = list;
        while (runner1 != null && runner2 != null) {
            runner1 = runner1.next;
            runner2 = runner2.next.next;
            if (runner1 == runner2)
                break;
        }

        if (runner1 == runner2) {//The collision will always happen on the last node of the loop. So move to the next node to go to the start of the loop
            return runner1.next;
        } else {
            return null;//No loop found
        }
    }

}



