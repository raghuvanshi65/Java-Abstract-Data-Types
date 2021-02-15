import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Trial {

    private class Node<T> implements Comparator<Node> {
        public T val;
        public int priority;

        public Node(T val, int priority) {
            this.val = val;
            this.priority = priority;
        }

        @Override
        public int compare(Node o1, Node o2) {
            int diff = o1.priority - o2.priority;
            if (diff < 0)
                return -1;
            else
                return 1;
        }

    }

    public static Node<Node>[] getSorted(Node<Node>[] arr, int a) {
        PriorityQueue<Node<Integer>> pq = new PriorityQueue<>();
        for (Node<Node> x : arr)
            pq.add(x);

        for (int i = 0; i < arr.length; i++)
            arr[i] = pq.poll();

        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        getSorted(new Node<Node>[] { new Node<Integer>(1, 3), new Node<Integer>(2, 4) }, 2);
        BadPriorityQueueLinkedList<Integer> bdpqll = new BadPriorityQueueLinkedList<>();
        bdpqll.add(2, 4);
        bdpqll.addFirst(5, 3);
        bdpqll.add(8, 2);

        System.out.println(bdpqll.size());
        Iterator<Integer> itr = bdpqll.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
    }
}
