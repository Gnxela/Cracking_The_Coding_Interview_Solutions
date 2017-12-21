package me.alexng.crackingTheCodeInterview;

public class q1_7 {

    public static void main(String[] args) {
        int[][] column = new int[5][5];//Can be any size matrix and if needed could add a third dimension to represent the 4 colors. Wasn't really needed though
        column[0][0] = 5;
        column[1][1] = 4;
        column[4][4] = 3;
        for (int i = 0; i < column.length; i++) {
            for (int j = 0; j < column.length; j++) {
                System.out.print(column[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---");
        column = rotate(column);
        for (int i = 0; i < column.length; i++) {
            for (int j = 0; j < column.length; j++) {
                System.out.print(column[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotate(int[][] input) {
        int[][] output = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                output[input.length - 1 - j][i] = input[i][j];
            }
        }
        return output;
    }

}
