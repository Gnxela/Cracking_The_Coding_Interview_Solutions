package me.alexng.crackingTheCodeInterview;

public class q1_2 {

    public static void main(String[] args) {
        String s1 = "thing";
        String s2 = "thing";
        System.out.println(perm(s1, s2) + ":" + s1 + ":" + s2);
    }

    private static boolean perm(String s1, String s2) {
        char[] c1, c2;
        if (s1.length() > s2.length()) {
            c1 = s1.toCharArray();
            c2 = s2.toCharArray();
        } else if (s1.length() < s2.length()) {
            c1 = s2.toCharArray();
            c2 = s1.toCharArray();
        } else {
            return s1.equals(s2);
        }
        for (int index = 0; index < c1.length - c2.length + 1; index++) {
            int pointer = 0;
            for (; pointer < c2.length; pointer++) {
                if (c1[index + pointer] != c2[pointer]) {
                    break;
                }
            }
            if (pointer == c2.length) {
                return true;
            }
        }
        return false;
    }

}
