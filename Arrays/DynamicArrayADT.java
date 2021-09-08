package Arrays;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArrayADT<T> implements Iterable<T> {

  private T globalArray[];
  private int length = 0;
  private int capacity = 0;

  public DynamicArrayADT() {
    this(12);
  }

  public DynamicArrayADT(int initialCapacity) {
    if (initialCapacity >= 0) {
      this.capacity = initialCapacity;
      globalArray = (T[]) new Object[capacity];
    } else {
      throw new IllegalArgumentException("Capacity cannot be negative");
    }
  }

  public int size() {
    return length;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public T get(int index) {
    if (index < length) return globalArray[index];
    throw new IllegalArgumentException("index do not exist !!");
  }

  public void clear() {
    for (int i = 0; i < length; i++) globalArray[i] = null;

    length = 0;
  }

  public void set(int index, T element) {
    if (index < length) globalArray[index] = element;
    else throw new IllegalArgumentException("index is out of bounds !");
  }

  public void add(T element) {
    if (length < capacity) {
      globalArray[length] = element;
      length++;
    } else {
      T[] tempArray = (T[]) new Object[capacity * 2];
      for (int i = 0; i < length; i++) tempArray[i] = globalArray[i];

      tempArray[length++] = element;
      globalArray = tempArray;
      capacity = capacity * 2;
    }
  }

  public T removeAt(int index) {
    if (index < length && index >= 0) {
      T object = globalArray[index];

      for (int i = index; i < length - 1; i++) globalArray[index] = globalArray[index + 1];
      globalArray[--length] = null;

      return object;
    } else throw new IllegalArgumentException("index is invalid");
  }

  public boolean remove(T object) {
    for (int i = 0; i < length; i++) {
      if (globalArray[i].equals(object)) {
        removeAt(i);
        return true;
      }
    }
    return false;
  }

  public int indexOf(T object) {
    for (int i = 0; i < length; i++) {
      if (globalArray[i].equals(object)) return i;
    }
    return -1;
  }

  public boolean contains(T obj) {
    return indexOf(obj) == -1;
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
        return globalArray[index++];
      }
    };
  }

  @Override
  public String toString() {
    StringBuilder tempString = new StringBuilder("[");
    if (length > 0) {
      for (int i = 0; i < length - 1; i++) tempString.append(globalArray[i].toString() + ", ");

      tempString.append(globalArray[length - 1].toString());
    }

    tempString.append("]");
    return tempString.toString();
  }
}
