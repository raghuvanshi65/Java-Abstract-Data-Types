package Arrays;

import java.util.Iterator;

public class StaticArrayADT<T> implements Iterable<T> {
    private T[] array;
    private int capacity;
    private int size;

    public StaticArrayADT(int capacity){
        this.array = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public StaticArrayADT(){
        this(16);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(T element){
        if(size>=capacity)
            throw new IndexOutOfBoundsException("Array index out of bounds "+(size+1));
        array[size++] = element;
    }

    public T removeAtIndex(int index){
        if(index>=capacity)
            throw new IllegalArgumentException("index is out of static array capacity");
        T element = null;
        for(int i=0 ; i<size ; i++){
            if(i==index)
                element = array[i];
            if(element!=null&&i<size-1)
                array[i] = array[i+1];
        }
        array[--size] = null;
        return element;
    }

    public T remove(){
        if(size==0)
            throw new RuntimeException("Array is already empty");
        T element = array[size-1];
        array[--size] = null;
        return element;
    }

    public T removeElement(T ele){
        if(size==0)
            throw new RuntimeException("Array is already empty");
        boolean isPresent = false;
        for(int i=0 ; i<size ; i++){
            if(array[i]==ele)
                isPresent = true;
            if(isPresent&&i<size-1)
                array[i] = array[i+1];
        }
        array[--size] = null;
        return ele;
    }

    public T update(int index , T ele){
        if(size==0||index>=size)
            throw new IllegalArgumentException("either array is empty or index is out of bounds");
        array[index] = ele;
        return ele;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index<size;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i=0 ; i<size-1 ; i++){
            if(array[i]!=null)
                sb.append(array[i].toString()).append(" ,");
        }
        if(array[size-1]!=null)
            sb.append(array[size - 1]).append(" ]");
        else
            sb.append(" ]");
        return sb.toString();
    }
}
