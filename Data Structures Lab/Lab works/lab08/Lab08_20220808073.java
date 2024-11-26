import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lab08_20220808073 {
    public static void main(String[] args) {
        // SortedPriorityQueue<Integer, Integer> sp= new SortedPriorityQueue<>();
        // sp.insert(1, 1);
        // sp.insert(2, 2);
        // sp.insert(3, null);
        // BinaryTree<Integer> bt= new BinaryTree<>(12);
        // bt.insert(1);
        // bt.insert(2);
        // bt.insert(3);
        // bt.insert(4);
        // bt.insert(5);
        // bt.insert(6);
        // List<Integer> l= new ArrayList<>();
        // bt.levelorder(l);
        // for (Integer integer : l) {
        //     System.out.println(integer);
        // }

        BSTNode<Integer> bst= new BSTNode<>();
        for (int i = 0; i < 16; i++) {
            bst.insert(i*i);
        }
        System.out.println(bst);
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


/*
 * Array-based BT implementation
 */
class BinaryTree<T> implements Tree<T> {
    private T[] array;
    private int size;

    public BinaryTree(int capacity){
        array= (T[])new Object[capacity];
        size=0;
    }

    public T[] getArray() {
        // Convenience method for me
        return array;
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
        resize();
        array[size]=element;
        size++;
    }

    public void resize(){
        int newLength=array.length;
        if(size>=array.length/2){
            newLength*=2;
        }
        if(size<=array.length/2){
            newLength/=2;
        }
        if(newLength!=array.length)
        array=Arrays.copyOf(array, newLength);
    }

    @Override
    public boolean remove(T element) {
        if(contains(element)){
        int index=-1;
        for (int i = 0; i < size; i++) {
            if(array[i]==element){
                index=i;
                break;}
        }
        if(index!=-1){
            array[index]=array[size-1];
            array[size-1]=null;
            size--;
            return true;
        }
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        for (T t : array) {
            if(t==null)
                break;
            if(t==element)
                return true;
        }
        return false;
        //return recContains(array, 0, element);
    }
    public boolean recContains(T[] arr, int i, T el){
        if(i<size){
            if(arr[i]==el)
                return true;
            if(arr[2*i+1]!=null)
                return recContains(arr, 2*i+1, el);
            if(arr[2*i+2]!=null)
                return recContains(arr, 2*i+2, el);
        }
        return false;
    }

    @Override
    public void levelorder(List<T> list) {
        for (T t : array) {
            if(t==null)
                break;
            list.add(t);
        }

    }

    @Override
    public void inorder(List<T> list) {
        if(!isEmpty()){
            recInorder(list, array, 0);
        }
    }

    public void recInorder(List<T> list, T[] arr, int i){
        if(i<size){
            recInorder(list, array, 2*i+1);
            if(i<array.length)
            list.add(array[i]);
            recInorder(list, arr, 2*i+1);
        }
    }

    @Override
    public void preorder(List<T> list) {
        if(!isEmpty()){
            recPreorder(list, array, 0);;
        }
    }

    public void recPreorder(List<T> list, T[] arr, int i){
        if(i<size){
            if(arr[i]!=null)
                list.add(arr[i]);
            recInorder(list, arr, 2*i+1);
            recInorder(list, arr, 2*i+2);
        }
    }

    @Override
    public void postorder(List<T> list) {
        if(!isEmpty()){
            recPostOrder(list, array, 0);
        }
    }

    public void recPostOrder(List<T> list, T[] arr, int i){
        if(i<size){
            recInorder(list, arr, 2*i+1);
            recInorder(list, arr, 2*i+2);
            if(arr[i]!=null)
                list.add(arr[i]);
        }
    }

    /*
     * Constructor(int capacity)
     */
}

class TreeNode<T> {
    T element;
    TreeNode<T> left, right;

    public TreeNode(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }
    public TreeNode<T> getLeft() {
        return left;
    }
    public TreeNode<T> getRight() {
        return right;
    }
    public void setElement(T element) {
        this.element = element;
    }
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        String result="";
        if(element!=null){
            result+=element.toString()+"\n";
            if(left!=null)
                result+=left;
            if(right!=null)
                result+=right;
        }
        return result;
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
        root=insertRec(root, element);
    }
    private TreeNode<T> insertRec(TreeNode<T> node, T element) {
        if (node == null) {
            size++;
            return new TreeNode<>(element);
        }
        if (element.compareTo(node.element) < 0) {
            node.left = insertRec(node.left, element);
        }
        else if (element.compareTo(node.element) > 0) {
            node.right = insertRec(node.right, element);
        }
        return node;
    }

    @Override
    public boolean remove(T element) {
        // TODO Auto-generated method stub
        if(contains(element)){
            root = removeRec(root, element);
            size--;
            return true;
        }
        return false;
    }
    private T findMin(TreeNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return (T) node.element;
    }
    private T findMax(TreeNode<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return (T) node.element;
    }
    //ödev var
    private TreeNode<T> removeRec(TreeNode<T> node, T element) {
        if (node == null) {
            return null;
        }
        if (element.compareTo(node.element) < 0) {
            node.left = removeRec(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = removeRec(node.right, element);
        } else {
            if(node.left==null)return node.right;
            if(node.right==null)return node.left;

            T minValue=(T) findMin(node.right);
            T maxValue=(T) findMin(node.left);
            node.element=minValue;
            node.right=removeRec(node.right, minValue);
        }
        return node;
    }



    @Override
    public boolean contains(T element) {
        return recCont(element, root);
    }

    public boolean recCont(T t, TreeNode<T> node){
        if(node!=null){
            if(node==t)
                return true;
            if(t.compareTo(node.getElement())<0)
                return recCont(t, node.getLeft());
            if(t.compareTo(node.getElement())>0)
                return recCont(t, node.getRight());
        }
        return false;
    }

    @Override
    public void levelorder(List<T> list) {
        if(!isEmpty()){
            Queue<TreeNode<T>> queue= new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode<T> n=queue.poll();
                list.add(n.getElement());
                if(n.getLeft()!=null)
                    queue.add(n.getLeft());
                if(n.getRight()!=null)
                    queue.add(n.getRight());
            }
        }
    }

    @Override
    public void inorder(List<T> list) {
        recInorder(list, root);
    }

    public void recInorder(List<T> list, TreeNode<T> node){
        if(node!=null){
            recInorder(list, node.getLeft());
            list.add(node.getElement());
            recInorder(list, node.getRight());
        }
    }

    @Override
    public void preorder(List<T> list) {
        // TODO Auto-generated method stub
        preorderRec(root, list);
    }
    private void preorderRec(TreeNode<T> node, List<T> list) {
        if (node != null) {
            list.add(node.element);
            preorderRec(node.left, list);
            preorderRec(node.right, list);
        }
    }

    @Override
    public void postorder(List<T> list) {
        // TODO Auto-generated method stub
        postorderRec(root, list);
    }
    private void postorderRec(TreeNode<T> node, List<T> list) {
        if (node != null) {
            postorderRec(node.left, list);
            postorderRec(node.right, list);
            list.add(node.element);
        }
    }

    @Override
    public String toString() {
        if(root==null)
            return "tree is empty";
        return root.toString();
    }

    /*
     * Constructor()
     */
}

/*
 * Array-based BST implementation
 */
class BSTArray <T extends Comparable<? super T>> extends BinaryTree<T>{
    public T[] array;
    int size;
    public BSTArray(int capacity) {
        super(capacity);
        array = (T[]) new Comparable[capacity];
        size=0;
    }
    @Override
    public T[] getArray() {
        // TODO Auto-generated method stub
        return super.getArray();
    }
    @Override
    public void inorder(List<T> list) {
        // TODO Auto-generated method stub
        recInorder(list, array[0], 0);
    }

    public void recInorder(List<T> list, T t, int i){
        if(t!=null&&i<size){
            recInorder(list, array[2*i+1], i*2+1);
            list.add(t);
            recInorder(list, array[2*i+2], i*2+2);
        }
    }
    @Override
    public void insert(T element) {
        // TODO Auto-generated method stub
        recInsert(element, 0);
    }

    public void recInsert(T t, int i){
        resize();
        if(t!=null&&i<size){
            if(array[i]==null){
                array[i]=t;
                size++;
                return;
            }
            if(t.compareTo(array[i])>0)
                recInsert(t, i*2+2);
            else if(t.compareTo(array[i])<0)
                recInsert(t, i*2+1);
        }
    }
    
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return super.isEmpty();
    }
    @Override
    public void levelorder(List<T> list) {
        if(!isEmpty()){
            for (T t : array) {
                if(t!=null)
                    list.add(t);
            }
        }
    }
    @Override
    public void postorder(List<T> list) {
        // TODO Auto-generated method stub
        super.postorder(list);
    }
    @Override
    public void preorder(List<T> list) {
        // TODO Auto-generated method stub
        super.preorder(list);
    }
    @Override
    public boolean recContains(T[] arr, int i, T el) {
        if(i<size){
            if(arr[i]==el)
                return true;
            if(el.compareTo(arr[i])<0)
                return recContains(arr, 2*i+1, el);
            if(el.compareTo(arr[i])>0)
                return recContains(arr, 2*i+1, el);
        }
        return false;
    }
    @Override
    public void recInorder(List<T> list, T[] arr, int i) {
        // TODO Auto-generated method stub
        super.recInorder(list, arr, i);
    }
    @Override
    public void recPostOrder(List<T> list, T[] arr, int i) {
        // TODO Auto-generated method stub
        super.recPostOrder(list, arr, i);
    }
    @Override
    public void recPreorder(List<T> list, T[] arr, int i) {
        // TODO Auto-generated method stub
        super.recPreorder(list, arr, i);
    }
    @Override
    public boolean remove(T element) {
        // TODO Auto-generated method stub
        return super.remove(element);
    }
    @Override
    public void resize() {
        // TODO Auto-generated method stub
        super.resize();
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return super.size();
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
    private K key;
    private V value;
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
}

interface IPriorityQueue <P extends Comparable<? super P>, E> {
    void insert(P priority, E element);
    E remove();
    E peek();
    boolean isEmpty();
    int size();
}

abstract class AbstractPriorityQueue <P extends Comparable<? super P>, E> implements IPriorityQueue<P, E> {
    private ListNode<Entry<P, E>> head;

    public ListNode<Entry<P, E>> getHead() {
        // Convenience for me
        return head;
    }

    public AbstractPriorityQueue() {
        head = null;
    }
}

/*
 * Sorted PQ implementation
 */
class SortedPriorityQueue <P extends Comparable<? super P>, E> extends AbstractPriorityQueue <P, E> {
    private ArrayList<Entry<P,E>> list;
    private int size;
    public SortedPriorityQueue(){
        list= new ArrayList<>();
        size=0;
    }
    @Override
    public void insert(P priority, E element) {
        Entry<P,E> ent= new Entry<>(priority, element);
        if(isEmpty()){
            list.add(ent);
        }
        else{
            for (int i = 0; i < list.size(); i++) {
                if(priority.compareTo(list.get(i).getKey())>0){
                    list.add(i, ent);
                    break;
                }
            }
        }
        size++;
    }

    @Override
    public E remove() {
        if(isEmpty())
            return null;
        else{
            size--;
            return list.remove(0).getValue();
        }
    }

    @Override
    public E peek() {
        return list.get(0).getValue();
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
class UnsortedPriorityQueue <P extends Comparable<? super P>, E> extends AbstractPriorityQueue <P, E> {
    private ListNode<Entry<P,E>> head;
    //private ListNode<Entry<P,E>> tail;
    private int size;
    public UnsortedPriorityQueue(){
        head=null;
        //tail=null;
        size=0;
    }
    @Override
    public void insert(P priority, E element) {
        Entry<P,E> ent= new Entry<>(priority, element);
        ListNode<Entry<P,E>> lNode= new ListNode<>(ent, null);
        if(isEmpty()){
            head=lNode;
        }
        else{
            ListNode<Entry<P,E>> h=head;
            while(h.getNext()!=null)
                h=h.getNext();
            h.setNext(lNode);
        }
        size++;
    }

    @Override
    public E remove() {
        if(isEmpty()){
            return null;
        }
        else{
            ListNode<Entry<P,E>> m=head;
            ListNode<Entry<P,E>> h=head;
            while(h.getNext()!=null){
                if(h.getData().getKey().compareTo(h.getData().getKey())>0){
                    m=h;
                }
                h=h.getNext();
            }
            
            if(m==head){
                head=head.getNext();
            }
            else{
                h=head;
                while(h.getNext()!=null){
                    if(h==m){
                        h.setNext(h.getNext());
                    }
                    h=h.getNext();
                }
            }
            size--;
            return m.getData().getValue();
        }
        
    }
