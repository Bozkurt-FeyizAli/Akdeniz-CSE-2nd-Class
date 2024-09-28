public class a {

    public static void main(String[] args) {
        
    }
}

interface List <E> {
    int size(); // Returns the size of the list
    boolean isEmpty(); // Checks whether the list is empty or not
    E first(); // returns the element/data of first entry in the list
    E last(); // returns te element/data of last entry in the list
    void addFirst(E e); // adds the given element at the start of the list
    void addLast(E e); // adds the given element at the end of the list
    E removeFirst(); // removes the first element in the list
}

interface Circlular {
    void rotate(); // tail becomes next of tail if not empty
}

interface Doubly <E> extends List <E> {
    E removeLast(); //removes the last element from the list
}

interface INode <E> { // storage unit
    E getElement(); // data/element
    Node<E> getPrev(); // returns the previous unit of this unit
    void setPrev(Node<E> prev); // sets the previous of this unit
    Node<E> getNext(); // returns the next unit of this unit
    void setNext(Node<E> next); // sets the next of this unit
}

class Node<E> implements INode<E>{
    private E element;
    private Node<E> prev;
    private Node<E> next;

    public Node(E element , Node<E> prev, Node<E> next){
        this.element=element;
        this.prev=prev;
        this.next=next;
    }
    @Override
    public E getElement() {
        return element;
    }

    @Override
    public Node<E> getPrev() {
        return prev;
    }

    @Override
    public void setPrev(Node<E> prev) {
       this.prev=prev;
    }

    @Override
    public Node<E> getNext() {
        return next;
    }

    @Override
    public void setNext(Node<E> next) {
        this.next=next;
    }
}


class SinglyLinkedList<E> implements List<E>{
    private Node<E> head ;
    private Node<E> tail ;
    private int size;

    public SinglyLinkedList() {
        head =null;
        tail=null;
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if (isEmpty()){
            return null;
        }
        return head.getElement();
    }

    @Override
    public E last() {
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        head = new Node<>(e, null, head);
        if (size == 0) tail = head;
        size++;
    }

    @Override
    public void addLast(E e) {
        //n=newest thing
        Node<E> n = new Node<>(e, null, null);
        if (isEmpty()){
            head = n;
        }
        else{
            tail.setNext(n);
        }
        tail = n;
        size++;
    }

    //ans = answer
    @Override
    public E removeFirst() {
        if (isEmpty()){
            return null;
        }
        E ans = head.getElement();
        head = head.getNext();
        head.setPrev(null);
        size--;
        if (size == 0){
            tail = null;
            head=null;
        }
        return ans;
    }

}

class CircularLinkedList<E> implements Circlular,List<E>{
    private Node<E> tail = null;
    private int size = 0;

    public CircularLinkedList() {}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if (isEmpty()){
            return null;
        }
        return tail.getNext().getElement();
    }

    @Override
    public E last() {
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        if (isEmpty()) {
            tail = new Node<>(e, null, null);
            tail.setNext(tail);
        } 
        else {
            Node<E> n = new Node<>(e, null, tail.getNext());
            tail.setNext(n);
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    @Override
    public E removeFirst() {
        if (isEmpty()){
            return null;
        }
        Node<E> head = tail.getNext();
        if (head == tail){
            tail = null;
        }
        else{
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }

    @Override
    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

}

class DoublyLinkedList<E> implements Doubly<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public DoublyLinkedList() {}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    @Override
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        Node<E> n = new Node<>(e, null, head);
        if (isEmpty()) tail = n;
        else head.setPrev(n);
        head = n;
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> n = new Node<>(e, tail, null);
        if (isEmpty()) head = n;
        else tail.setNext(n);
        tail = n;
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null;
        E ans = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) tail = null;
        else head.setPrev(null);
        return ans;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) return null;
        E ans = tail.getElement();
        tail = tail.getPrev();
        size--;
        if (size == 0) head = null;
        else tail.setNext(null);
        return ans;
   }
}

