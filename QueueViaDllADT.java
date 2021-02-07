import java.util.Iterator;

public class QueueViaDllADT<T> implements Iterable<T> {
    private DoublyLinkedListADT<T> queue;

    public QueueViaDllADT() {
        queue = new DoublyLinkedListADT<>();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(T data) {
        queue.addLast(data);
    }

    public T dequeue() {
        return queue.removeFirst();
    }

    public boolean contains(T data) {
        return queue.contains(data);
    }

    public T peek() {
        return queue.peekFirst();
    }

    public T removeAt(int index) {
        return queue.removeAt(index);
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

}
