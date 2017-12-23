package me.alexng.crackingTheCodeInterview.util;

public class Queue<T> {

    public Node<T> first;
    public Node<T> last;

    /*This works, except is not optimal.
    public void add(T data) {
        if(first == null)
            first  = new Node<T>(data);
        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<T>(data);
    }
    */
    public void add(T data) {
        Node node = new Node<T>(data);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null)
            first = last;
    }


    public T remove() {
        if (first == null) throw new NullPointerException();
        Node<T> node = first;
        first = first.next;
        if (first == null)
            last = null;
        return node.data;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

}
