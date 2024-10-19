public class week5{
public static void main(String[] args) {
    
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

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public void enqueue(E e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enqueue'");
    }

    @Override
    public E dequeue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }

    @Override
    public E first() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'first'");
    }
    
}




