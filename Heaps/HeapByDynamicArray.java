import java.util.Comparator;

@SuppressWarnings("unchecked")
public class HeapByDynamicArray<T extends Comparator<T>>{
    private int length;
    private int capacity;
    private T arr[];

    public HeapByDynamicArray(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public HeapByDynamicArray() {
        this(16);
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void insert(T value) {
        if (length < capacity) {
            arr[length] = value;
            length++;
        } else {
            T[] tempArr = (T[]) new Object[capacity * 2];
            for (int i = 0; i < length; i++) {
                tempArr[i] = arr[i];
            }
            arr = tempArr;
            
            capacity *= 2;
            arr[length] = value;
            length++; 
        }
    }

    private T[] swapper(T[] arr , int i , int j)
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }

    private T[] heapify(T arr[])
    {   
        int i = 0 , j = 2*i+1;
        while(j<length-1&&arr[i].compare(arr[i], arr[j])==1)
        {
            swapper(arr, i, j);
            i = j;
            j = 2*i+1;
        }

        int j = 0 , k=2*i+2;

    }

    public T poll()
    {
        if(!isEmpty())
        {   
            swapper(arr, 0 , length-1);
            arr[length-1] = null;
            length--;


            
        }
        throw new RuntimeException("heap is empty");
    }
}
