import java.util.NoSuchElementException;

public class piotityQueue {
    
}



interface IPriorityQueueNode<T> {
    
    /**
     * Bu öğenin öncelik değerini döndürür.
     * @return Öncelik değeri (daha yüksek değer, daha yüksek öncelik anlamına gelebilir)
     */
    int getPriority();
    T getData();
}

interface IPriorityQueue<T> {
    
    /**
     * Yeni bir öğe öncelik sırasına ekler.
     * @param item Eklenecek öğe.
     */
    void enqueue(PriorityQueueNode<T> priorityQueueNode);
    
    /**
     * En yüksek öncelikli öğeyi öncelik sırasından kaldırır ve döndürür.
     * @return En yüksek öncelikli öğe.
     * @throws NoSuchElementException Öncelik sırası boşsa bu istisna fırlatılır.
     */
    T dequeue();
    
    /**
     * En yüksek öncelikli öğeyi, onu kaldırmadan döndürür.
     * @return En yüksek öncelikli öğe.
     * @throws NoSuchElementException Öncelik sırası boşsa bu istisna fırlatılır.
     */
    T peek();
    
    /**
     * Öncelik sırasının boş olup olmadığını kontrol eder.
     * @return Öncelik sırası boşsa true, değilse false döner.
     */
    boolean isEmpty();
    
    /**
     * Öncelik sırasındaki öğe sayısını döndürür.
     * @return Öğe sayısı.
     */
    int size();
}

class PiorityQueue<T> implements IPriorityQueue<T>{
    private int size;
    private PriorityQueueNode<T>[] datas;
    private static final int capacity=15;

    public PiorityQueue(int capacity){
        size=0;
        datas= new PriorityQueueNode[capacity];
    }

    public PiorityQueue(){
        this(capacity);
    }
    @Override
    public void enqueue(PriorityQueueNode<T> priorityQueueNode) {
        if (isEmpty() || datas == null)
            throw new NoSuchElementException();
        if(size==datas.length)
            System.out.println("Error.");
        else{
        int priority=size-1;
        for (int i = size-1; i>=0; i--) {
            if(datas[i].getPriority()<priority){
                priority=i;
                break;
            }
        }

        for (int i = size-1; i >= priority; i--) {
            datas[i+1]=datas[i];
        }
        datas[priority]=priorityQueueNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty() || datas == null)
            throw new NoSuchElementException();
        int priority=-1;
        T priotiryNode=null;
        for (int i = 0; i < size; i++) {
            if(datas[i].getPriority()>priority){
                priotiryNode=datas[i].getData();
                priority=datas[i].getPriority();
            }
        }
        if(priority!=-1){
        for (int i = priority; i < size; i++) {
            if(priority+1!=datas.length){
                datas[i]=datas[i+1];
            }
            else{
                datas[size-1]=datas[size-2];
            }
        }
        return priotiryNode;
        }
        return null;
    }

    @Override
    public T peek() {
        if (isEmpty() || datas == null)
            throw new NoSuchElementException();
        int priority=-1;
        T priotiryNode=null;
        for (int i = 0; i < size; i++) {
            if(datas[i].getPriority()>priority){
                priotiryNode=datas[i].getData();
                priority=datas[i].getPriority();
            }
        }
        return priotiryNode;
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

class PriorityQueueNode<T> implements IPriorityQueueNode<T>{
    private T data;
    private int priority;

    public PriorityQueueNode(T data, int priority){
        this.data=data;
        this.priority=priority;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public T getData() {
       return data;
    }

}


