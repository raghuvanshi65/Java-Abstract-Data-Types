import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

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

        for(int i=0 ; i<heapSize; i++)
        heapify(heap[i] , heapsize);
    }

    private void headpify(heap[i] , heapsize){
        
    }

    private void mapAdd(T key , int value){
        if(map.containsKey(key))
        map.get(key).add(value);
        else{
            TreeSet<Integer> set1 = new TreeSet<>();
            set1.add(value);
            map.put(key, set1);
        }
    }
}
