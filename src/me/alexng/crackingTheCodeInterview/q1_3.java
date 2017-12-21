package me.alexng.crackingTheCodeInterview;

public class q1_3 {

    public static void main(String[] args) {
        String input = "Mr John Smith";
        int spaces = 0;
        for (char c : input.toCharArray()) {//Get the total amount of spaces. In the question is states you are given the true final length but I decided to implement this
            if (c == ' ') {
                spaces++;
            }
        }
        char[] array = new char[input.length() + spaces * 2];
        int index = 0;
        for (char c : input.toCharArray()) {
            if (c == ' ') {
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = c;
            }
        }
        System.out.println(new String(array));
    }

}
