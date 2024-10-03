import java.util.NoSuchElementException;

public class HW02 {
    public static void main(String[] args) {

        MusicPlayer mp = new MusicPlayer("./Musics");
        DoublyCircularLinkedList<Integer> dcll= new DoublyCircularLinkedList<>(); 
        dcll.addFirst(20);
        dcll.addFirst(10);
        dcll.addFirst(5);
        dcll.addLast(21);
        dcll.removeLast();
        System.out.println(dcll.toString());
        System.out.println(dcll.getHead().toString());
                
    }
}

interface INode <T> { // storage unit
    // Constructor (T data, Node<T> prev, Node<T> next)
    T getData(); // returns the data
    Node<T> getNext(); // returns the next of this storage unit
    Node<T> getPrev(); // returns the previous storage unit of this unit
    void setNext(Node<T> next); // sets next pointer of this node
    void setPrev(Node<T> prev); // sets the prev pointer of this node
    String toString(); // string representation
}

interface IDoublyCircularLinkedList <T> {
    // must have the data field current
    // Constructor ()
    void addFirst(T data); // adds an element to the head of the list. If first element in list, must also be last element
    // if only element in the list its next and prev should point to itself
    void addLast(T data); // adds an element to the tail of the list. If first element in list, must also be last element
    // if only element in the list its next and prev should point to itself
    T removeFirst() throws NoSuchElementException; // removes the first element in the list,
    // throw exception if list is empty, if only element remaining it should be first and last and its next and prev,
    // should be itself
    T removeLast() throws NoSuchElementException; // removes the last element in the list,
    // throw exception if list is empty, if only element remaining it should be first and last and its next and prev,
    // should be itself
    T get(int index) throws IndexOutOfBoundsException; // gets the ith element in the list,
    // should throw exception if out of bounds
    T first() throws NoSuchElementException; // should set current, returns the first data
    T last() throws NoSuchElementException; // should set current, returns the last data
    boolean remove(T data); // should return false if data doesnt exists, returns true and removes if exists
    boolean isEmpty();
    int size();
    T next() throws NoSuchElementException; // if empty, throws exception, should change current correctly
    // if current is null should return head and set it to head
    T previous() throws NoSuchElementException; // if empty, throws exception, should change current correctly
    // if current is null should return tail data and set it
    T getCurrent() throws NoSuchElementException; // Retruns the current pointer, if no element exits throws exception
    // if current is null returns heads data
    Node<T> getHead(); // returns the head of the list, if is empty returns null
    // any other method needed

}

class Node<T> implements INode<T> {
   private T elemetnt;
   private Node<T> prev;
   private Node<T> next;

   public Node(T e, Node<T> prev, Node<T> next){
    elemetnt=e;
    this.prev=prev;
    this.next=next;
   }

    @Override
    public T getData() {
        return elemetnt;
    }

    @Override
    public Node<T> getNext() {
        return next;
    }

    @Override
    public Node<T> getPrev() {
        return prev;
    }

    @Override
    public void setNext(Node<T> next) {
        this.next=next;
    }

    @Override
    public void setPrev(Node<T> prev) {
        this.prev=prev;
    }

    @Override
    public String toString(){
        return elemetnt.toString();
    }
}



class DoublyCircularLinkedList<T> implements IDoublyCircularLinkedList<T> {
    private Node<T> tail;
    private int size;
    private Node<T> current;

    public DoublyCircularLinkedList(){  // denendi
        tail=null;
        size=0;
        current=null;
    }

    @Override
    public void addFirst(T data) { // denendi
        Node<T> newNode=new Node<T>(data, null, null);
        if(isEmpty()){
            tail=newNode;
            tail.setNext(newNode);
            tail.setPrev(newNode);
            current=tail; //sonradan eklenedi
        }
        else{
            newNode.setNext(tail.getNext());
            newNode.setPrev(tail);
            tail.getNext().setPrev(newNode);
            tail.setNext(newNode);
            current=newNode;  //sonradan eklenedi
        }
        size++;
    }

    @Override
    public void addLast(T data) {  // denendi
        Node<T> newNode=new Node<T>(data, null, null);
        if(isEmpty()){
            tail=newNode;
            tail.setNext(newNode);
            tail.setPrev(newNode);
            current=tail; //sonradan eklenedi
        }
        else{
            newNode.setNext(tail.getNext());
            newNode.setPrev(tail);
            tail.getNext().setPrev(newNode);
            tail.setNext(newNode);
            tail=newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() throws NoSuchElementException { // denendi
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            Node<T> h=tail.getNext();
            size--;
            if(size==1){
                tail.setNext(tail);
                tail.setPrev(tail);
                current=tail; //sonradan eklenedi
            }
            else if(size==0){
                tail=null;
                current=null; //sonradan eklenedi
            }
            else{
                tail.getNext().setPrev(tail);
                tail.setNext(tail.getNext().getNext());
                current=tail.getNext(); //sonradan eklenedi
            }  
            return h.getData();
        }
    }

    @Override
    public T removeLast() throws NoSuchElementException {  // denendi
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            Node<T> t= tail;
            size--;
            // tail=tail.getPrev();
            if(size==1){
                // tail.getNext().setNext(tail.getNext());
                // tail.getNext().setPrev(tail.getPrev());
                tail.getPrev().setNext(tail.getPrev());
                tail.getNext().setPrev(tail.getNext());
                tail=tail.getPrev();
            }
            else if(size==0){
                tail=null;
                current=null; //sonradan eklenedi
            }
            else{
                tail.getPrev().setNext(tail.getNext());
                tail.getNext().setPrev(tail.getPrev());
                tail=tail.getPrev();
            }
            
            return t.getData();
        }
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if(index>size||index<0){
            throw new IndexOutOfBoundsException();
        }
        else{
            Node<T> h= tail.getNext();
            for (int i = 0; i < index; i++) {
                h=h.getNext();
            }
            return h.getData();
        }
    }

    @Override
    public T first() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return removeFirst();
        }
    }

    @Override
    public T last() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            return removeLast();
        }
    }

    @Override
    public boolean remove(T data) {
        if(isEmpty()){
            return false;
        }
        else{
            Node<T> h= tail.getNext();
            while(!h.equals(tail.getNext())){
                if(data.equals(h)){
                    Node<T> now=h.getNext();
                    now.setPrev(h.getPrev());
                    h.getPrev().setNext(now);
                    return true;
                }
                    
                h=h.getNext();    
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T next() throws NoSuchElementException {
        if(isEmpty())
            throw new NoSuchElementException();
        if(current==null)
            current=tail.getNext();
        else
            current=current.getNext(); 
        return current.getData();
    }

    @Override
    public T previous() throws NoSuchElementException {
        if(isEmpty())
            throw new NoSuchElementException();
        if(current==null)
            current=tail;
        else
        current=current.getPrev(); 
        return current.getData();
    }

    @Override
    public T getCurrent() throws NoSuchElementException {
       if(isEmpty()){
        throw new NoSuchElementException();
       }
       return current.getData();
    }

    @Override
    public Node<T> getHead() {
        if(isEmpty()){
            return null;
        }
        return tail.getNext();
    }

    @Override
    public String toString(){
        StringBuilder sb= new StringBuilder();
        if(isEmpty()){return "boşluk";}
        Node<T> h=tail.getNext();
        sb.append(h.toString()+" ");
        while(!h.equals(tail)){
            h=h.getNext();
            sb.append(h.toString()+" ");
        }
        return sb.toString();
    }
 
}
