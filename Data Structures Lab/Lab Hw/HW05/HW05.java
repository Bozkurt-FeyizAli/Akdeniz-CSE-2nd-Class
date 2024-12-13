import java.util.LinkedList;
import java.util.*;

/*
 * There might be some chanes required in the main method to test
 */

public class HW05 {
    public static void main(String[] args) {
        //NodeHeap<Integer, String> heap = new NodeHeap<>();
        ArrayHeap<Integer, String> heap = new ArrayHeap<>(20);

        // Inserting elements into the heap
        heap.insert(10, "Ten");
        heap.insert(20, "Twenty");
        heap.insert(5, "Five");
        heap.insert(30, "Thirty");
        heap.insert(15, "Fifteen");
        heap.insert(25, "Twenty-Five");
        heap.insert(1, "One");

        // Display the heap (level-order)
        System.out.println("Heap after insertions (level-order):");
        heap.levelorder();

        //NodeHeap<Integer, String> heap2 = new NodeHeap<>();
        ArrayHeap<Integer, String> heap2 = new ArrayHeap<>(20);

        heap2.insert(8, "Ten");
        heap2.insert(23, "Twenty");
        heap2.insert(3, "Five");
        heap2.insert(27, "Thirty");
        heap2.insert(16, "Fifteen");
        heap2.insert(22, "Twenty-Five");
        heap2.insert(2, "One");

                // Display the heap (level-order)
        System.out.println("\nHeap after insertions (level-order):");
        heap2.levelorder();

        System.out.println("\nHeap after merge (level-order):");
        //var heap3 = NodeHeap.merge(heap, heap2, 6, "Six");
        var heap3 = ArrayHeap.merge(heap, heap2);
        heap3.levelorder();
        //System.out.println(heap3.getRoot().entry.getValue());

         int[] array = {1, 5, 3, 2, 6, 4};
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        } 
    }

    public static void heapSort(int[] array) {
        /*
         * heap sort implementation
         */
        heapify(array, array.length, 0);
    }

    public static void heapify(int[] array, int n, int parent) {
        /*
         * heapify implementation (required for heapSort)
         * array: whole array
         * n: length of subarray
         * parrent: index of parrent
         */
        ArrayHeap<Integer, Integer> heap= new ArrayHeap(n-parent+1);
        for (int i = parent; i < n; i++) {
            heap.insert(array[i], array[i]);
        }
        for (int i = parent; i < n; i++) {
            array[i]=heap.remove();
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

class Entry <K extends Comparable <? super K>, V> implements Comparable<K> {
/*
 * Constructor(K, V)
 * getValue()
 * getKey()
 */
K key;
V value;
public Entry(K k, V v){
    key=k;
    value=v;
}

public K getKey() {
    return key;
}
public V getValue() {
    return value;
}


    @Override
    public int compareTo(K o) {
        return key.compareTo(o);
    }
} 

class TreeNode <T> {
    /*
     * Constructor(T entry)
     * entry, left, right
     */

}

interface List <T> {
    int size();
    boolean isEmpty();
}

interface PriorityQueue <P, E> extends List <E> {
    E remove();
    E peek();
    void insert(P priority, E element);
}

/*
 * Array-based Min-heap implementation
 */
class ArrayHeap <K extends Comparable<? super K>, V> implements PriorityQueue <K, V> {
    private Entry<K, V>[] heap;
    private int size;

    public ArrayHeap(int c){
        size=0;
        heap= new Entry[c];
    }

    public Entry<K, V>[] getHeap() {
        // Convenience method
        return heap;
    }

    /*
     * Constructor(int capacity)
     */

    /*
     * heapifyUp(index)
     * 
     */
    public void heapifyUp(int index){
        while(index>0&&heap[index]!=null){
            if(hasParent(index)){
                if(heap[index].getKey().compareTo(heap[indexParent(index)].getKey())<0)
                    swap(index, indexParent(index));
            }
            index=indexParent(index);
        }
    }

     /*
      * heapifyDown(index)
      */

    public void heapifyDown(int index){
        while (hasLeft(index)) {
            int iSmall=indexLeft(index);
            if (hasRight(index) && heap[indexRight(index)].getKey().compareTo(heap[iSmall].getKey()) < 0) {
                iSmall = indexRight(index);
            }
            if (heap[index].getKey().compareTo(heap[iSmall].getKey()) <= 0) {
                break; 
            }
            swap(index, iSmall);
            index = iSmall;
        }
    }

    /* merge two given heaps
     * static <K extends Comparable<? super K>, V> ArrayHeap<K, V> merge(ArrayHeap<K, V> heap1, ArrayHeap<K, V> heap2)
     */

    private void swap(int index, int otherIndex) {
        Entry<K, V> temp = heap[index];
        heap[index] = heap[otherIndex];
        heap[otherIndex] = temp;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public V remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    @Override
    public void insert(K priority, V element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    /*
    * adds elements to a list in BFS fashion
     * levelorder(List<V> list)
     */
}