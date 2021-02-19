package Stacks;

import LinkedList.DoublyLinkedListADT;

import java.util.Iterator;

public class StackViaDllADT<T> implements Iterable<T> {

    private DoublyLinkedListADT<T> stack;

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public StackViaDllADT() {
        stack = new DoublyLinkedListADT<>();
    }

    public StackViaDllADT(T data) {
        stack = new DoublyLinkedListADT<>();
        push(data);
    }

    public void push(T data) {
        stack.addLast(data);
    }

    public T pull() {
        return stack.removeLast();
    }

    public T peek() {
        return stack.peekLast();
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
