public class Lab02 {
    public static void main(String[] args) {
        // SinglyLinkedList<Integer> single = new SinglyLinkedList<>();
        // single.addFirst(1);
        // single.addFirst(2);
        // System.out.println(single.toString());

        // CircularLinkedList<Integer> circular = new CircularLinkedList<>();
        // circular.addLast(10);
        // circular.addLast(20);
        // circular.addLast(30);
        // // circular.rotate();
        // System.out.println(circular.toString());

        DoublyLinkedList<Integer> doubly = new DoublyLinkedList<>();
        doubly.addFirst(100);
        doubly.addLast(200);
        doubly.addFirst(50);
        System.out.println(doubly.toString());
        System.out.println(doubly.removeFirst());
        // System.out.println(doubly.toString());
        // System.out.println(doubly.last());
        doubly.removeFirst();
        System.out.println(doubly.last());
        doubly.addLast(12);
        System.out.println(doubly.toString());
        // System.out.println(single.toString());
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
    public Node(E e, Node<E> prev, Node<E> next){
        element=e;
        this.prev=prev;
        this.next=next;
    }
    public Node(E e, Node<E> next){
        element=e;
        this.prev=null;
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
    // @Override
    // public String toString(){
    //     return E.toString();
    // }
}


class SinglyLinkedList<E> implements List<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public SinglyLinkedList(){
        head=null;
        tail=null;
        size=0;
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
    public E first() {
        if(size==0){return null;}
        return head.getElement();
    }

    @Override
    public E last() {
        if(size==0){return null;}
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        if(size==0){head=new Node<E>(e, null, null); size++;
        tail=head;
        return;
        }
        Node<E> newNode= new Node<E>(e, null, head);
        head=newNode;
        size++;

    }

    @Override
    public void addLast(E e) {
        if(size==0){addFirst(e); return;}
        Node<E> newNode= new Node<E>(e, null, null);
        tail.setNext(newNode);
        tail=newNode;
        size++;
        
    }

    @Override
    public E removeFirst() {
        if(size==0){return null;}
        Node<E> n=head;
        head=head.getNext();
        if(head!=null){
            head.setPrev(null);
        }
        size--;
        if(size==0){
            tail=null;
            head=null;
        }
        return n.getElement();
    }
    @Override
    public String toString(){
        String result="";
        Node<E> n= head;
        while(n!=null){
            result+=" "+n.getElement().toString();
            n=n.getNext();
        }
        return result;
    }
    
}

class CircularLinkedList<E> implements List<E>, Circlular{

    // private Node<E> head;
    private Node<E> tail;
    private int size;
    public CircularLinkedList(){
        tail=null;
        size=0;
    }

    @Override
    public void rotate() {
        if(tail!=null)
            tail=tail.getNext();
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
    public E first() {
        if(size==0){return null;}
        return tail.getNext().getElement();
    }

    @Override
    public E last() {
        if(size==0){return null;}
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        // Node<E> newNode= new Node<E>(e, null, head);
        if(size==0){
            tail= new Node<E>(e, null);
            tail.setNext(tail);}
        else{
        Node<E> newNode= new Node<E>(e, tail.getNext());
        tail.setNext(newNode);
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        addFirst(e);
        tail=tail.getNext();

    }

    @Override
    public E removeFirst() {
        if(size==0){return null;}
        Node<E> h=tail.getNext();
        
        if(h==tail){
            tail=null;
        }
        else{
            tail.setNext(h.getNext());
        }
        // tail.setNext(h.getNext());
        // Node<E> t=tail;
        // tail=tail.getPrev();
        // tail.setNext(null);
        size--;
        return h.getElement();
    }
}

class DoublyLinkedList<E> implements Doubly<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public DoublyLinkedList(){
        head=null;
        tail=null;
        size=0;
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
    public E first() {
        if(size==0){return null;}
        return head.getElement();
    }

    @Override
    public E last() {
        if(size==0){return null;}
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        Node<E> newNode= new Node<E>(e, null, head);
        if(size==0){tail=newNode;}
        else{
            head.setPrev(newNode);
        }
        head=newNode;
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> newNode= new Node<>(e, tail, null);
        if(size==0)
            head=newNode;
        else
            tail.setNext(newNode);
        tail=newNode;
        size++;    
    }

    @Override
    public E removeFirst() {
        if(size==0){return null;}
        Node<E> n=head;

        head=head.getNext();
        size--;
        if(size==0){tail=null;
        // head.setPrev(null);
        }
        else{head.setPrev(null);}
        
        // head.setPrev(null);
        return n.getElement();
    }

    @Override
    public E removeLast() {
        if(size==0){return null;}
        // if(size==1){return removeFirst();}
        
        Node<E> t=tail;
        tail=tail.getPrev();
        if(size==1){
            head=null;
            tail=null;
        }
        else{
            
            tail.setNext(null);
        }
        size--;
        // Node<E> nTail=tail.getPrev();
        // nTail.setNext(head);
        // tail=nTail;
        return t.getElement();
    }

    @Override
    public String toString(){
        String result="";
        Node<E> n= head;
        while(n!=null){
            result+=" "+n.getElement().toString();
            n=n.getNext();
        }
        return result;
    }

}

/*
* According to given above given interfaces, implement:
*       1. A concrete Node class that implements INode generic interface
*       2. A concrete SinglyLinkedList class that implements List generic interface
*       3. A concrete CircularLinkedlist class that implements List generic interface and Circular interface
*       4. A concrete DoublyLinkedList class that implements Doubly generic interface
* For each of the concrete classes, use Node class as the storage unit
* !! SinglyLinkedList class must have head and tail data fields
* !! CircularLİnkedList class must have tail data field
* !! Every class except Node must only have a single constructor without any parameters
* You can implement any additional method you would like
*/