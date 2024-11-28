
import java.util.*;

public class miHeap{
    public static void main(String[] args) {
        minimumHeap<Integer, Integer> mh= new minimumHeap<>(16);
        for (int i = 0; i < 4; i++) {
            mh.insert(i*i, i*i);
        }
        mh.insert(-1, -1);
        mh.insert(3, 3);
        mh.insert(5, 5);
        mh.insert(020, 20);
        mh.insert(8, 8);
        mh.levelorder();
        mh.remove();
        mh.levelorder();
    }
}

class HeapNode <T> {
    private T data;
    private HeapNode<T> next;

    public HeapNode(T data, HeapNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public HeapNode<T> getNext() {
        return next;
    }

    public void setNext(HeapNode<T> next) {
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

interface Heap<T extends Comparable<? super T>, U> {
    void insert(T element, U u); // Eleman ekler
    Entry<T, U> remove();             // Kök elemanı çıkarır
    Entry<T, U> peek();               // Kök elemanı görüntüler
    boolean isEmpty();      // Heap'in boş olup olmadığını kontrol eder
    int size();             // Heap'teki eleman sayısını döndürür
}


class minimumHeap<T extends Comparable<? super T>, U> implements Heap<T, U>{

    private int size;
    private Entry<T, U>[] array;

    public minimumHeap(int c){
        size=0;
        array= new Entry[c];
    }
    public minimumHeap(){
        size=0;
        array= new Entry[10];
    }
    @Override
    public void insert(T t, U u) {
        resize();
        array[size++]=new Entry<>(t, u);
        recHUp(size-1);
    }

    public void resize(){
        if(size==array.length){
            array= Arrays.copyOf(array, size+size/2);
        }
    }

    public void recHUp(int i) {
        while(i>0){
            if(array[indexParent(i)].getKey().compareTo(array[i].getKey())<0)
                break;
            swap(i, indexParent(i));
            i=indexParent(i);
        }
    }
    

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public Entry<T, U> remove() {
        Entry<T, U> rem=array[0];
        array[0]=array[--size];
        array[size]=null;
        recHDown(0);
        return rem;
    }
    public void recHDown(int i){
        while(hasLeft(i)){
            int leftIndex=indexLeft(i);
            int smallC=leftIndex;
            if(hasRight(i)){
                int rightIndex=indexRight(i);
                if(array[leftIndex].getKey().compareTo(array[rightIndex].getKey())>0)
                    smallC=rightIndex;
            }
            if(array[smallC].getKey().compareTo(array[i].getKey())>0)
                break;
            swap(i, smallC);
            i=smallC;
        }
    }
    @Override
    public Entry<T, U> peek() {
        return array[0];
    }

    public void levelorder() {
        for (Entry<T,U> entry : array) {
            if(entry==null)
                System.out.println("null");
            else
            System.out.println( entry.getValue().toString());
        }
    }

    public void swap(int i, int j){
        if(i<size&&i>=0&&j<size&&j>=0){
        Entry<T, U> swap=array[i];
        array[i]=array[j];
        array[j]=swap;
        }
        else{
            System.out.println(i+", "+j);
            System.out.println( "problem in swap method");
        }
    }

    public int indexRight(int i){ return (2*i+2<size)? 2*i+2: -1;}
    public int indexLeft(int i){ return (2*i+2<size)? 2*i+1: -1;}
    public int indexParent(int i){
        if(i==0)
            return -1;
        else
        return ((i-1)/2<size&&(i-1)/2>-1)? (i-1)/2: -1;}
    public boolean hasRight(int i){return indexRight(i)>0&&indexRight(i)<size;}
    public boolean hasLeft(int i){return indexLeft(i)>0&&indexLeft(i)<size;}
    public boolean hasParent(int i){return indexParent(i)>=0&&indexParent(i)<size;}
    
} 

