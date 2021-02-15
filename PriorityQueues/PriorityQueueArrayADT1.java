import java.util.Iterator;

@SuppressWarnings("unchecked")
public class PriorityQueueArrayADT1<T> implements Iterable<T> {

    private class Element<T> {
        T data;
        int priority;

        public Element(T data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private int length = 0;
    private Element<T> pq[] = null;
    private int maxPriority = 0;

    public PriorityQueueArrayADT1() {
        this(12);
    }

    public PriorityQueueArrayADT1(int capacity) {
        pq = new Element[capacity];
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void insert(T data, int priority) {
        if (length == pq.length)
            throw new ArrayIndexOutOfBoundsException("Queue is full you better poll");

        pq[length++] = new Element<>(data, priority);
        if (priority > maxPriority)
            maxPriority = priority;
    }

    public int getHighestPriority() {
        return maxPriority;
    }

    public T pollMax() {
        T data = null;
        boolean toggler = false;
        for (int i = 0; i < length; i++) {
            if (pq[i].priority == maxPriority && !toggler) {
                toggler = true;
                data = pq[i].data;
            }
            if (toggler && i < length - 1)
                pq[i] = pq[i + 1];
            else if (toggler && i == length - 1)
                pq[i] = null;
        }
        length--;
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return pq[index++].data;
            }
        };
    }
}
