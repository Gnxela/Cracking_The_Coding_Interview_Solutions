package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.Graph;
import me.alexng.crackingTheCodeInterview.util.Node;
import me.alexng.crackingTheCodeInterview.util.Queue;

import java.util.HashMap;

public class q4_1 {

    public static void main(String[] args) {
        Graph g = new Graph(new Node("6", 1), new Node("5", 1), new Node("4", 1), new Node("3", 1), new Node("2", 2), new Node("1", 1), new Node("0", 1));
        g.nodes[0].nodes[0] = g.nodes[1];
        g.nodes[1].nodes[0] = g.nodes[2];
        g.nodes[2].nodes[0] = g.nodes[0];

        g.nodes[3].nodes[0] = g.nodes[4];
        g.nodes[4].nodes[0] = g.nodes[3];
        g.nodes[4].nodes[1] = g.nodes[6];
        g.nodes[6].nodes[0] = g.nodes[5];
        g.nodes[5].nodes[0] = g.nodes[4];

        for (Node n : g.nodes) {
            System.out.print(n.name + ": ");
            for (Node no : n.nodes) {
                System.out.print(no.name + " ");
            }
            System.out.println();
        }

        System.out.println("\n\n");
        System.out.println("  6 5 4 3 2 1 0");
        for (int i = 0; i < g.nodes.length; i++) {
            System.out.print(g.nodes[i].name + " ");
            for (int j = 0; j < g.nodes.length; j++) {
                System.out.print((isRoute(g.nodes[i], g.nodes[j]) ? "X" : "O") + " ");
            }
            System.out.println();
        }

    }

    //Perform two breadth first searches
    public static boolean isRoute(Node a, Node b) {
        Queue<Node> qa = new Queue<>();
        Queue<Node> qb = new Queue<>();
        HashMap<String, Boolean> aseen = new HashMap<>();//Should probably think of a solution with less memory requirements, but will do for now
        HashMap<String, Boolean> bseen = new HashMap<>();

        qa.add(a);
        qb.add(b);
        while (!qa.isEmpty() || !qb.isEmpty()) {
            Node na = null;
            Node nb = null;
            if (!qa.isEmpty()) {
                na = qa.remove();
                for (Node c : na.nodes)
                    if (aseen.get(c.name) == null) {
                        aseen.put(c.name, true);
                        qa.add(c);
                    }
            }
            if (!qb.isEmpty()) {
                nb = qb.remove();
                for (Node c : nb.nodes)
                    if (bseen.get(c.name) == null) {
                        bseen.put(c.name, true);
                        qb.add(c);
                    }
            }
            //Checks for a collision on either the current a or b node.
            if ((na != null && aseen.get(na.name) != null && bseen.get(na.name) != null) || (nb != null && aseen.get(nb.name) != null && bseen.get(nb.name) != null)) {
                return true;
            }
        }
        return false;
    }

}
