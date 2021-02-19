package SortingAlgorithms;

import java.util.List;

public interface Sort<T extends Comparable<T>> {
    public T[] getArraySorted(T[] arr);

    public List<T> getListSorted(List<T> list);

    public void applyTheAlgo();
}
