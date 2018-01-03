package me.alexng.crackingTheCodeInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class q4_7 {

    /**
     * Rule: If last element in entry equals any other element in other entry, you can replace other entry's element with the entire first entry.
     * Example: {'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}
     * {'a', 'd'} ends with 'd', {'d', 'c'} contains 'd'.
     * {}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'a', 'd', 'c'}
     * {'b', 'd'} ends with 'd', {'a', 'd', 'c'} contains 'd'.
     * {}, {'f', 'b'}, {}, {'f', 'a'}, {'a', 'b', 'd', 'c'}
     * {'f', 'a'} ends with 'a', {'a', 'b', 'd', 'c'} contains 'a'.
     * {}, {'f', 'b'}, {}, {}, {'f', 'a', 'b', 'd', 'c'}
     * {'f', 'b'} ends with 'b', {'f', 'a', 'b', 'd', 'c'} contains 'b'.
     * {}, {}, {}, {}, {'f', 'a', 'f', 'b', 'd', 'c'}
     * Repeated entry, remove
     * {}, {}, {}, {}, {'f', 'a', 'b', 'd', 'c'}
     * Last entry, 'e' is a free project and must be included.
     * {}, {}, {}, {}, {'f', 'e', 'a', 'b', 'd', 'c'}
     **/


    public static void main(String[] args) {
        char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};
        //A needs to be build before D
        //D is dependent on A
        //char[][] dependencies = {{}, {}, {}, {}, {, {'a', 'b', 'c', 'd', 'e', 'f', 'a'}}};
        char[][] dependencies = {{'a', 'b'}, {'b', 'c'}, {'c', 'd'}, {'d', 'e'}, {'e', 'f'}, {'f', 'a'}};
        char[] order = computeBuildOrder(projects, dependencies);
        for (char c : order) {
            System.out.print(c + " ");
        }
    }

    public static char[] computeBuildOrder(char[] projects, char[][] dependencies) {
        //Basic logic
        boolean changed = false;
        for (int i = 0; i < dependencies.length; i++) {
            if (dependencies[i] == null)
                continue;
            for (int j = 0; j < dependencies.length; j++) {
                if (dependencies[j] == null || i == j)
                    continue;
                char last = dependencies[i][dependencies[i].length - 1];//Last char in dep[i]
                for (int k = 0; k < dependencies[j].length; k++) {
                    if (dependencies[j][k] == last) {
                        changed = true;
                        System.out.print("Putting " + Arrays.toString(dependencies[i]) + " into " + Arrays.toString(dependencies[j]) + " creating ");
                        dependencies[j] = append(dependencies[i], dependencies[j], k);
                        System.out.println(Arrays.toString(dependencies[j]));
                        dependencies[i] = null;
                        break;
                    }
                }
                if (changed)
                    break;
            }
            if (changed) {//If we changed something, start again from the beginning.
                i = 0;
                changed = false;
            }
        }
        //Remove duplicates

        boolean[] flags = new boolean[projects.length];
        ArrayList<Character> order = new ArrayList<Character>();
        for (char[] ca : dependencies) {//There could be two or more possible dependency 'branches', so we can't assume they're all together
            if (ca != null) {
                for (int i = 0; i < ca.length; i++) {
                    int j;
                    for (j = 0; j < projects.length; j++) {
                        if (projects[j] == ca[i])
                            break;
                    }
                    if (!flags[j]) {
                        order.add(ca[i]);
                        flags[j] = true;
                    }
                }
            }
        }
        //Add free projects
        for (int i = 0; i < flags.length; i++) {
            if (!flags[i])
                order.add(0, projects[i]);
        }
        return toArray(order);
    }

    private static char[] toArray(ArrayList<Character> a) {
        char[] ret = new char[a.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = a.get(i).charValue();
        }
        return ret;

    }

    private static char[] append(char[] a, char[] b, int place) {
        int position = 0;
        char[] result = new char[a.length + b.length - 1];
        for (int i = 0; i < place; i++) {
            result[position++] = b[i];
        }
        for (int i = 0; i < a.length; i++) {
            result[position++] = a[i];
        }
        for (int i = place + 1; i < b.length; i++) {
            result[position++] = b[i];
        }
        return result;
    }

}
