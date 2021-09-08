package SortingAlgorithms.Selection;

import SortingAlgorithms.Sort;

import java.util.List;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {
  private T[] arr;
  private List<T> list;

  public SelectionSort() {}

  @Override
  public T[] getArraySorted(T[] arr) {
    this.arr = arr;
    applyTheAlgo();
    return this.arr;
  }

  @Override
  public List<T> getListSorted(List<T> list) {
    this.list = list;
    applyTheAlgo();
    return this.list;
  }

  private void swap(T[] tempArr, int a, int b) {
    T temp = tempArr[a];
    tempArr[a] = tempArr[b];
    tempArr[b] = temp;
  }

  private void swap(List<T> list, int a, int b) {
    T temp = list.get(a);
    list.set(a, list.get(b));
    list.set(b, temp);
  }

  @Override
  public void applyTheAlgo() {
    if (arr != null) {
      int i = 0, j = 0, k = 0;
      T min = arr[0];
      for (i = 0; i < arr.length; i++) {
        for (j = i; j < arr.length; j++) {
          if (arr[j].compareTo(min) < 0) k = j;
        }
        swap(arr, i, k);
      }
    } else {
      int i = 0, j = 0, k = 0;
      T min = list.get(0);
      for (i = 0; i < list.size(); i++) {
        for (j = i; j < list.size(); j++) {
          if (list.get(j).compareTo(min) < 0) k = j;
        }
        swap(arr, i, k);
      }
    }
  }

  public T[] getArr() {
    return arr;
  }

  public List<T> getList() {
    return list;
  }
}
