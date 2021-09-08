package SimpleQueue;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class StaticQueueADT<T> implements Iterable<T> {
  private T[] queue;
  private int length;

  StaticQueueADT() {
    this(10);
  }

  StaticQueueADT(int size) {
    queue = (T[]) new Object[size];
    length = 0;
  }

  public int size() {
    return length;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public void clear() {
    for (int i = 0; i < length; i++) queue[i] = null;

    length = 0;
  }

  public void enqueue(T data) {
    if (length >= queue.length) throw new RuntimeException("Queue is full");
    queue[length] = data;
    length++;
  }

  public T dequeue() {
    if (isEmpty()) throw new RuntimeException("queue is empty");
    for (int i = 0; i < length - 1; i++) queue[i] = queue[i + 1];

    T data = queue[--length];
    queue[length] = null;
    return data;
  }

  public boolean contains(T data) {
    return indexOf(data) != -1;
  }

  public int indexOf(T data) {
    for (int i = 0; i < length; i++) if (queue[i].equals(data)) return i;

    return -1;
  }

  public T peek() {
    return queue[0];
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < length - 1;
      }

      @Override
      public T next() {
        return queue[index++];
      }
    };
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    if (isEmpty()) sb.append("]");
    else {
      for (int i = 0; i < length - 1; i++) sb.append(queue[i] + " ,");

      sb.append(queue[length - 1] + " ]");
    }
    return sb.toString();
  }
}
