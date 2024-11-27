
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

