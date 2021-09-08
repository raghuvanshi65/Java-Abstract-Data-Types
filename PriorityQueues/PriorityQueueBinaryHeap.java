package PriorityQueues;

import java.util.*;

public class PriorityQueueBinaryHeap<T extends Comparable<T>> {
  private int heapSize = 0;
  private int heapCapacity = 0;
  private List<T> heap = null;
  private Map<T, TreeSet<Integer>> map = new HashMap<>();

  public PriorityQueueBinaryHeap() {
    this(1);
  }

  public PriorityQueueBinaryHeap(int size) {
    heap = new ArrayList<>(size);
    heapCapacity = size;
  }

  public void PriorityQueueBinaryHeap(T[] elem) {

    heapCapacity = heapSize = elem.length;
    heap = new ArrayList<>(elem.length);

    for (int i = 0; i < heapSize; i++) {
      mapAdd(elem[i], i);
      heap.add(elem[i]);
    }

    for (int i = 0; i < heapSize; i++) heapify(i, heapSize);
  }

  private void heapify(int i, int size) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < size && heap.get(left).compareTo(heap.get(largest)) < 0) largest = left;

    if (right < size && heap.get(right).compareTo(heap.get(largest)) < 0) largest = right;

    if (largest != i) {
      T temp = heap.get(largest);
      heap.set(largest, heap.get(i));
      heap.set(i, temp);

      heapify(largest, size);
    }
  }

  private void mapAdd(T key, int value) {
    if (map.containsKey(key)) map.get(key).add(value);
    else {
      TreeSet<Integer> set1 = new TreeSet<>();
      set1.add(value);
      map.put(key, set1);
    }
  }
}
