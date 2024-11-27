

import java.util.*;

public class miHeap{
    public static void main(String[] args) {
        minimumHeap<Integer, Integer> mh= new minimumHeap<>();
        // for (int i = 0; i < 4; i++) {
        //     mh.insert(i, i*i);
        // }
        // mh.insert(-1, -1);
        // mh.insert(3, 3);
        // mh.insert(5, 5);
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

