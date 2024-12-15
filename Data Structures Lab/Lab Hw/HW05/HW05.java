import java.util.Arrays;
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

private static void printArray(int[] array) {
    for (int num : array) {
        System.out.print(num + " ");
    }
    System.out.println();
}




    public static void heapSort(int[] array) {
        /*
         * heap sort implementation
         */
        int n = array.length;
    for(int i = n / 2 - 1; i >= 0; i--) {
        heapify(array, n, i);
    }
    for(int i = n - 1; i > 0; i--) {
        swap(array, 0, i);
        heapify(array, i, 0);
    }
    }

    public static void heapify(int[] array, int n, int i) {
        /*
         * heapify implementation (required for heapSort)
         * array: whole array
         * n: length of subarray
         * parrent: index of parrent
         */
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
    public static <K extends Comparable<? super K>, V> ArrayHeap<K, V> merge(ArrayHeap<K, V> heap1, ArrayHeap<K, V> heap2){
        ArrayHeap<K, V> mergeHeap= new ArrayHeap<>(heap1.size()+heap2.size());
        for (var en : heap1.getHeap()) {
            if(en!=null)
            mergeHeap.insert(en.getKey(), en.getValue());
        }
        for (var en : heap2.getHeap()) {
            if(en!=null)
            mergeHeap.insert(en.getKey(), en.getValue());
        }
        return mergeHeap;
    }
    private void swap(int index, int otherIndex) {
        Entry<K, V> temp = heap[index];
        heap[index] = heap[otherIndex];
        heap[otherIndex] = temp;
    }

    /*
    * prints the heap BFS
     * levelorder()
     */
    public void levelorder(){
        for (Entry<K,V> entry : heap) {
            if(entry!=null)
            System.out.println(entry.getValue());
            else System.out.println("null");
        }
    }

     public int indexRight(int i){ return (2*i+2<heap.length)? 2*i+2: -1;}
    public int indexLeft(int i){ return (2*i+1<heap.length)? 2*i+1: -1;}
    public int indexParent(int i){
        if(i==0)
            return -1;
        else
        return ((i-1)/2<size&&(i-1)/2>-1)? (i-1)/2: -1;}
    public boolean hasRight(int i){return indexRight(i)>=0&&indexRight(i)<size;}
    public boolean hasLeft(int i){return indexLeft(i)>=0&&indexLeft(i)<size;}
    public boolean hasParent(int i){return indexParent(i)>=0&&indexParent(i)<size;}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public V remove() {
        if(isEmpty())
            return null;
        V rem=heap[0].getValue();
        swap(0, --size);
        heap[size]=null;
        if (size > 0) {
            heapifyDown(0);
        }
        return rem;
    }

    @Override
    public V peek() {
        if(heap[0]==null)
            return null;
        return heap[0].getValue();
    }

    @Override
    public void insert(K priority, V element) {
        ensureCapacity();
        heap[size++]=new Entry<K, V>(priority, element);
        heapifyUp(size-1);
    }
    private void ensureCapacity() {
        if (size >= heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }
    public void recInsert(Entry<K, V> en, int i){
        if(heap[i]==null){
            heap[i]=en;
            return;
        }
        if(!hasLeft(i)){
            recInsert(en, indexLeft(i));
        }
        else if(!hasRight(i))
            recInsert(en, indexRight(i));
    }
}