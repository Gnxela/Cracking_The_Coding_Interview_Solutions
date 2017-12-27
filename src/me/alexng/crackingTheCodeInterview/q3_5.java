package me.alexng.crackingTheCodeInterview;

import me.alexng.crackingTheCodeInterview.util.Stack;

public class q3_5 {

    public static void main(String[] args) {
        SortedStack stack = new SortedStack(false);
        stack.push(3);
        stack.push(3);
        stack.push(3);
        stack.push(1);
        stack.push(127);
        stack.push(2);
        stack.push(7);
        stack.push(3);
        stack.push(14);
        stack.push(4);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    static class SortedStack {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> stackTemp = new Stack<>();

        private boolean descending;

        public SortedStack(boolean descending) {
            this.descending = descending;
        }

        //Inefficient to basically order the stack every push, but will work for now.
        public void push(Integer data) {
            if (stack.isEmpty()) {
                stack.push(data);
                return;
            }

            boolean flag = true;//If was smaller or was bigger than the previous element. Depending on the ordering
            boolean wasPlaced = false;

            while (!stack.isEmpty()) {
                Integer current = stack.pop();
                if ((!descending ? data.intValue() < current.intValue() : data.intValue() > current.intValue()) && flag && !wasPlaced) {
                    stackTemp.push(data);
                    wasPlaced = true;
                } else if ((!descending ? data.intValue() < current.intValue() : data.intValue() > current.intValue())) {
                    flag = true;
                }
                stackTemp.push(current);
            }

            if (!wasPlaced)
                stackTemp.push(data);

            while (!stackTemp.isEmpty()) {
                stack.push(stackTemp.pop());
            }
        }

        public Integer pop() {
            return stack.pop();
        }

        public Integer peek() {
            return stack.peek();
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }
}



