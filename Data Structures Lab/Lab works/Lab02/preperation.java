public class preperation{
public static void main(String[] args) {

    int[] scoreBoard=new int[12];
    for (int i = scoreBoard.length-1; i>=0; i--) {
        scoreBoard[scoreBoard.length-i-1]=i*i;
    }
    // for (int i : scoreBoard) {
    //     System.out.println(i);
    // }
    addScore(12, scoreBoard);
    for (int i : scoreBoard) {
        System.out.println(i);
    }

    throwS(16, scoreBoard);
    for (int i : scoreBoard) {
        System.out.println(i);
    }
    
}
    //benim yol
    public static void addScore(int score, int[] scoreBoard){
        if(score>scoreBoard[scoreBoard.length-1]){
            scoreBoard[scoreBoard.length-1]=score;
        for (int i = scoreBoard.length-1; i>=1; i--) {
            if(scoreBoard[i]>scoreBoard[i-1]){
                int s=scoreBoard[i-1];
                scoreBoard[i-1]=scoreBoard[i];
                scoreBoard[i]=s;
            }
        }
    }
    return;
    }

    public static void throwS(int score, int[] scoreBoard){
        boolean tr=false;
        if(scoreBoard[scoreBoard.length-1]==score)
            scoreBoard[scoreBoard.length-1]=0;
        else{
            for (int i = 0; i < scoreBoard.length-1; i++) {
                if(scoreBoard[i]<=score&&tr==false){
                    scoreBoard[i]=scoreBoard[i+1];
                    scoreBoard[i+1]=0;
                }
                }
                
            }
        }
    


    // kitapta obje atıyor ben sayı
    public static void sabahkiders(int score, int[] scoreBoard){
        if(scoreBoard.length<scoreBoard.length|| score>scoreBoard[scoreBoard.length-1]){
            if(scoreBoard.length<=scoreBoard.length){
                int j=scoreBoard[scoreBoard.length-1];
                while(j>0&&scoreBoard[j-1]<score){
                    scoreBoard[j]=scoreBoard[j-1];
                    j--;
                }
                scoreBoard[j]=score;
            }
        }
    return;
    }
}

class SinglyLinkedList<E>{
    private Node<E> head=null;
    private Node<E> tail=null;
    int size=0;
    public SinglyLinkedList(){
        head=null;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if(isEmpty()) return null;
        return head.getElement();
    }
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }
    public void addFirst(E e){
            head= new Node<>(e, head);
            if(size==0)
                tail=head;
            size++;
    }
    public void addLast(E e){
            Node<E> newest= new Node<>(e, head);
            if(size==0)
                head=newest;
            else{
                tail.setNext(newest);
            }
            tail=newest;
            size++;
    }
    public void addToIndex(E e, int index){
        if(index>0){
        if(size()==0){
            addFirst(e);
            return;
        }
        else if(index>size){
            return;
        }
        else{
            Node<E> newNode=new Node<>(e, head);
            Node<E> current=head;
            for (int i = 1; i < index-1; i++) {
                current=current.next;
                }
                newNode.next=current.next;
                current.next=newNode;
            }
        }
    }

    public boolean search(E e){
        Node<E> n=head;
        while (head.next!=null) {
            if(n==e)
                return true;  
        }
        return false;
    }

    public void printList(){
        Node<E> n=head;
        while (head.next!=null) {
            System.out.println(n.element);  
        }
    }

    public E deleteHead(){
        Node<E> n=head;
        head=head.next;
        return n.element;
    }

    public E deleteTail(){
        Node<E> n=tail;
        Node<E> h=head;
        for (int i = 0; i < size; i++) {
            if(i==size()-1){
                tail=n;
            }
            h=h.next;

        }
        return tail.element;
    }
    

}

class Node<E>{
    E element;
    Node<E> next;
    Node<E> before;
    public Node(E e, Node<E> n){
        element=e;
        next=n;
    }
    public Node(E e, Node<E> b,Node<E> n ){
        element=e;
        next=n;
        before=b;
    }
    public E getElement() {
        return element;
    }
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }
    public void setElement(E element) {
        this.element = element;
    }
    public Node<E> getBefore() {
        return before;
    }
    public void setBefore(Node<E> before) {
        this.before = before;
    }
}


class DoublyLinkedList<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size;
    public DoublyLinkedList(){
        head=null;
        tail=null;
        size=0;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public int size(){
        return size;
    }

    public void insertAtBeginning(E e){
        if(isEmpty()){head=new Node<>(e, null, null); return;}
        Node<E> n= new Node<>(e, head, null);
        head.before=n;
    }

    public void insertAtEnd(E e){
        if(isEmpty()){insertAtBeginning(e);}
        else{
            Node<E> n= new Node<>(e, tail, null);
            tail.next=n;
        }
    }

    public void insertAtPosition(E e, int position){
        Node<E> n= new Node<>(e, null, null);
        Node<E> h= head;
        for (int i = 0; i < position-1; i++) {
            h=h.next;
        }
        h.next.before=n;
        n.next=h.next;
        h.next=n;
        n.before=h;
    }

    public E deleteAtBeginning(){
        if(isEmpty()){return null;}
        Node<E> h=head;
        if(size()==1){head=null; return h.element;}
        else{
            head=head.next;
            head.next.before=null;
            return h.element;
        }
    }
    public E deleteAtEnd(){
        if(isEmpty()){return null;}
        Node<E> h=head;
        if(size()==1){tail=null; return tail.element;}
        else{
            Node<E> t=tail;
            while(h.next!=tail){
                tail.before.next=h;
                h.next=null;
                
            }
            return t.element;
        }
    }
    public E deleteAtPosition(int position){
        if(position>size){return null;}
        Node<E> h=head;
        if(position==1){head=null;return h.element;}
        if(position==size()){
            Node<E> t=tail;
            t.before.next=null;
            tail=tail.before;
            return t.element;
        }
        else{
            for (int i = 0; i < position; i++) {
                h=h.next;
            }
            h.before.next=h.next;
            h.next.before=h.before.next;
            return h.element;
        }
    }

    public boolean search(E e){
        if(size()==0){return false;}
        else{
            Node<E> h=head;
        while(h.next!=null){
            if(h.element==e){return true;}
            h=h.next;
        }
        return false;
    }
    }
    public void printList(){
        Node<E> n=head;
        while (head.next!=null) {
            System.out.println(n.element);  
        }
    }
    
    public void reverse(){
        DoublyLinkedList<E> reverse= new DoublyLinkedList<>();
        Node<E> h= tail;
        while(h.before!=null){
            reverse.insertAtBeginning(h.element);
            h=h.next;
        }
    }
}


/**
 *  ShouldRemoveFirstFromDLL  Should removeFirst from DLL (2 failures)
             	java.lang.AssertionError: last should return 2 expected:<2> but was:<null>
             	java.lang.reflect.InvocationTargetException: <no message>  
    ShouldAddFirstToDLL  Should addFirst to DLL (1 failure)
             	java.lang.AssertionError: last should return 1 expected:<1> but was:<null>
    ShouldRemoveLastDLL  Should removeFirst from DLL (1 failure)
             	java.lang.AssertionError: last should return 1 expected:<1> but was:<null>
    ShouldAddLastToDLL  Should addLast to DLL (1 failure)
             	java.lang.AssertionError: last should return 1 expected:<1> but was:<null>
 */