import java.util.ArrayList;
import java.util.List;

public class PriorityQueueDeneme {
    public static void main(String[] args) {
        PriorityQueue<Integer> pr= new PriorityQueue<>(-5, -5);
        for (int i = 0; i < 15; i++) {
            pr.insert(i, i);
        }
        pr.insert(13, 69);
        for (var v : pr.getList()) {
            System.out.println(v.getElement().toString()+" "+v.getPriority());
        }
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
class PriorityQueue<E> implements PriorityQueueInterface<E>{
    private int size;
    private List<PriorityQueueNode<E>> list;

    public PriorityQueue(E element, int priority){
        size=1;
        list=new ArrayList<>();
        list.add(new PriorityQueueNode<>(element, priority));
    }
    public List<PriorityQueueNode<E>> getList() {
        return list;
    }

    @Override
    public void insert(E element, int priority) {
        PriorityQueueNode<E> node= new PriorityQueueNode<>(element, priority);
        if(isEmpty())
            list.add(node);
        else{
        for (int i = 0; i < size; i++) {
            if(priority>list.get(i).getPriority()){
                if(i==0)
                    list.addFirst(node);
                else list.add(i-1, node);
                break;
            }   
        }
        if(!list.contains(node))
            list.add(node);
        }
        size++;
    }

    @Override
    public E extractMin() {
        if(isEmpty())
            return null;
        E min=list.getFirst().getElement();
        list.removeFirst();
        return min;
    }

    @Override
    public E peek() {
        return list.getFirst().getElement();
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
 * insert(E element, int priority): Öncelik değerine göre kuyruğa bir eleman ekler.

extractMin(): En yüksek önceliğe sahip elemanı çıkarır ve döner. Öncelik en düşük değer olarak kabul edilir.

peek(): Kuyrukta bulunan en yüksek öncelikli elemanı döner ancak onu kuyruktan çıkarmaz.

isEmpty(): Kuyruğun boş olup olmadığını kontrol eder.

size(): Kuyruğun mevcut eleman sayısını döner.

PriorityQueueNode metodları: Düğümler arasında eleman ve öncelik değerlerini almak ve ayarlamak için kullanılır.
 */



