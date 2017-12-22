package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.SNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class q2_7 {

    public static void main(String[] args) {
        SNode n = new SNode(1);
        Random generator = new Random();
        for (int i = 0; i < 1000; i++) {
            n.appendToTail(generator.nextInt(50));
        }

        SNode b = new SNode(2);
        b.appendToTail(3);
        SNode x = n;
        for (int i = 0; i < 900; i++) {
            x = x.next;
        }
        b.appendToTail(x);
        //n.appendToTail(1);

        long startTime = System.nanoTime();
        long endTime = System.nanoTime();

        startTime = System.nanoTime();
        collide1(n, b);
        endTime = System.nanoTime();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");

        startTime = System.nanoTime();
        collide2(n, b);
        endTime = System.nanoTime();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");

    }

    public static boolean collide1(SNode list1, SNode list2) {
        SNode current = list1;
        int i = 0;
        while (current != null) {
            SNode n = list2;
            while (n != null) {
                i++;
                if (n == current) {
                    System.out.println("Comparisons: " + i);
                    return true;
                }
                n = n.next;
            }
            current = current.next;
        }
        return false;
    }

    //Thought of a another solution
    public static boolean collide2(SNode list1, SNode list2) {
        SNode current = list1;
        HashMap<Integer, ArrayList<SNode>> map = new HashMap<>();
        int i = 0;
        while (current != null) {
            ArrayList<SNode> list = map.computeIfAbsent(current.data, k -> new ArrayList<>());
            list.add(current);
            current = current.next;
        }
        SNode n = list2;
        while (n != null) {
            ArrayList<SNode> list = map.get(n.data);
            if (list != null) {
                for (SNode node : list) {
                    i++;
                    if (n == node) {
                        System.out.println("Comparisons: " + i);
                        return true;
                    }
                }
            }
            n = n.next;
        }
        return false;
    }

}



