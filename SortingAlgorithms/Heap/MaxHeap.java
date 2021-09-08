package SortingAlgorithms.Heap;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class MaxHeap<T extends Comparable<T>> implements Sort<T> {

  private T[] mainArray;

  public MaxHeap() {
    mainArray = (T[]) new Comparable[0];
  }

  @Override
  public T[] createHeapFromArray(T[] array) {
    mainArray = (T[]) new Comparable[array.length];
    int n = array.length;

    for (int i = 0; i < n; i++) mainArray[i] = array[i];

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(i, n);
    }

    T[] sortedArray = (T[]) new Comparable[array.length];
    int j = 0;
    for (int i = n - 1; i >= 0; i--) {
      T temp = mainArray[0];
      mainArray[0] = mainArray[n - 1];
      mainArray[n - 1] = temp;
      sortedArray[j] = temp;

      n--;
      heapify(0, n);
      j++;
    }

    return sortedArray;
  }

  @Override
  public List<T> createHeapFromList(List<T> list) {
    mainArray = (T[]) new Comparable[list.size()];
    for (int i = 0; i < list.size(); i++) mainArray[i] = list.get(i);
    mainArray = createHeapFromArray(mainArray);
    List<T> sortedList = new ArrayList<>();
    for (T ele : mainArray) sortedList.add(ele);

    return sortedList;
  }

  @Override
  public void heapify(int i, int size) {

    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < size && mainArray[left].compareTo(mainArray[largest]) < 0) largest = left;

    if (right < size && mainArray[right].compareTo(mainArray[largest]) < 0) largest = right;

    if (largest != i) {
      T temp = mainArray[largest];
      mainArray[largest] = mainArray[i];
      mainArray[i] = temp;

      heapify(largest, size);
    }
  }
}
