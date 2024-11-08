public class LinkedLists {
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
    E data;
    Node<E> prev;
    Node<E> next;
    
    public Node(E data, Node<E> next){
        this(data, next, null);
    }
    public Node(E data, Node<E> next, Node<E> prev){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }

    @Override
    public E getElement() {
        return data;
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

class DoublyLinkedList<E> implements Doubly<E>{}

class CircularLinkedList<E> implements List<E>, Circlular{}

class SinglyLinkedList<E> implements List<E>{
    int size;
    Node<E> head;
    Node<E> tail;
    public SinglyLinkedList(){
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
       if(head==null)
        return null;
        return head.getElement();
    }

    @Override
    public E last() {
        if(tail==null)
            return null;
        return tail.getElement();
    }

    @Override
    public void addFirst(E e) {
        Node<E> newnode= new Node<>(e, null); 
        if(isEmpty()){
            head=tail=newnode;
        }
        else{
            newnode.setNext(head);
            head=newnode;
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> newnode= new Node<>(e, null);
        if(isEmpty()){
            addFirst(e);
        }
        else{
            tail.setNext(newnode);
            tail=tail.getNext();
            size++;
        }
    }

    @Override
    public E removeFirst() {
        if(isEmpty())
            return null;
        else{
            E remove=head.getElement();
            head=head.getNext();
            size--;
            if(size==1){
                tail=head;
            }
            return remove;
        }
    }
    
}
