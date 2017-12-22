package me.alexng.crackingTheCodeInterview;

public class q1_9 {

    public static void main(String[] args) {
        String s = "Testing!";
        String rotate = "ing!Test";
        System.out.println(isRotated(s, rotate));
    }

    private static boolean isRotated(String original, String rotated) {
        if (original.length() != rotated.length())
            return false;
        for (int pivot = 0; pivot < original.length() - 1; pivot++) {
            System.out.println(rotated.substring(pivot, rotated.length()) + rotated.substring(0, pivot) + ":" + original);
            if ((rotated.substring(pivot, rotated.length()) + rotated.substring(0, pivot)).equals(original)) {
                return true;
            }
        }
        return false;
    }
}
