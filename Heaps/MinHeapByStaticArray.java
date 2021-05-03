package Heaps;

public class MinHeapByStaticArray<T extends Comparable<T>> {

    public T[] arr;
    private int size = 0;
    private int capacity;

    public MinHeapByStaticArray(int capacity){
        this.capacity = capacity;
        arr = (T[]) new Comparable[capacity];
    }

    public MinHeapByStaticArray(){
        this(16);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    private void swap(int index1 , int index2){
        T a = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = a;
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

    public void add(T element){
        arr[size] = element;
        heapify(size++);
    }

    public T poll(){
        T ele = arr[0];
        swap(0 , size-1);
        size = size - 1;
        arr[size] = null;
        bubbleDown(0);
        return ele;
    }

    public T remove(T ele){
        int i=0;
        for( ; i<size ; i++){
            if(arr[i].equals(ele))
                break;
        }
        T elem = arr[i];
        swap(i,size-1);
        --size;

        int parentIndex = i%2==0 ? (i-2)/2 : (i-1)/2;
        if(arr[parentIndex].compareTo(arr[i])>0)
            heapify(i);
        else
            bubbleDown(i);

        return elem;
    }

}
