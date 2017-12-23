package me.alexng.crackingTheCodeInterview;

public class q3_1 {

    /**
     * Imagine building a single stack into an array. [T, T, null, null, null, null]
     * Loop through, find the first position that is null and override it.
     * To pop an element, loop through find the first null and remove the element before that.
     * Only problems being you can't store null as a value (not a huge problem) and that the stack is limited in size to the size of the array
     * Now to fit three stacks into a single array you could segment the array. Assign the first x elements to the first stack, y elements to the second stack and z elements to the third stack.
     */

    //Stack one: [0, 1/3]
    //Stack two: [1/3, 2/3]
    //Stack three: [2/3, n]
    public static void main(String[] args) {
        ArrayStackTriplet ast = new ArrayStackTriplet(0, 10, 20, 30);
        ast.push(1, 0);
        ast.push(1, 0);
        ast.push(1, 0);
        ast.push(1, 0);
        ast.push(1, 0);
        ast.push(1, 0);
        ast.push(1, 0);
        ast.push(1, 0);
        ast.push(1, 0);
        ast.push(8, 0);
        ast.push(2, 1);
        ast.push(3, 2);

        for (int i = 0; i < ast.array.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(ast.array[i] + "|");
        }

        System.out.println("\n");
        System.out.println(ast.pop(1));
        System.out.println(ast.isEmpty(1));
        for (int i = 0; i < ast.array.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(ast.array[i] + "|");
        }
    }

    /**
     * All refrences to stack as a parameter:
     * 0 = stack 1
     * 1 = stack 2
     * 2 = stack 3
     */
    static class ArrayStackTriplet {

        int[] array;
        int[] size = new int[3];
        int[] segments = new int[3];

        public ArrayStackTriplet(int s1, int s2, int s3, int n) {
            array = new int[n];
            segments[0] = s1;
            segments[1] = s2;
            segments[2] = s3;
        }

        public void push(int data, int stack) {
            if (isFull(stack)) throw new ArrayIndexOutOfBoundsException();//No room in stack
            int start = segments[stack];
            array[start + size[stack]] = data;
            size[stack]++;
        }

        public int pop(int stack) {
            int start = segments[stack];
            size[stack]--;
            int data = array[start + size[stack]];
            array[start + size[stack]] = 0;
            return data;

        }

        public int peek(int stack) {
            int start = segments[stack];
            size[stack]--;
            int data = array[start + size[stack]];
            size[stack]++;
            return data;

        }

        public boolean isFull(int stack) {
            int start = segments[stack], end;
            if (stack == 2)
                end = array.length;
            else
                end = segments[stack + 1];
            return size[stack] == end - start;
        }

        public boolean isEmpty(int stack) {
            return size[stack] == 0;
        }

    }

}



