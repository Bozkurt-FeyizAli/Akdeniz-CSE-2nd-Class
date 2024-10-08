import java.util.NoSuchElementException;

public class HW02_20220808073 {
    public static void main(String[] args) {

        MusicPlayer mp = new MusicPlayer("./Musics");
        DoublyCircularLinkedList<Integer> dcll= new DoublyCircularLinkedList<>(); 

        System.out.println(false==dcll.remove(0));

        dcll.addLast(1);
        dcll.addLast(2);
        dcll.addLast(3);
    
        System.out.println(true==dcll.remove(2));
        System.out.println(2==dcll.size());
        System.out.println(1==dcll.getHead().getData());
        System.out.println(3==dcll.getHead().getNext().getData());
        System.out.println(1==dcll.getHead().getNext().getNext().getData());
        System.out.println(3==dcll.getHead().getPrev().getData());
        System.out.println(1==dcll.getHead().getPrev().getPrev().getData());
    
        System.out.println(true==dcll.remove(3));
        System.out.println(1==dcll.size());
        System.out.println(1==dcll.getHead().getData());
        System.out.println(1==dcll.getHead().getNext().getData());
        System.out.println(1==dcll.getHead().getPrev().getData());
    
        System.out.println(false==dcll.remove(3));
        System.out.println(true==dcll.remove(1));
        System.out.println(0==dcll.size());
    
        DoublyCircularLinkedList<String> ll = new DoublyCircularLinkedList<>();
        ll.addLast("one");
        ll.addLast("two");
        ll.addLast("three");
        ll.addLast("four");
        ll.addLast("five");
        ll.addLast("six");
        ll.addLast("seven");
    
        System.out.println(false==ll.remove("eight"));
        System.out.println(7==ll.size());
    
        System.out.println(true==ll.remove("one"));
        System.out.println(6==ll.size());
        System.out.println("two"==ll.getHead().getData());
        System.out.println("seven"==ll.getHead().getPrev().getData());
        System.out.println(true==ll.remove("seven"));
        System.out.println(5==ll.size());
        System.out.println("two"==ll.getHead().getData());
        System.out.println("six"==ll.getHead().getPrev().getData());
    
        System.out.println("three"==ll.getHead().getNext().getData());
        System.out.println("four"==ll.getHead().getNext().getNext().getData());
        System.out.println("five"==ll.getHead().getNext().getNext().getNext().getData());
        System.out.println("six"==ll.getHead().getNext().getNext().getNext().getNext().getData());
        System.out.println("two"==ll.getHead().getNext().getNext().getNext().getNext().getNext().getData());
    
        System.out.println(true==ll.remove("three"));
        System.out.println(4==ll.size());
        System.out.println("two"==ll.getHead().getData());
        System.out.println("four"==ll.getHead().getNext().getData());
        System.out.println("six"==ll.getHead().getPrev().getData());
        System.out.println("five"==ll.getHead().getPrev().getPrev().getData());
        System.out.println("four"==ll.getHead().getPrev().getPrev().getPrev().getData());
        System.out.println("two"==ll.getHead().getPrev().getPrev().getPrev().getPrev().getData());
        dcll.addFirst(20);
        dcll.addFirst(10);
        dcll.addFirst(11);
        dcll.addLast(21);
        System.out.println(dcll.toString());
        dcll.removeLast();
        System.out.println(dcll.toString());
        System.out.println(dcll.getHead().toString());
        DoublyCircularLinkedList<Integer> pyramidRight= new DoublyCircularLinkedList<>();
        DoublyCircularLinkedList<Integer> pyramidLeft= new DoublyCircularLinkedList<>();
        String piramit="";
        for (int i = 1; i < 10; i++) {
            pyramidRight.addFirst(i);
            pyramidLeft.addLast(i);
            String s="";
            for (int j = 0; j <10- i-1; j++) {
                s+="  ";
            }
            piramit+=s+pyramidLeft.toString();
            piramit+=pyramidRight.toString()+"\n";
        }
        String[] pi=piramit.split("\n");
        for (int i = 0; i < pi.length; i++) {
            pi[i]=pi[i].substring(0,16)+pi[i].substring(18, pi[i].length());
        }
        for (String string : pi) {
            System.out.println(string);
        }
                
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
            // current=newNode; //sonradan eklenedi
        }
        else{
            newNode.setNext(tail.getNext());
            newNode.setPrev(tail);
            tail.getNext().setPrev(newNode);
            tail.setNext(newNode);
            // current=newNode;  //sonradan eklenedi
        }
        size++;
    }

    @Override
    public void addLast(T data) {  // denendi
        Node<T> newNode=new Node<T>(data, null, null);
        if(isEmpty()){
            // tail=newNode;
            // tail.setNext(newNode);
            // tail.setPrev(newNode);
            // current=tail; //sonradan eklenedi  yukarının aynısı
            addFirst(data);
            return;
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
            if(size==0){
                tail=null;
                current=null; //sonradan eklenedi
            }
            else{
                if(current!=null)
                    if(h.equals(current)){
                    next();
                    }
                tail.setNext(h.getNext());
                h.getNext().setPrev(tail);
                //current=tail.getNext(); //sonradan eklenedi emin değilim
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
                if(current!=null)
                    if(current.equals(t)){
                        next();
                    }
                tail=tail.getPrev();
                
            }
            else if(size==0){
                tail=null;
                current=null; //sonradan eklenedi
            }
            else{
                tail.getPrev().setNext(tail.getNext());
                tail.getNext().setPrev(tail.getPrev());
                if(current!=null)
                    if(current.equals(t)){
                        next();
                    }
                tail=tail.getPrev();
            }
            return t.getData();
        }
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if(index>=size||index<0){
            throw new IndexOutOfBoundsException();
        }
        else{
            if(isEmpty()){return null;}
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
            current=tail.getNext();
            return current.getData();
        }
    }

    @Override
    public T last() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            current=tail;
            return current.getData();
        }
    }

    @Override
    public boolean remove(T data) {
        if(isEmpty()){
            return false;
        }
        Node<T> h= tail.getNext();
        if(data.equals(tail.getData())){
            removeLast();
            return true;
        }
        else if(data.equals(tail.getNext().getData())){
            removeFirst();
            return true;
        }
        else{
            while(true){
                h=h.getNext();
                if(h.getData().equals(data)){
                    h.getPrev().setNext(h.getNext());
                    h.getNext().setPrev(h.getPrev());
                    size--;
                    if(current!=null)
                        if(h.equals(current)){
                            next();
                        }
                    return true;}
                    if(h.equals(tail)){break;}
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
       if(current==null){
            current=tail.getNext();
            return current.getData();}
       else{
            return current.getData();
       }
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
        do{
            sb.append(h.toString()).append(" ");
            h=h.getNext();
        }while(!h.equals(tail.getNext()));
        return sb.toString();
    }
 
}

/*
 * Teacher while i was testing my code i found that if there is one music in list and if we remove it while it palys, it still plays. but lis is empty. 
 * I think it is about music player class behavior, is that a bug
 */
