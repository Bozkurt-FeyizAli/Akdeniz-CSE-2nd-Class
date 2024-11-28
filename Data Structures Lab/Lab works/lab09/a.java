import java.util.LinkedList;
import java.util.Queue;

public class a {
    public static void main(String[] args) {
        //NodeHeap<Integer, String> heap = new NodeHeap<>();
        ArrayHeap<Integer, String> heap = new ArrayHeap<>(500);

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
        ArrayHeap<Integer, String> heap2 = new ArrayHeap<>(500);

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

        /* int[] array = {1, 5, 3, 2, 6, 4};
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        } */
    }

    public static void heapSort(int[] array) {
        /*
         * heap sort implementation
         */
    }

    public static void heapify(int[] array, int n, int parent) {
        /*
         * heapify implementation
         */
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

class Entry <K extends Comparable <? super K>, V> implements Comparable<K> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
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
    T entry;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parrent;

    public TreeNode(T entry) {
        this.entry = entry;
    }

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

    public Entry<K, V>[] getHeap() {
        // Convenience method
        return heap;
    }

    /*
     * Constructor(int capacity)
     */

    /*
     * heapifyUp(index)
     */

     /*
      * heapifyDown(index)
      */

    /* merge two given heaps
     * static <K extends Comparable<? super K>, V> ArrayHeap<K, V> merge(ArrayHeap<K, V> heap1, ArrayHeap<K, V> heap2)
     */

    private void swap(int index, int otherIndex) {
        Entry<K, V> temp = heap[index];
        heap[index] = heap[otherIndex];
        heap[otherIndex] = temp;
    }

    /*
    * prints the heap BFS
     * levelorder()
     */
}

/*
 * Node-based Min-heapimplementation
 */
class NodeHeap <K extends Comparable<? super K>, V> implements PriorityQueue <K, V> {
    int size;
    TreeNode<Entry<K, V>> root;
    public TreeNode<Entry<K, V>> getRoot() {
        // Convenience method
        return root;
    }

    public NodeHeap(){
        root=null;
        size=0;
    }

    /*
     * Constructor()
     */

     /*
      * heapifyUp(node)
      */
    public void heapifyUp(TreeNode<Entry<K, V>> node){
        while(node.parrent!=null){
            //TreeNode<Entry<K, V>> small;
            if(node.entry.getKey().compareTo(node.parrent.entry.getKey())<0)
                swap(node, node.parrent);
            node=node.parrent;
        }
    }


    /*
     * heapifyDown(node)
     */
    public void heapifyDown(TreeNode<Entry<K, V>> node){
        while(node.left!=null||node.right!=null){
            TreeNode<Entry<K, V>> small=findLess(node);
            if(small==null)
                break;
            swap(node, small);
            node=small;
        }
    }
    public TreeNode<Entry<K, V>> findLess(TreeNode<Entry<K, V>> node){
        if(node==null||(node.left==null&&node.right==null))
            return null;
        if(node.left==null)
            return node.right;
        else if(node.right==null)
            return node.left;
        else{
            if(node.right.entry.getKey().compareTo(node.left.entry.getKey())<0)
                return node.right;
            else return node.left;
        }
    }
    

     /* finds the location of last node to remove
      * node findLastNode()
      */
    
      /* finds the first parrent with available location for insertion
       * node findParrent()
       */
    public TreeNode<Entry<K, V>> findParrent(TreeNode<Entry<K, V>> root){
        if(root==null)
            return null;
        Queue<TreeNode<Entry<K, V>>> qe= new LinkedList<>();
        qe.add(root);
        while (!qe.isEmpty()) {
            TreeNode<Entry<K, V>> node=qe.poll();
            if(node.left==null||node.right==null)
                return node;
            qe.add(node.left);
            qe.add(node.right);
        }
        return null;
    }



    private void swap(TreeNode<Entry<K, V>> node, TreeNode<Entry<K, V>> otherNode) {
        Entry<K, V> tempEntry = node.entry;
        node.entry = otherNode.entry;
        otherNode.entry = tempEntry;
    }

    private boolean deleteLastNode(TreeNode<Entry<K, V>> root, TreeNode<Entry<K, V>> target){
        if(root==null)
        return false;
        if(root.left==target){
            root.left=null;
            return true;}
        if(root.right==target){
            root.right=null;
            return true;
        }
            if(!(deleteLastNode(root.left, target)))
            return deleteLastNode(root.right, target);
            return true;
        
        
    }

    public TreeNode<Entry<K, V>> lastNode(TreeNode<Entry<K, V>> root){
        if(root==null)
            return null;
            int last=0;
            Queue<TreeNode<Entry<K, V>>> queue= new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                if(last+1==size)
                    break;
                    TreeNode<Entry<K, V>> node=queue.poll();
                if(node.left!=null)
                    queue.add(node);
                if(node.right!=null)
                    queue.add(node.right);
                    last++;
            }

            return queue.poll();

    }
