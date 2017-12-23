package me.alexng.crackingTheCodeInterview.util;

public class LimitedStack<T> extends Stack<T> {

    public int maxSize;
    private int currentSize = 0;

    public LimitedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void push(T data) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        currentSize++;
        super.push(data);
    }

    @Override
    public T pop() {
        if (!isEmpty())
            currentSize--;
        return super.pop();
    }

    public boolean isFull() {
        return currentSize >= maxSize;
    }

}
