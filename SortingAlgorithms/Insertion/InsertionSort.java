package SortingAlgorithms.Insertion;

import SortingAlgorithms.Sort;

import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
  private T arr[] = null;
  private List<T> list = null;

  public InsertionSort() {}

  @Override
  public T[] getArraySorted(T[] arr) {
    this.arr = arr;
    applyTheAlgo();
    return arr;
  }

  @Override
  public List<T> getListSorted(List<T> list) {
    this.list = list;
    applyTheAlgo();
    return list;
  }

  @Override
  public void applyTheAlgo() {
    if (arr != null) {
      T max = arr[0];
      for (int i = 0; i < arr.length; i++) {
        int k = i;
        for (int j = i - 1; j >= 0; j--) {
          if (arr[j].compareTo(arr[k]) > 0) {
            T temp = arr[k];
            arr[k] = arr[j];
            arr[j] = temp;
            k--;
          }
        }
      }
    } else {
      T max = list.get(0);
      for (int i = 0; i < list.size(); i++) {
        int k = i;
        for (int j = i - 1; j >= 0; j--) {
          if (list.get(j).compareTo(list.get(k)) > 0) {
            T temp = list.get(k);
            list.set(k, list.get(j));
            list.set(j, temp);
            k--;
          }
        }
      }
    }
  }
}
