package me.alexng.crackingTheCodeInterview;

import java.util.Random;

public class q1_8 {

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];//Can be any size matrix and if needed could add a third dimension to represent the 4 colors. Wasn't really needed though
        Random generator = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = generator.nextInt(10);//Between and including zero and 9
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---");
        matrix = zero(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] zero(int[][] input) {
        int[][] output = new int[input.length][input[0].length];
        //Set everything to 1, so that we can check if a entry has been zero'd
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                output[i][j] = 1;
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i][j] == 0) {
                    for (int k = 0; k < input.length; k++) {
                        output[i][k] = 0;
                        output[k][j] = 0;
                    }
                } else {
                    if (output[i][j] == 1)
                        output[i][j] = input[i][j];
                }
            }
        }
        return output;
    }

}
