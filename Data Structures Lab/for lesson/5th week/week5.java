public class week5{
public static void main(String[] args) {
    LinkedQueue<Integer> queue = new LinkedQueue<>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    
    System.out.println("First element: " + queue.first()); // Should print 1
    System.out.println("Dequeue: " + queue.dequeue()); // Should print 1
    System.out.println("First element after dequeue: " + queue.first()); 
}
}


interface IQueue <E> extends List<E> {
    void enqueue(E e);
    E dequeue();
    E first();
}

interface List <E> {
    int size();
    boolean isEmpty();
}


class LinkedQueue <E> implements IQueue <E> {

    private int size;
        private Node<E> head;
        private Node<E> tail;
        private int capacity;
    
        public LinkedQueue(int capacity){
            size=0;
            head=null;
            tail=null;
            this.capacity=capacity;
        }
        public LinkedQueue(){
            this(1000);
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
        public void enqueue(E e) {
            if(size<capacity){
                Node<E> node= new Node<E>(e, null);
                if(isEmpty()){
                    tail=node;
                    head=node;
                }
                else{
                    node.setNext(head);
                    head=node;
                }
                size++;
            }
        }

        @Override
        public E dequeue() {
            if(isEmpty()){
                return null;
            }
            Node<E> t=head;
            E e=tail.getData();
            while (t.getNext()!=tail) {
                t=t.getNext();
            }
            tail=t;
            return e;
        }

    @Override
    public E first() {
        if(isEmpty())
            return null;
        return tail.getData();
    }
    
}



class Node<T> {
    private T data;
    private Node<T> next;
    public Node(T data, Node<T> next){
        this.data=data;
        this.next=next;
    }

    public T getData() {
        return data;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public Node<T> getNext() {
        return next;
    }
    @Override
    public String toString() {
        return data.toString();
    }
}
