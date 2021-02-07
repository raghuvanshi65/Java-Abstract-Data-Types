import java.util.Iterator;

// @SuppressWarnings("unchecked")
public class DoublyLinkedListADT<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;

    private class Node<T> {
        T data;
        Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        
        public String toString() {
            return data.toString();
        }
    }

    public void clear() {
        Node<T> temp = head;
        while (temp != null) {
            Node<T> next = temp.next;
            temp.next = temp.prev = null;
            temp.data = null;
            temp = next;
        }
        head = tail = temp = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(T data) {
        addLast(data);
    }

    public void addFirst(T data) {
        if (!isEmpty()) {
            head.prev = new Node<>(data, null, head);
            head = head.prev;
        } else
            head = tail = new Node<>(data, null, null);

        size++;
    }

    public void addLast(T data) {
        if (isEmpty())
            head = tail = new Node<>(data, null, null);
        else {
            tail.next = new Node<>(data, tail, null);
            tail = tail.next;
        }
        size++;
    }

    public T peekFirst() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("list is empty");
        return head.data;
    }

    public T peekLast() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("list is empty");
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty())
            throw new RuntimeException("List is empty");

        Node<T> tempNode = head;
        T data = tempNode.data;
        head = head.next;
        tempNode = null;
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("List is empty");

        Node<T> tempNode = tail;
        T data = tempNode.data;
        tail = tail.prev;
        tempNode = null;
        size--;
        return data;
    }

    private T remove(Node<T> node) {
        if (node.next == null)
            return removeLast();
        if (node.prev == null)
            return removeFirst();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        node.data = null;
        node.prev = node.next = null;

        T data = node.data;
        size--;
        return data;
    }

    public T removeAt(int index) {
        Node<T> temp;

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index is out of bounds");
        else if (index == 0)
            return removeFirst();
        else if (index == size() - 1)
            return removeLast();
        else {
            if (index < size / 2) {
                int i = 0;
                temp = head;
                while (i < index) {
                    temp = temp.next;
                    i++;
                }
            } else {
                int i = size() - 1;
                temp = tail;
                while (i > index) {
                    temp = temp.prev;
                    i--;
                }
            }
        }
        return remove(temp);
    }

    public boolean remove(T obj) {
        Node<T> temp = head;
        for (temp = head; temp != null; temp = temp.next) {
            if (temp.data.equals(obj)) {
                remove(temp);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T data) {
        int index = 0;
        Node<T> temp = head;
        if (isEmpty())
            return -1;
        else {
            if (tail.data == data)
                return size() - 1;
            else {
                for (index = 0; index < size(); index++) {
                    if (temp.data.equals(data))
                        return index;

                    temp = temp.next;
                }
                return -1;
            }
        }
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
                return temp != null;
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
        StringBuilder tempString  = new StringBuilder("[");
        if(isEmpty())
        tempString.append("]");
        else
        {
            Node<T> tempNode = head;
            while(tempNode.next!=null)
            {
                tempString.append(tempNode.data+" ,");
                tempNode = tempNode.next;
            }
            tempString.append(tail.data+" ]");
        }
        return tempString.toString();
    }

}
