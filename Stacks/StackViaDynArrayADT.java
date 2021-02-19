package Stacks;

import Arrays.DynamicArrayADT;

import java.util.Iterator;

public class StackViaDynArrayADT<T> implements Iterable<T> {
    private DynamicArrayADT<T> stack;

    public StackViaDynArrayADT() {
        stack = new DynamicArrayADT<>(10);
    }

    public StackViaDynArrayADT(T data) {
        stack = new DynamicArrayADT<>();
        push(data);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public void push(T data) {
        stack.add(data);
    }

    public T pull() {
        return stack.removeAt(size() - 1);
    }

    public T peek() {
        return stack.get(size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
