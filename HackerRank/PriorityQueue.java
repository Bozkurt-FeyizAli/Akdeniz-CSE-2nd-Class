public class PriorityQueue {
    public static void main(String[] args) {
        
    }
}




interface PriorityQueueInterface<E> {
    void insert(E element, int priority); // Belirtilen öncelik ile bir eleman ekler.
    E extractMin(); // En yüksek önceliğe sahip elemanı çıkarır ve döner.
    E peek(); // En yüksek önceliğe sahip elemanı döner, ancak çıkarmaz.
    boolean isEmpty(); // Kuyruğun boş olup olmadığını kontrol eder.
    int size(); // Kuyruktaki eleman sayısını döner.
}


