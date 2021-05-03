package PriorityQueues;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("unchecked")
public class PriorityQueueByBinaryHeap<T extends Comparable<T>> {
    public T[] arr;
    private int levelsHeap = 0;
    private int size = 0;
    private int capacity = 1;
    private HashMap<T , TreeSet<Integer>> lookUpMap;

    public PriorityQueueByBinaryHeap(int levelsHeap){
        this.levelsHeap = levelsHeap-1;
        this.capacity = (int)Math.pow(2,this.levelsHeap)-1;
        this.arr = (T[]) new Comparable[capacity];
        lookUpMap = new HashMap<>();
    }

    public PriorityQueueByBinaryHeap(){
        this(3);
    }

    private void swap(int index1 , int index2){
        T a = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = a;

        TreeSet<Integer> index1Set = lookUpMap.get(arr[index1]);
        TreeSet<Integer> index2Set = lookUpMap.get(arr[index1]);

        index1Set.remove(index1);
        index1Set.add(index2);

        index2Set.remove(index2);
        index2Set.add(index1);
    }

    private void heapify(int index){
        if(index>=size)
            throw new IndexOutOfBoundsException("index given is not valid");
        if(index<=0)
            return;

        int i;
        if(index%2==0){
            i = (index - 2) / 2;
        }
        else{
            i = (index - 1) / 2;
        }
        if(arr[i].compareTo(arr[index]) > 0)
            swap(i,index);
        heapify(i);
    }

    public void bubbleDown(int index){
        if(index<0||index>=size)
            throw new IndexOutOfBoundsException("index given is not valid");

        int left = (2*index)+1;
        int right = (2*index)+2;

        if(left>=size) {
            swap(index,right);
            return;
        }
        if(right>=size){
            swap(index,left);
            return;
        }

        if(arr[index].compareTo(arr[left])>0||arr[index].compareTo(arr[right])>0){
            if(arr[left].compareTo(arr[right])==0){
                swap(index,left);
                bubbleDown(left);
            }
            else{
                int n = arr[left].compareTo(arr[right])<0 ? left : right;
                swap(index , n);
                bubbleDown(n);
            }
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(T obj){
        if(size>=capacity){
            this.levelsHeap++;
            this.capacity = (int)Math.pow(2,this.levelsHeap)-1;
            T[] tempArr = (T[]) new Comparable[this.capacity];
            for(int i=0 ; i<size ; i++)
                tempArr[i] = arr[i];

            arr = tempArr;
        }
        arr[size] = obj;
        TreeSet<Integer>  set = lookUpMap.get(obj);
        if(set==null)
            set = new TreeSet<>();
        set.add(size);
        lookUpMap.put(obj,set);

        heapify(size++);
    }

    public T poll(){
        T ele = arr[0];
        swap(0 , size-1);
        size = size - 1;
        arr[size] = null;

        TreeSet<Integer> set1 = lookUpMap.get(arr[size]);
        if(set1==null)
            set1 = new TreeSet<>();
        set1.remove(size);
        lookUpMap.put(arr[size] , set1);

        bubbleDown(0);
        return ele;
    }

    public T remove(T ele){
        TreeSet<Integer> set1 = lookUpMap.get(ele);
        if(set1==null)
            return null;
        int indexOfEle = set1.last();
        swap( indexOfEle , size-1);
        arr[size--] = null;
        set1.remove(size);
        lookUpMap.put(ele , set1);

        int parentIndex = indexOfEle%2==0 ? (indexOfEle-2)/2 : (indexOfEle-1)/2;
        if(arr[parentIndex].compareTo(arr[indexOfEle])>0)
            heapify(indexOfEle);
        else
            bubbleDown(indexOfEle);

        return ele;
    }
}
