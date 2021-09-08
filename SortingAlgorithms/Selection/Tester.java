package SortingAlgorithms.Selection;

import SortingAlgorithms.Sort;

import java.util.Arrays;

public class Tester {
  public static void main(String[] args) {
    Sort<Integer> sorter = new SelectionSort<>();
    Integer[] arr = new Integer[] {2, 7, 4, 1, 5, 3};
    sorter.getArraySorted(arr);
    System.out.println(Arrays.toString(arr));
  }
}
