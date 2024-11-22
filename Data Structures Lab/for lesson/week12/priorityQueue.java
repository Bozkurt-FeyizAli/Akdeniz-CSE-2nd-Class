import java.security.InvalidParameterException;


public class priorityQueue{
    public static void main(String[] args) {
        
        
    }
}
interface INode<T> extends Comparable<Node<T>> {
    T getData();
    void setData(T data);
    Node<T> getNext();
    void setNext(Node<T> next);
}
class Node<T> implements INode<T>{
    private int priority;
    private T data;
    private Node<T> next;
    private Node<T> prev;

    public Node(T d, int priorit,  Node<T> p, Node<T> n){
        data=d;
        next=n;
        prev=p;
        priority=priorit;
    }
    public Node(T d,  Node<T> p, Node<T> n){
        data=d;
        next=n;
        prev=p;
        priority=0;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data=data;
    }

    @Override
    public Node<T> getNext() {
        return next;
    }

    @Override
    public void setNext(Node<T> next) {
        this.next=next;
    }
    public Node<T> getPrev() {
        return prev;
    }
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }
    @Override
    public String toString() {
        return " |"+data.toString()+", "+priority+"|" +next;
    }

    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    @Override
    public int compareTo(Node<T> o) {
        return Integer.compare(priority, o.getPriority());
    }
} 



interface ILinkedList<T> {
    void add(T item); // Bağlı listeye bir öğe ekle
    T remove(int index); // Belirli bir indeksteki öğeyi çıkar
    T get(int index); // Belirli bir indeksteki öğeyi al
    boolean isEmpty(); // Liste boş mu?
    int size(); // Listedeki eleman sayısı
}

class LinkedList<T> implements ILinkedList<T>{
    private final int maxSize=1000;
    private int size;
    private Node<T> head;
    private Node<T> tail;
    
    public LinkedList(){
        size=0;
        head=null;
        tail=null;
    }

    @Override
    public void add(T item) {
        Node<T> newNode= new Node<>(item, null, null);
        if(isEmpty()){
            head=newNode;
            tail=head;
        }
        else{
            if(size<maxSize){
            newNode.setNext(head);
            head.setPrev(newNode);
            head=newNode;
            }
            else{
                throw new IndexOutOfBoundsException();
            }
        }
        size++;
    }

    @Override
