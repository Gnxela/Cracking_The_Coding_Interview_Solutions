package me.alexng.crackingTheCodeInterview.util;

/**
 * A singly linked list for used in section 2.
 */
public class SNode {
    public SNode next;
    public int data;

    public SNode(int data) {
        this.data = data;
    }

    public void appendToTail(int d) {
        SNode n = new SNode(d);
        SNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = n;
    }

}
