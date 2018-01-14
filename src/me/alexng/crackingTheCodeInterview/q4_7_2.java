package me.alexng.crackingTheCodeInterview;

import java.util.ArrayList;
import java.util.HashMap;

public class q4_7_2 {

    public static void main(String[] args) {
        char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[][] dependencies = {{'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}};

        Tree tree = new Tree();

        buildProjectTree(tree, projects, dependencies);
        Project[] order = createBuildPath(tree);
        for (Project p : order)
            if (p != null)
                System.out.println(p.getName());
            else
                System.out.println("null");
    }

    private static Project[] createBuildPath(Tree tree) {
        Project[] order = new Project[tree.nodes.size()];

        int end = addFreeProjects(order, tree.nodes, 0);

        int index = 0;
        while (index < order.length) {
            Project project = order[index++];
            if (project == null) {
                return null;
            }

            for (Project p : project.dependants) {
                p.dependencies.remove(project);
            }
            end = addFreeProjects(order, project.dependants, end);
        }
        return order;
    }

    private static int addFreeProjects(Project[] order, ArrayList<Project> projects, int end) {
        int index = end;
        for (Project p : projects) {
            if (p.dependencies.size() == 0) {
                order[index++] = p;
            }
        }
        return index;
    }

    private static void buildProjectTree(Tree tree, char[] projects, char[][] dependencies) {
        for (char c : projects) {
            tree.getOrCreate("" + c);
        }
        for (char[] c : dependencies) {
            Project one = tree.getOrCreate(("" + c[0]));
            Project two = tree.getOrCreate(("" + c[1]));
            two.dependencies.add(one);
            one.dependants.add(two);
        }
    }

    static class Tree {
        private ArrayList<Project> nodes = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();

        public Project getOrCreate(String name) {
            if (!map.containsKey(name)) {
                Project p = new Project(name);
                nodes.add(p);
                map.put(name, p);
            }
            return map.get(name);
        }

        public ArrayList<Project> getNodes() {
            return nodes;
        }
    }

    static class Project {

        private String name;
        private ArrayList<Project> dependencies;
        private ArrayList<Project> dependants;

        public Project(String name) {
            this.name = name;
            dependencies = new ArrayList<>();
            dependants = new ArrayList<>();
        }

        public String getName() {
            return name;
        }
    }
}
