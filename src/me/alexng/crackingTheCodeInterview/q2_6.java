package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.SNode;
import me.alexng.crackingTheCodeInterview.util.Stack;

public class q2_6 {

    public static void main(String[] args) {
        SNode n = new SNode(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.appendToTail(2);
        n.appendToTail(1);

        System.out.println(palindrome(n));
    }

    public static boolean palindrome(SNode list) {
        int count = 0;
        SNode runner = list;
        Stack<SNode> stack = new Stack();
        while (runner != null) {
            count++;
            stack.push(runner);
            runner = runner.next;
        }
        count /= 2;
        runner = list;
        for (int i = 0; i < count; i++) {
            if (runner.data != stack.pop().data)
                return false;
            runner = runner.next;
        }
        return true;
    }

}



