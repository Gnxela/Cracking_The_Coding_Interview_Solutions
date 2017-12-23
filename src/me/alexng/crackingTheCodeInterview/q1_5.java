package me.alexng.crackingTheCodeInterview;

public class q1_5 {

    public static void main(String[] args) {
        String input1 = "hello";
        String input2 = "helalo";
        System.out.println(check(input1, input2));
    }

    private static boolean check(String input1, String input2) {
        boolean change = false;
        if (Math.abs(input1.length() - input2.length()) > 1) {
            return false;
        }
        if (Math.abs(input1.length() - input2.length()) == 1) {//Adding and removing a character are the same for the propose of this check
            System.out.println("Mode: 1");
            char[] a1 = input1.length() > input2.length() ? input1.toCharArray() : input2.toCharArray();
            char[] a2 = input1.length() > input2.length() ? input2.toCharArray() : input1.toCharArray();
            int j = 0;
            for (int i = 0; i < a1.length; i++) {
                if (a1[i] == a2[j]) {
                    System.out.println(a1[i] + "=" + a2[j]);
                } else {
                    System.out.println(a1[i] + "!" + a2[j]);
                    if (change) {
                        return false;
                    } else {
                        change = true;
                    }
                    j--;
                }
                j++;
            }
            return true;
        } else {
            System.out.println("Mode: 2");
            char[] a1 = input1.toCharArray();
            char[] a2 = input2.toCharArray();
            for (int i = 0; i < a1.length; i++) {
                if (a1[i] != a2[i]) {
                    if (change)
                        return false;
                    else
                        change = true;
                }
            }
            return true;
        }
    }

}
