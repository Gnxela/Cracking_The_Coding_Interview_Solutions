package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.SNode;

/**
 * My answer here is a bit longer than needed, really went out of my way to insure any input worked.
 */
public class q2_5 {

    public static void main(String[] args) {
        SNode a = new SNode(6);
        a.appendToTail(1);
        a.appendToTail(1);
        a.appendToTail(1);
        a.appendToTail(7);

        SNode b = new SNode(2);
        b.appendToTail(9);
        b.appendToTail(5);

        SNode blah = sum(a, b);

        SNode current = blah;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static SNode sum(SNode a, SNode b) {
        int length = 0;
        SNode result = null;
        SNode i = a;
        SNode j = b;

        //Count the max numbers in the list, question didn't specify what was and wasn't valid input
        while (i != null || j != null) {
            if (i != null)
                i = i.next;
            if (j != null)
                j = j.next;
            length++;
        }
        i = a;
        j = b;

        //The real logic is here. Basically add the two numbers and split into carry and sum
        int carry = 0;
        for (int k = 0; k < length; k++) {
            int sum = (i == null ? 0 : i.data) + (j == null ? 0 : j.data) + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (result == null)
                result = new SNode(sum);
            else
                result.appendToTail(sum);
            if (i != null)
                i = i.next;
            if (j != null)
                j = j.next;
        }
        if (carry != 0)
            result.appendToTail(carry);
        return result;
    }

}



