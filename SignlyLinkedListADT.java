import java.util.Iterator;

public class SignlyLinkedListADT<T> implements Iterable<T> {

    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return data.toString();
        }
    }

    private int size;
    private Node<T> head = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        Node<T> temp = head;
        while (temp != null) {
            Node<T> t = temp.next;
            temp.data = null;
            temp.next = null;
            temp = t;
        }
        size = 0;
    }

    public void addFirst(T data) {
        if (isEmpty())
            head = new Node<T>(data, null);
        else {
            Node<T> temp = new Node<>(data, head);
            head = temp;
        }
        size++;
    }

    public void addLast(T data) {
        if (isEmpty())
            head = new Node<T>(data, null);
        else {
            Node<T> temp = head;
            while (temp != null)
                temp = temp.next;
            temp = new Node<>(data, null);
        }
        size++;
    }

    public void add(T data) {
        addLast(data);
    }

    public T peekFirst() {
        if (isEmpty())
            throw new RuntimeException("list is empty");
        return head.data;
    }

    public T removeFirst() {
        T data = null;
        if (isEmpty())
            throw new RuntimeException("list is empty");
        else {
            Node<T> temp = head;
            data = temp.data;
            head = head.next;
            temp.data = null;
            temp.next = null;
        }
        size--;
        return data;
    }

    public T removeLast() {
        T data = null;
        if (isEmpty())
            throw new RuntimeException("list is empty");
        else {
            Node<T> temp = head;
            while (temp.next.next != null)
                temp = temp.next;

            Node<T> tail = temp.next;
            temp.next = null;
            data = tail.data;
            tail.data = null;
            tail.next = null;
        }
        size--;
        return data;
    }

    public T remove(T data) {
        Node<T> temp = head.next;
        Node<T> preTemp = head;
        T ret = null;
        while (temp != null) {
            if (temp.data == data) {
                ret = data;
                preTemp.next = temp.next;
                temp.data = null;
                temp.next = null;
            }
            preTemp = preTemp.next;
            temp = temp.next;
        }
        size--;
        return ret;
    }

    public int indexOf(T data) {
        Node<T> temp = head;
        int index = -1;
        int i = 0;

        while (temp != null) {
            if (temp.data == data)
                index = i;

            temp = temp.next;
            i++;
        }

        return index;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> temp = head;

            @Override
            public boolean hasNext() {
                return temp!= null;
            }

            @Override
            public T next() {
                T data = temp.data;
                temp = temp.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> temp = head;
        if (isEmpty())
            sb.append("]");
        else {
            while(temp.next!=null){
                sb.append(temp.data.toString()+" ,");
                temp = temp.next;
            }
            sb.append(temp.data+" ]");
        }
        return sb.toString();
    }

}
