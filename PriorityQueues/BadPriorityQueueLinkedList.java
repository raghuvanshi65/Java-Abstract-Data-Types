import java.util.Iterator;

public class BadPriorityQueueLinkedList<T> implements Iterable<T> {

  private int size;
  private Node<T> head;

  public BadPriorityQueueLinkedList() {
    this.size = 0;
    this.head = null;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public void clear() {
    while (head != null) {
      Node<T> temp = head;
      head = head.next;
      temp = null;
    }

    size = 0;
  }

  public void add(T val, int priority) {
    if (priority >= 0 && priority <= 10) {
      if (head == null) head = new Node<>(val, priority, null);
      else {
        Node<T> temp = head;
        while (temp != null) temp = temp.next;

        temp = new Node<>(val, priority, null);
      }
      size++;
    } else {
      throw new RuntimeException("priority must be between 1 to 10 inclusive");
    }
  }

  public void addFirst(T val, int priority) {
    Node<T> temp = new Node<>(val, priority, head);
    head = temp;
    size++;
  }

  private Node<T> remove(Node<T> remove) {
    Node<T> temp = head;
    while (temp != null) {
      if (temp.next == remove) {
        temp.next = remove.next;
      }
      temp = temp.next;
    }
    size--;
    return remove;
  }

  public Node<T> poll() {
    int min = Integer.MAX_VALUE;
    Node<T> temp = head;
    Node<T> remove = null;

    while (temp != null) {
      if (temp.priority < min) remove = temp;

      temp = temp.next;
    }

    return remove(remove);
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      Node<T> traverse = head;

      @Override
      public boolean hasNext() {
        return traverse != null;
      }

      @Override
      public T next() {
        Node<T> temp = traverse;
        traverse = traverse.next;
        return temp.val;
      }
    };
  }

  private class Node<T> {
    public T val;
    public int priority;
    public Node<T> next;

    public Node(T val, int priority, Node<T> next) {
      this.val = val;
      this.priority = priority;
      this.next = next;
    }
  }
}
