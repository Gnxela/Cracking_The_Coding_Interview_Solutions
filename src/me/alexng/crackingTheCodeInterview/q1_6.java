package me.alexng.crackingTheCodeInterview;

public class q1_6 {

    public static void main(String[] args) {
        String input1 = "aaabbbbbbbbc";
        System.out.println(compress(input1));
    }

    private static String compress(String input1) {
        StringBuilder compressed = new StringBuilder();
        char[] array = input1.toCharArray();
        char current = array[0];//Making the assumption that we don't have a null string...
        int count = 0;
        for (char c : array) {
            if (c == current) {
                count++;
            } else {
                compressed.append(current + count);
                count = 1;
                current = c;
            }
        }
        compressed.append(current + count);//don't leave out the last character(s)
        return input1.length() > compressed.length() ? compressed.toString() : input1;
    }

}
