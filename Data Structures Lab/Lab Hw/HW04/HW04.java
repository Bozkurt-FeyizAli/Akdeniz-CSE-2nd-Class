import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HW04 {
    public static void main(String[] args) {
        System.out.println("Testing SortedPriorityQueue:");
        SortedPriorityQueue<Integer, String> spq = new SortedPriorityQueue<>();
        spq.insert(3, "C");
        spq.insert(1, "A");
        spq.insert(2, "B");

        System.out.println("Peek: " + spq.peek()); // Expected: "A"
        System.out.println("Remove: " + spq.remove()); // Expected: "A"
        System.out.println("Remove: " + spq.remove()); // Expected: "B"
        System.out.println("Remove: " + spq.remove()); // Expected: "C"
        System.out.println("Is Empty: " + spq.isEmpty()); // Expected: true

        // UnsortedPriorityQueue Test
        System.out.println("\nTesting UnsortedPriorityQueue:");
        UnsortedPriorityQueue<Integer, String> upq = new UnsortedPriorityQueue<>();
        upq.insert(3, "C");
        upq.insert(1, "A");
        upq.insert(2, "B");

        System.out.println("Peek: " + upq.peek()); // Expected: "A"
        System.out.println("Remove: " + upq.remove()); // Expected: "A"
        System.out.println("Peek: " + upq.peek()); // Expected: "A"
        System.out.println("Remove: " + upq.remove()); // Expected: "B"
        System.out.println("Remove: " + upq.remove()); // Expected: "C"
        System.out.println("Is Empty: " + upq.isEmpty()); // Expected: true

        // Additional Tests
        System.out.println("\nAdditional Tests:");
        spq.insert(5, "E");
        spq.insert(4, "D");
        System.out.println("Peek after re-insert: " + spq.peek()); // Expected: "D"
        System.out.println("Size: " + spq.size()); // Expected: 2
    
        // BSTArray<Integer> bst = new BSTArray<>(15);

        // // Test 2: Insert elements
        // System.out.println("Test 2: Insert elements");
        // bst.insert(10);
        // bst.insert(5);
        // bst.insert(15);
        // bst.insert(3);
        // bst.insert(7);
        // bst.insert(12);
        // bst.insert(18);

        // // Verify the elements are inserted correctly
        // List<Integer> inorderList = new ArrayList<>();
        // bst.levelorder(inorderList);
        // System.out.println("Inorder Traversal: " + inorderList); // Should be [3, 5, 7, 10, 12, 15, 18]
        
        // // Test 3: Test 'contains' method
        // System.out.println("\nTest 3: Contains method");
        // System.out.println("Contains 7: " + bst.contains(7));  // Expected: true
        // System.out.println("Contains 20: " + bst.contains(20)); // Expected: false
        // bst.remove(10);
        // inorderList.clear();
        // bst.levelorder(inorderList);
        // System.out.println(inorderList);

        // // Test 4: Remove a leaf node
        // // System.out.println("\nTest 4: Remove leaf node (3)");
        // // bst.remove(3);  // Remove leaf node
        // // inorderList.clear();
        // // bst.levelorder(inorderList);
        // // System.out.println("Inorder Traversal after removing 3: " + inorderList); // Expected: [5, 7, 10, 12, 15, 18]

        // // Test 5: Remove a node with one child (15)
        // // System.out.println("\nTest 5: Remove node with one child (15)");
        // // bst.remove(15);  // Remove node with one child (12 should replace 15)
        // // inorderList.clear();
        // // bst.levelorder(inorderList);
        // // System.out.println("Inorder Traversal after removing 15: " + inorderList); // Expected: [5, 7, 10, 12, 18]

        // // Test 6: Remove a node with two children (10)
        // System.out.println("\nTest 6: Remove node with two children (10)");
        // bst.remove(10);  // Remove node with two children (12 should replace 10)
        // inorderList.clear();
        // bst.levelorder(inorderList);
        // System.out.println("Inorder Traversal after removing 10: " + inorderList); // Expected: [5, 7, 12, 18]

        // // Test 7: Remove a node that doesn't exist
        // System.out.println("\nTest 7: Try to remove a node that doesn't exist (20)");
        // boolean result = bst.remove(20);  // This should return false
        // System.out.println("Remove 20 result: " + result); // Expected: false

        // // Test 8: Remove the root node (7)
        // System.out.println("\nTest 8: Remove root node (7)");
        // bst.remove(7);  // Remove root node
        // inorderList.clear();
        // bst.levelorder(inorderList);
        // System.out.println("Inorder Traversal after removing 7: " + inorderList); // Expected: [5, 12, 18]

        // // Test 9: Test if tree is empty after removing all nodes
        // System.out.println("\nTest 9: Check if tree is empty after removing all nodes");
        // bst.remove(5);
        // bst.remove(12);
        // bst.remove(18);
        // System.out.println("Is tree empty? " + bst.isEmpty());  // Expected: true

        // // Test 10: Test remove on an empty tree
        // System.out.println("\nTest 10: Try to remove from an empty tree");
        // System.out.println("Remove 10 from empty tree: " + bst.remove(10));  // Expected: false
    
        
    }
}

interface Tree<T> {
    int size();
    boolean isEmpty();
    void insert(T element);
    boolean remove(T element);
    boolean contains(T element);
    void levelorder(List<T> list);
    void inorder(List<T> list);
    void preorder(List<T> list);
    void postorder(List<T> list);
}


class TreeNode<T> {
    T element;
    TreeNode<T> left, right;

    public TreeNode(T element) {
        this.element = element;
    }
}

/*
 * Node-based BST implementation
 */
class BSTNode <T extends Comparable<? super T>> implements Tree<T> {
    private TreeNode<T> root;
    private int size;

    public BSTNode(){
        root=null;
        size=0;
    }
    public TreeNode<T> getRoot() {
        // Convenience method for me
        return root;
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
    public void insert(T element) {
        root=recInsert(root, element);
        size++;
    }

    public TreeNode<T> recInsert(TreeNode<T> n, T e){
        if(n==null){
            return new TreeNode<>(e);
        }
        else if(e.compareTo(n.element)>0)
            n.right= recInsert(n.right, e);
        else n.left= recInsert(n.left, e);
        return n;
    }

    @Override
    public boolean remove(T element) {
        if(isEmpty())
            return false;
        root = recRemove(root, element);
        if (root != null) {
            size--;
            return true;
        }
        return false;
    }

    private TreeNode<T> recRemove(TreeNode<T> node, T element) {
        if (node==null) return null;
        else if (element.compareTo(node.element) < 0) {
            node.left = recRemove(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = recRemove(node.right, element);
        } else {
            if (node.left==null&&node.right==null) {
                return null; 
            } else if (node.left==null) {
                return node.right; 
            } else if (node.right==null) {
                return node.left;
            } else {
                TreeNode<T> inorderSuccessor=findMin(node.right); 
                node.element=inorderSuccessor.element;
                node.left=recRemove(node.right, inorderSuccessor.element);
            }
        }
        return node;
    }

    private TreeNode<T> findMin(TreeNode<T> node) {
        while (node!=null&&node.left != null) {
            node = node.left;
        }
        return node;
    }
    private TreeNode<T> findMax(TreeNode<T> node) {
        while (node!=null&&node.right != null) {
            node = node.right;
        }
        return node;
    }

    private boolean delete(TreeNode<T> root, TreeNode<T> target){
        if(root!=null){
        if(root.left==target){
            root.left=null;
            return true;}
        if(root.right==target){
            root.right=null;
            return true;
        }
        if(target.element.compareTo(root.element)>0)
            return delete(root.right, target);
            return delete(root.left, target);
    }
    return false;
        
    }

    public void swap(TreeNode<T> i, TreeNode<T> j){
        if(i!=null&&j!=null){
            T s=i.element;
            i.element=j.element;
            j.element=s;
        }
    }

    public TreeNode<T> inorderForRight(TreeNode<T> n){
        if(n!=null){
            inorderForRight(n.left);
            return n;
        }
        return null;
    }

    public TreeNode<T> inorderForLeft(TreeNode<T> n){
        if(n!=null){
            inorderForLeft(n.right);
            return n;
        }
        return null;
    }

    public TreeNode<T> findNode(TreeNode<T> n, T e){
        if(n!=null){
            if(n.element==e)
                return n;
            else if(e.compareTo(n.element)>0)
                return findNode(n.right, e);
                return findNode(n.left, e);
        }
        return null;
    }

    @Override
    public boolean contains(T element) {
        return recContains(root, element);
    }

    public boolean recContains(TreeNode<T> n, T e){
        if(n==null)
            return false;
        else if(n.element.equals(e)){
            return true;
        }
        else if(e.compareTo(n.element)>0){
            return recContains(n.right, e);
        }
        return recContains(n.left, e);
    }

    @Override
    public void levelorder(List<T> list) {
        if(isEmpty())
            return ;
        else{
            Queue<TreeNode<T>> q= new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode<T> n=q.poll();
                list.add(n.element);
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
        }
    }

    @Override
    public void inorder(List<T> list) {
        recInroder(list, root);
    }

    public void recInroder(List<T> list, TreeNode<T> r){
        if(r!=null){
            recInroder(list, r.left);
            list.add(r.element);
            recInroder(list, r.right);
        }
    }

    @Override
    public void preorder(List<T> list) {
        recPreorder(list, root);
    }

    public void recPreorder(List<T> list, TreeNode<T> r){
        if(r!=null){
            list.add(r.element);
            recInroder(list, r.left);
            recInroder(list, r.right);
        }
    }

    @Override
    public void postorder(List<T> list) {
        recPostorder(list, root);
    }

    public void recPostorder(List<T> list, TreeNode<T> r){
        if(r!=null){
            recInroder(list, r.left);
            recInroder(list, r.right);
            list.add(r.element);
        }
    }

    /*
     * Constructor()
     */
}

/*
 * Array-based BST implementation
 */
class BSTArray <T extends Comparable<? super T>> implements Tree<T> {
    private T[] array;
    private int size;

    public T[] getArray() {
        return array;
    }

    public BSTArray(int capacity) {
        array = (T[]) new Comparable[capacity];
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
    public void insert(T element) {
        recInsert( 0, element);
        size++;
    }

    public void recInsert(int index, T element){
        if (index>=array.length) return;
        if(array[index]==null)
            array[index]=element;
        else if(element.compareTo(array[index])>0){
                recInsert(index*2+2, element);
        }
        else{
            recInsert(index*2+1, element);
        }
    } 

    @Override
    public boolean remove(T element) {
        if(!contains(element)){
            return false;
        }
        else{
            int index=recIndex(element, 0);
            int indexSwap=-1;
            if(hasRight(index))
                indexSwap=findMin(index*2+2);
            else if(hasLeft(index))
                indexSwap=findMax(index*2+1);   
            if(indexSwap!=-1){
                swap(index, indexSwap);
                array[indexSwap]=null;
                swapping(indexSwap);
                size--;
            }
            else{
                array[index]=null;
                size--;
            }
            return true;
        }
    }

    public void swapping(int index){
        if(hasLeft(index)||hasRight(index)){
            if(hasRight(index))
                swap(index, IndexRight(index));
            else swap(index, IndexLeft(index));
        }
        else return;
    }

    public int recIndex(T e, int i){
        if (i>=array.length||array[i]==null) return -1;
        if(array[i]==e)
            return i;
        else if(e.compareTo(array[i])>0)
            return recIndex(e, i*2+2);
        else return recIndex(e, i*2+1);
    }

    public int findMin(int i){
        int left=IndexLeft(i);
        if(i>=0&&i<array.length&&array[i]!=null)
        {
        if(left>=0&&left<array.length)
        if (left<array.length&&array[left]!=null) {
            return findMin(left);
        }
        return i; 
        }
        return -1;
    }
    public int findMax(int i){
        int right=IndexRight(i);
        if(i>=0&&i<array.length&&array[i]!=null)
        {
        if(right>=0&&right<array.length)
        if (right<array.length&&array[right]!=null) {
            return findMax(right);
        }
        return i;
        }
        return -1;
    }

    public void swap(int i, int j){
        if(i>=0&&i<array.length&&j>=0&&j<array.length){
            T e=array[i];
            array[i]=array[j];
            array[j]=e;
        }
    }

    @Override
    public boolean contains(T element) {
        return recContains(0, element);
    }

    public boolean recContains(int i, T e){
        if(i<0||i>=array.length)
            return false;
        else if(array[i]==null)
            return false;
        else if(array[i]==e)
            return true;
        else if(e.compareTo(array[i])>0)
            return recContains(IndexRight(i), e);
        else return recContains(IndexLeft(i), e);
    }

    @Override
    public void levelorder(List<T> list) {
        for (T t : array) {
            list.add(t);
        }
    }

    @Override
    public void inorder(List<T> list) {
        recInorder(list, 0);
    }

    public void recInorder(List<T> list, int i){
        if(i>=0&&i<array.length){
            recInorder(list, 2*i+1);
            list.add(array[i]);
            recInorder(list, i*2+2);
        }
    }

    @Override
    public void preorder(List<T> list) {
        recPreorder(list, 0);
    }

    public void recPreorder(List<T> list, int i){
        if(i>=0&&i<array.length){
            list.add(array[i]);
            recInorder(list, 2*i+1);
            recInorder(list, i*2+2);
        }
    }

    @Override
    public void postorder(List<T> list) {
       recPostorder(list, 0);
    }

    public void recPostorder(List<T> list, int i){
        if(i>=0&&i<array.length){
            recInorder(list, 2*i+1);
            recInorder(list, i*2+2);
            list.add(array[i]);
        }
    }

    public int IndexLeft(int i){
        int iLeft=2*i+1;
        if(iLeft<array.length&&iLeft>=0)
            return iLeft;
        return -1;
    }
    public boolean hasLeft(int index){
        int ileft=IndexLeft(index);
        if(ileft!=-1)
        return array[ileft]!=null;
        return false;
    }
    public boolean hasRight(int index){
        int ileft=IndexRight(index);
        if(ileft!=-1)
        return array[ileft]!=null;
        return false;
    }
    public boolean hasParent(int index){
        int ileft=IndexParent(index);
        if(ileft!=-1)
        return array[ileft]!=null;
        return false;
    }
    public int IndexRight(int i){
        int iLeft=2*i+2;
        if(iLeft<array.length&&iLeft>=0)
            return iLeft;
        return -1;
    }
    public int IndexParent(int i){
        int iLeft=2*i-1;
        if(iLeft<array.length&&iLeft>=0)
            return iLeft;
        return -1;
    }
}

class ListNode <T> {
    private T data;
    private ListNode<T> next;

    public ListNode(T data, ListNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}

class Entry <K extends Comparable<? super K>, V> {
    /*
     * key-value data fields
     * Constructor(K, V)
     * getKey()
     * getValue()
     */

    K key;
    V value;
    public Entry(K k, V v){  // infor friends
        key=k;
        value=v;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }

}

interface IPriorityQueue <P extends Comparable<? super P>, E> {
    void insert(P priority, E element);
    E remove();
    E peek();
    boolean isEmpty();
    int size();
}

abstract class AbstractPriorityQueue <P extends Comparable<? super P>, E> implements IPriorityQueue<P, E> {
    protected ListNode<Entry<P, E>> head;

    public ListNode<Entry<P, E>> getHead() {
        // Convenience for me
        return head;
    }
}

/*
 * Sorted PQ implementation
 */
class SortedPriorityQueue <P extends Comparable<? super P>, E> extends AbstractPriorityQueue <P, E> {
    private ListNode<Entry<P, E>> head;
    private int size;
    public SortedPriorityQueue(){
        size=0;
        head=null;
    }
    @Override
    public void insert(P priority, E element) {
        ListNode<Entry<P, E>> node= new ListNode<>(new Entry<>(priority, element), null);
        if(isEmpty())
            head=node;
        else{
            if(priority.compareTo(head.getData().key)<0){
                node.setNext(head);
                head=node;
            }
            else{
            ListNode<Entry<P, E>> h=head;
            while(h.getNext()!=null&&priority.compareTo(h.getData().key)<0)
                h=h.getNext();
            node.setNext(h.getNext());
            h.setNext(node);
            }
        }
        size++;
    }

    @Override
    public E remove() {
        E rem=head.getData().value;
        size--;
        head=head.getNext();
        return rem;
    }

    @Override
    public E peek() {
        if(isEmpty())
            return null;
        return head.getData().getValue(); 
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

}

/*
 * Unsorted PQ implementation
 */
