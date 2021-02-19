package Heaps;

import java.util.Arrays;
import java.util.Spliterator;

public class MinHeapADTArray{

    private Integer[] heapArray;
    private int length = 0;

    public MinHeapADTArray(int capacity) {
        heapArray = new Integer[capacity];
    }

    public MinHeapADTArray() {
        this(12);
    }

    public boolean isEmpty() {
        return length == 0;
    }

    private void swap(int index1 , int index2)
    {
        int temp = heapArray[index1];
        heapArray[index1] = heapArray[index2];
        heapArray[index2] = temp;
    }

    public void insert(Integer data)
    {
        heapArray[length] = data;
        while(data>heapArray[(length-1)/2])
        swap(length,(length-1)/2);

        length++;
    }

    public Integer poll()
    {
        Integer data = heapArray[0];

        for(int i=0 ; i<length-1 ; i++)
        heapArray[i] = heapArray[i+1];
    
        heapArray[--length] = null;     
        return data;
    }

    public String toString()
    {
        return Arrays.toString(heapArray);
    }
}
