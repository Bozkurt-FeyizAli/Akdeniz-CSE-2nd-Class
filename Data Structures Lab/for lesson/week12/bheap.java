import java.util.*;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bheap {
    public static void main(String[] args) {
        MinHeap<Integer> mh= new MinHeap<>();
        mh.insert(2);
        mh.insert(4);
        mh.insert(6);
        mh.insert(8);
        System.out.println(mh);
    }
}

// Temel heap arabirimi
 interface Heap<T> {
    void insert(T element);
    T extract();
    T peek();
    boolean isEmpty();
    int size();
}

// Min-heap implementasyonu
 interface IMinHeap<T extends Comparable<T>> extends Heap<T> {
}

class MinHeap<T extends Comparable<T>> implements IMinHeap<T>{
    private HNode<T> root;
    private int size;
    public MinHeap(){
        root=null;
        size=0;
    }

    @Override
    public void insert(T element) {
        HNode<T> No= new HNode<>(element);
        if (root == null) {
            root = No; } 
        else {
        Queue<HNode<T>> queue= new ConcurrentLinkedQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            HNode<T> node=queue.poll();
            if(node.getLeft()==null){
                node.setLeft(No);
                break;
            }
            else    
                queue.add(node.getLeft());
            if(node.getRight()==null){
                node.setRight(No);
                break;
            }
            else    
                queue.add(node.getRight());
        }

        }
        size++;
    }

    

    @Override
    public T extract() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extract'");
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public String toString() {
        if(root!=null)
        return root.toString();
        return "heap is empty";
    }


}

// HNode class for binary heap
class HNode<T extends Comparable<T>> {
    private T value;
    private HNode<T> left;
    private HNode<T> right;
    private HNode<T> parent;

    public HNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }
    public HNode<T> getParent() {
        return parent;
    }
    public void setParent(HNode<T> parent) {
        this.parent = parent;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public HNode<T> getLeft() {
        return left;
    }

    public void setLeft(HNode<T> left) {
        this.left = left;
    }

    public HNode<T> getRight() {
        return right;
    }

    public void setRight(HNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        String result= "[ "+value+" ";
        if(left!=null)
            result+=" left of "+value+": "+left.toString()+" ] ";
        if(right!=null)
            result+=" right of "+value+": "+right.toString()+" ] ";
        return result+" ]";
    }
}


