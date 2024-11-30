import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lab09 {
    public static void main(String[] args) {
        //NodeHeap<Integer, String> heap = new NodeHeap<>();
        //ArrayHeap<Integer, String> heap = new ArrayHeap<>(500);
        NodeHeap<Integer, String> heap= new NodeHeap<>();
        // Inserting elements into the heap
        heap.insert(10, "Ten");
        heap.insert(20, "Twenty");
        heap.insert(5, "Five");
        heap.insert(30, "Thirty");
        heap.insert(15, "Fifteen");
        heap.insert(25, "Twenty-Five");
        heap.insert(1, "One");
        heap.remove();

        // Display the heap (level-order)
        System.out.println("Heap after insertions (level-order):");
        heap.levelorder();

        NodeHeap<Integer, String> heap2 = new NodeHeap<>();
        //ArrayHeap<Integer, String> heap2 = new ArrayHeap<>(500);

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
        NodeHeap<Integer, String> heap3 = NodeHeap.merge(heap, heap2, 1, "12");
        heap3.levelorder();
        //((ArrayHeap<Integer, String>) heap3).levelorder();
        //System.out.println(heap3.().entry.getValue());

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
/*
 * Node-based Min-heapimplementation
 */
class NodeHeap <K extends Comparable<? super K>, V> implements PriorityQueue <K, V> {
    private TreeNode<Entry<K, V>> root;
    private int size;
    public TreeNode<Entry<K, V>> getRoot() {
        // Convenience method
        return root;
    }

    /*
     * Constructor()
     */
    public NodeHeap(){
        root=null;
        size=0;
    }

     /*
      * heapifyUp(node)
      */

      public void heapifyUp(TreeNode<Entry<K, V>> node){
        while(node.parrent!=null&&node.entry.getKey().compareTo(node.parrent.entry.getKey())<0){
            swap(node, node.parrent);
            node=node.parrent;
        }
    }


    /*
     * heapifyDown(node)
     */
    public void heapifyDown(TreeNode<Entry<K, V>> node){
        while(node != null){
            TreeNode<Entry<K, V>> schild = node;
            if(node.left != null && node.left.entry.getKey().
                 compareTo(schild.entry.getKey()) < 0){
                schild=node.left;
            }
            if(node.right!= null && node.right.entry.getKey().
                compareTo(schild.entry.getKey()) < 0){
                schild = node.right;
            }
            if(schild== node){
                break;
            }
            swap(node, schild);
            node = schild;
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
                    if(node.left != null)
                    queue.add(node.left);
                    if(node.right != null)
                    queue.add(node.right);
                
                    last++;
            }

            return queue.poll();

    }

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
        // TODO Auto-generated method stub
        if (root == null) {
            return null;
        }
        Entry<K, V> removedEntry = root.entry;

        if (size == 1) {
            root = null;
        } else {
            TreeNode<Entry<K, V>> lastNode = findLastNode();
            swap(root, lastNode);
            if (lastNode.parrent != null) {
                if (lastNode.parrent.left == lastNode) {
                    lastNode.parrent.left = null;
                } else {
                    lastNode.parrent.right = null;
                }
            }
            heapifyDown(root);
        }
        size--;
        return removedEntry.getValue();
    }
    private TreeNode<Entry<K,V>> findLastNode(){
        Queue<TreeNode<Entry<K,V>>> queue=new LinkedList<>();
        queue.add(root);
        TreeNode<Entry<K,V>> lasNode=null;

        while(!queue.isEmpty()){
            lasNode=queue.poll();
            if(lasNode.left!=null){
                queue.add(lasNode.left);
            }
            if(lasNode.right!=null){
                queue.add(lasNode.right);
            }            
        }
        return lasNode;
    }

    @Override
    public V peek() {
        if(root==null)
            return null;
        else
            return root.entry.getValue();
    }

    @Override
    public void insert(K priority, V element) {
        TreeNode<Entry<K, V>> child=new TreeNode<>(new Entry<>(priority, element));
        if(root==null){
            root= child;
            size++;
            return;
        }
        else{
            TreeNode<Entry<K, V>> parent=findParrent(root);
            if(parent.left==null){
                parent.left=child;
            }
            else if(parent.right==null){
                parent.right=child;
            }
            child.parrent=parent;
            heapifyUp(child);
        }
        size++;
    }

    /*  merges 2 heaps with given new entry
     * static <K extends Comparable<? super K>, V> NodeHeap<K, V> merge(NodeHeap<K, V> heap1, NodeHeap<K, V> heap2, K priority, V value)
     */
    public static <K extends Comparable<? super K>, V> NodeHeap<K, V> merge(NodeHeap<K, V> heap1, NodeHeap<K, V> heap2, K priority, V value){
        NodeHeap<K, V> newHeap=new NodeHeap<>();
        TreeNode<Entry<K, V>> newRoot=new TreeNode<>(new Entry<>(priority, value));
        newRoot.left=heap1.root;
        newRoot.right=heap2.root;
        heap1.root.parrent=newRoot;
        heap2.root.parrent=newRoot;
        newHeap.root=newRoot;
        newHeap.heapifyDown(newHeap.root);
        newHeap.size=heap1.size+heap2.size+1;
        return newHeap;
    }
    public void levelorder(){
    if(root!=null){
        Queue<TreeNode<Entry<K, V>>> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode<Entry<K, V>> t=queue.poll();
            System.out.println(t.entry.getKey());
            if(t.left != null)
            queue.add(t.left);
            if(t.right != null)
            queue.add(t.right);


    }
}
    }

    /* prints the heap BFS
     * levelorder()
     */

}


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

