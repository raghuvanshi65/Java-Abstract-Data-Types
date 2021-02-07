import java.util.Arrays;
import java.util.Iterator;

public class UsingADTs {
    public static void main(String[] args) {
        // DynamicArrayADT<Integer> dynarray = new DynamicArrayADT<>(10);
        // dynarray.add(1);
        // dynarray.add(2);
        // dynarray.add(4);
        // dynarray.add(3);
        // System.out.println(dynarray.size());
        // dynarray.clear();
        // System.out.println(dynarray.toString());
        // dynarray.add(2);
        // dynarray.add(4);
        // dynarray.add(3);
        // System.out.println(dynarray.toString());
        // System.out.println(dynarray.get(2));
        // dynarray.removeAt(2);
        // System.out.println(dynarray.toString());
        // dynarray.remove(2);
        // dynarray.add(1);
        // dynarray.add(2);
        // dynarray.add(4);
        // dynarray.add(3);
        // System.out.println(dynarray.toString());

        // Integer[] arr = new Integer[4];
        // Iterator<Integer> i = dynarray.iterator();
        // while (i.hasNext())
        //     System.out.println(i.next());

        // DoublyLinkedListADT<Object> adtDll = new DoublyLinkedListADT<>();
        // adtDll.addFirst("raghuvanshi");
        // adtDll.addFirst("anurag");
        // adtDll.add("787878");
        // Iterator<Object> i1 = adtDll.iterator();
        // while (i1.hasNext())
        //     System.out.println(i1.next());

        // System.out.println(adtDll.toString());

        // System.out.println();
        // System.out.println();

        // SignlyLinkedListADT<Object> sll = new SignlyLinkedListADT<>();
        // sll.add(23);
        // sll.add("anurag");
        // sll.add("anurag");
        // sll.add("anurag");
        // sll.addFirst("fthgn,");
        // sll.addFirst("fthgn,   1");
        // sll.addFirst("fthgn,   2");
        // sll.add("anurag raghnk,.");
        // System.out.println(sll.toString());
        // Iterator<Object> i2 = sll.iterator();
        // while (i2.hasNext()) {
        //     System.out.println(i2.next());
        //     System.out.println("id");
        // }
        // System.out.println(sll.size());

        // StackViaDllADT<Object> st = new StackViaDllADT<Object>("anurag");
        // st.push(344);
        // System.out.println(st.toString());
        // System.out.println(st.peek());

        PriorityQueueArrayADT1<Integer> pq1 = new PriorityQueueArrayADT1<>(5);
        pq1.insert(2,2);
        pq1.insert(5,5);
        pq1.insert(92,9);
        pq1.insert(9,9);
        pq1.insert(1,1);
        System.out.println(pq1.pollMax()+" this is returned ");
        Iterator<Integer> i = pq1.iterator();

        while(i.hasNext())
        System.out.println(i.next());

        MinHeapADTArray min = new MinHeapADTArray(8);
        min.insert(2);
        min.insert(3);
        min.insert(1);
        min.insert(5);
        min.insert(4);
        min.insert(6);
        min.insert(9);

        System.out.println(min.toString());
    }
}
