package SortingAlgorithms.HeapSort;

import java.util.Comparator;
import java.util.List;

public interface Sort<T extends Comparable<T>> {
    public abstract T[] createHeapFromArray(T[] array);

    public abstract List<T> createHeapFromList(List<T> list);

    public abstract void heapify(int i, int size);
}
