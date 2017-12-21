package me.alexng.crackingTheCodeInterview;

public class q1_1 {

    public static void main(String[] args) {
        String s = "test";
        boolean[] array = new boolean[256];
        for (char c : s.toCharArray()) {
            if (!array[c]) {
                array[c + 128] = true;//min value of -128, max value of 127. 256 total values
            } else {
                System.out.println("Not unique");
            }
        }
    }
}
