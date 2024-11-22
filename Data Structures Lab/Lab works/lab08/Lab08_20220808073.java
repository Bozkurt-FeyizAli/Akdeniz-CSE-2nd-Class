import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lab08_20220808073 {
    public static void main(String[] args) {
        SortedPriorityQueue<Integer, Integer> sp= new SortedPriorityQueue<>();
        sp.insert(1, 1);
        sp.insert(2, 2);
        sp.insert(3, null);
        BinaryTree<Integer> bt= new BinaryTree<>(12);
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);
        bt.insert(6);
        List<Integer> l= new ArrayList<>();
        bt.levelorder(l);
        for (Integer integer : l) {
            System.out.println(integer);
        }
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
