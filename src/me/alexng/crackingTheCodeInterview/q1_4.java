package me.alexng.crackingTheCodeInterview;

public class q1_4 {

    public static void main(String[] args) {
        //Basically for this question we are only asked to CHECK, not compute. To do this we can simply count the frequency of the letters
        String input = "test";
        System.out.println(check(input));
    }

    private static boolean check(String input) {
        int[] frequencies = new int[256];//A char can be between -128 and 127
        for (char c : input.toCharArray()) {
            frequencies[c + 128]++;
        }
        //In a palindrome, you can have one odd frequency, and the rest MUST be even.
        boolean odd = false;
        for (int i : frequencies) {
            if (i % 2 == 1) {
                if (odd)
                    return false;
                else
                    odd = true;
            }
        }
        return true;
    }

}
