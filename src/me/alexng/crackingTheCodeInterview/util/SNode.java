package me.alexng.crackingTheCodeInterview.util;

/**
 * A singly linked list for used in section 2.
 */
public class SNode<T> {
    public SNode<T> next;
    public T data;

    public SNode(T data) {
        this.data = data;
    }

    public void appendToTail(T d) {
        SNode<T> n = new SNode(d);
        SNode<T> current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = n;
    }

    public void appendToTail(SNode d) {
        SNode<T> current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = d;
    }

}
