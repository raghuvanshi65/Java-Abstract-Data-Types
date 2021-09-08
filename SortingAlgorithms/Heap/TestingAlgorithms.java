package SortingAlgorithms.Heap;

import SortingAlgorithms.Insertion.InsertionSort;

import java.util.Arrays;
import java.util.List;

public class TestingAlgorithms {
  public static void main(String[] args) throws Exception {
    Sort<Integer> sorter = new MaxHeap<>();

    System.out.println(
        Arrays.toString(sorter.createHeapFromArray(new Integer[] {2, 3, 7, 1, 5, 4, 9, 4})));
    List<Integer> li = Arrays.asList(new Integer[] {5, 4, 3, 2, 1});
    System.out.println(sorter.createHeapFromList(li));

    SortingAlgorithms.Sort<Integer> sortArray = new InsertionSort<>();
    System.out.println(
        Arrays.toString(sortArray.getArraySorted(new Integer[] {2, 3, 7, 1, 5, 4, 9, 4})));
    System.out.println(sortArray.getListSorted(Arrays.asList(new Integer[] {5, 4, 3, 2, 1})));
  }
}
