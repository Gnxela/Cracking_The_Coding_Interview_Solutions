package me.alexng.crackingTheCodeInterview.util;

public class Node {
    //In my implementation I'll create a fixed node size, but you could use an arraylist style resizing.
    public Node[] nodes;
    public String name;

    public Node(String name, int neighbors) {
        this.name = name;
        this.nodes = new Node[neighbors];
    }

}