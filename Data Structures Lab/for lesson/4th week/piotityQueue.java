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
    void enqueue(T item);
    
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



class PriorityQueueNode<T> implements IPriorityQueueNode<T>{
    T data;
    int priority;

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


