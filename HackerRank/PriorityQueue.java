public class PriorityQueue {
    public static void main(String[] args) {
        
    }
}


interface PriorityQueueNodeInterface<E> {
    E getElement(); // Düğümdeki elemanı döner.
    void setElement(E element); // Düğümdeki elemanı ayarlar.
    int getPriority(); // Düğümdeki önceliği döner.
    void setPriority(int priority); // Düğümdeki önceliği ayarlar.
}

class PriorityQueueNode<E> implements PriorityQueueNodeInterface<E>{
    private E element;
    private int priority;
    public PriorityQueueNode(E e, int priority){
        element=e;
        this.priority=priority;
    }

    @Override
    public E getElement() {
        return element;
    }

    @Override
    public void setElement(E element) {
        this.element=element;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public void setPriority(int priority) {
        this.priority=priority;
    }
    
}

interface PriorityQueueInterface<E> {
    void insert(E element, int priority); // Belirtilen öncelik ile bir eleman ekler.
    E extractMin(); // En yüksek önceliğe sahip elemanı çıkarır ve döner.
    E peek(); // En yüksek önceliğe sahip elemanı döner, ancak çıkarmaz.
    boolean isEmpty(); // Kuyruğun boş olup olmadığını kontrol eder.
    int size(); // Kuyruktaki eleman sayısını döner.
}


