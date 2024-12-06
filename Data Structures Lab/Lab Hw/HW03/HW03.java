import java.io.*;
import java.util.*;

public class HW03 {
    public static void main(String[] args) {
         File f = new File("./test.html");
        try (Scanner reader = new Scanner(f)) {
            StringBuilder content = new StringBuilder();
            while (reader.hasNextLine()) {
                content.append(reader.nextLine()).append(System.lineSeparator());
            }
            String fileContent = content.toString();
            
            System.out.println(isHTMLMatching(fileContent));
        } catch (Exception e) {
            System.out.println(e);
        } 

        ArrayQueue<String> queue = new ArrayQueue<>(15);

        // Test: Kuyruğa eleman ekleme
        System.out.println("Kuyruğa eleman ekleniyor...");
        queue.enqueue("Birinci");
        queue.enqueue("İkinci");
        queue.enqueue("Üçüncü");
        System.out.println("Kuyruk: " + queue);

        // Test: Kuyruğun ilk elemanını görüntüleme (çıkarmadan)
        System.out.println("\nKuyruğun ilk elemanı: " + queue.first());

        // Test: Kuyruğun ilk elemanını çıkarma
        System.out.println("\nKuyruğun ilk elemanı çıkarılıyor: " + queue.dequeue());
        System.out.println("\nKuyruğun ilk elemanı: " + queue.first());
        System.out.println("Kuyruk: " + queue);

        // Test: Kuyruk boş mu kontrolü
        System.out.println("\nKuyruk boş mu? " + queue.isEmpty());

        // Test: Kuyruğun boyutunu öğrenme
        System.out.println("Kuyruğun boyutu: " + queue.size());

        // Tüm elemanları çıkarma
        System.out.println("\nKuyruktaki tüm elemanlar çıkarılıyor...");
        while (!queue.isEmpty()) {
            System.out.println("Çıkarılan eleman: " + queue.dequeue());
        }
        System.out.println("Kuyruk boş mu? " + queue.isEmpty());

        System.out.println("=== ArrayStack Test ===");
        IStack<Integer> arrayStack = new ArrayStack<>(5); // Kapasitesi 5 olan bir ArrayStack

        // Eleman ekleme
        System.out.println("Stack'e eleman ekleniyor: 10, 20, 30");
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        System.out.println("Stack durumu: " + arrayStack);

        // Top eleman kontrolü
        System.out.println("Stack'in en üst elemanı: " + arrayStack.top());

        // Eleman çıkarma
        System.out.println("Stack'ten eleman çıkarılıyor: " + arrayStack.pop());
        System.out.println("Stack durumu: " + arrayStack);

        // Stack dolu mu kontrolü
        System.out.println("Stack dolu mu? " + (arrayStack.size() == 5));

        // Tüm elemanları çıkarma
        System.out.println("Tüm elemanlar çıkarılıyor...");
        while (!arrayStack.isEmpty()) {
            System.out.println("Çıkarılan eleman: " + arrayStack.pop());
        }
        System.out.println("Stack boş mu? " + arrayStack.isEmpty());

        System.out.println("\n=== LinkedStack Test ===");
        IStack<String> linkedStack = new ArrayStack<>(15);

        // Eleman ekleme
        System.out.println("Stack'e eleman ekleniyor: A, B, C");
        linkedStack.push("A");
        linkedStack.push("B");
        linkedStack.push("C");
        System.out.println("Stack durumu: " + linkedStack);

        // Top eleman kontrolü
        System.out.println("Stack'in en üst elemanı: " + linkedStack.top());

        // Eleman çıkarma
        System.out.println("Stack'ten eleman çıkarılıyor: " + linkedStack.pop());
        System.out.println("Stack durumu: " + linkedStack);

        // Eleman ekleme ve çıkarma kombinasyonu
        linkedStack.push("D");
        System.out.println("Stack'e eleman ekleniyor: D");
        System.out.println("Stack durumu: " + linkedStack);

        // Tüm elemanları çıkarma
        System.out.println("Tüm elemanlar çıkarılıyor...");
        while (!linkedStack.isEmpty()) {
            System.out.println("Çıkarılan eleman: " + linkedStack.pop());
            System.out.println("Stack durumu: " + linkedStack);

        }
        System.out.println("Stack boş mu? " + linkedStack.isEmpty());

        System.out.println(evaluate("(15+5)*3"));
        System.out.println(reverse("abcd"));


        System.out.println(evaluate("3 + 5"));           // 8
System.out.println(evaluate("(1 + 2) * 3"));     // 9
System.out.println(evaluate("10 / (2 + 3)"));    // 2
System.out.println(evaluate("100 + 2 * 6"));     // 112
System.out.println(evaluate("(4 + 2) * (3 - 1)")); // 12
System.out.println(evaluate(""));               // 0 veya hata beklenmeli
System.out.println(evaluate("5 + )"));  
        
    }

    public static boolean isMatching(String expression) {
            /*
         * Given a string containing parentheses and other characters,
         *  write a function that determines whether the parentheses
         *  in the string are balanced. A string is said to have balanced
         *  parentheses if every opening parenthesis ((, {, [) has a
         *  corresponding closing parenthesis (), }, ]), and the pairs
         *  are properly nested.
         */
        // Your code here..
        String open="({[";
        String close=")}]";
        char[] letters=expression.toCharArray();
        LinkedStack<Character> parantez=new LinkedStack<>();
        for (char c : letters) {
            if(open.indexOf(c)!=-1)
                parantez.push(c);
            else if(close.indexOf(c)!=-1){
                if(parantez.isEmpty())
                    return false;
                int i=close.indexOf(c);
                if(open.charAt(i)==parantez.top())
                    parantez.pop();
            }
        } 
        return parantez.isEmpty();
        
    }

    public static String reverse(String str) {
            /*
         * Write a function that reverses a given string using a stack.
         *  In this problem, you will leverage the Last-In-First-Out (LIFO)
         *  property of a stack to reverse the order of characters in a string.
         */
        // Your code here..
        LinkedStack<Character> letters= new LinkedStack<>();
        for (char c : str.toCharArray()) {
            letters.push(c);
        }
        StringBuilder result=new StringBuilder();
        while (!letters.isEmpty()) {
            result.append(letters.pop());
        }
        return result.toString();
    }

    public static boolean isHTMLMatching(String html) {
            /*
         * In HTML, every opening tag (like <div>) must have a corresponding closing
         *  tag (like </div>). Write a function to check whether all the HTML tags in
         *  a given string are properly matched. A properly matched HTML string has balanced
         *  and correctly nested tags.
         */
        // Your code here..
        LinkedStack<String> tags= new LinkedStack<>();
        int start=html.indexOf('<');
        int finish=-1;
        while(start!=-1){
            finish=html.indexOf(start, '>');
            if(finish==-1)
                return false;
            if(html.charAt(start+1)!='/'){
                tags.push("/"+html.substring(start+1, finish));
            }
            else if(html.charAt(start+1)=='/'){
                if(tags.top()==html.substring(start, finish));
                    tags.pop();
            }
            html=html.substring(finish+1);
            start=html.indexOf('<');
        }
        return tags.isEmpty();


    }

    public static int evaluate(String expression) {
            /*
         * Write a function to evaluate a given arithmetic expression containing integers,
         *  parentheses, and operators. The function should correctly follow the order of
         *  operations (precedence) and handle parentheses appropriately.
         *  Your task is to complete the evaluate(String expression) method
         *  which returns the result of the expression.
         */
        // Your code here..

        ArrayStack<Integer> valStk = new ArrayStack<>();
        ArrayStack<Character> opStk = new ArrayStack<>();
        expression+=" $";

        for (int i = 0; i < expression.length(); i++) {
            char c= expression.charAt(i);
            if (c==' ')
                continue;
            if (Character.isDigit(c)) {
                String result="";
                while (i< expression.length()&&Character.isDigit(expression.charAt(i)))
                    result+=expression.charAt(i++);
                valStk.push(Integer.parseInt(result));
                i--; 
            } 
            else if (c == ')') {
                while (!opStk.isEmpty() && opStk.top() != '(') {
                    doOp(valStk, opStk);
                }
                if (!opStk.isEmpty() && opStk.top() == '(') {
                    opStk.pop(); // Remove '('
                }
            }
            else if (isOperator(c)||c=='$') {
                repeatOps(c, valStk, opStk);
                opStk.push(c); 
            }
        }
        repeatOps('$', valStk, opStk);
        return valStk.pop();
    }

    public static void repeatOps(char refOp, ArrayStack<Integer> valStk, ArrayStack<Character> opStk) {
        while (valStk.size()>1&&!opStk.isEmpty()&&precedance(refOp)<=precedance(opStk.top())) {
            if (opStk.top() == '(') {
                opStk.pop();
                break;
            }
            doOp(valStk, opStk);
        }
    }

    public static void doOp(ArrayStack<Integer> valStk, ArrayStack<Character> opStk) {
        int x= valStk.pop();
        int y= valStk.pop();
        char op= opStk.pop();
        valStk.push(applyOp(op, y, x)); 
    }

       
    public static int applyOp(char op, int b, int a){
        switch(op){
            case('-'):
                return b-a;
            case('+'):
                return b+a;
            case('*'):
                return b*a;
            case('/'):
                if(a==0)
                    throw new ArithmeticException("you can not divide by 0");
                return b/a;
            default: return 0;
        }
    }

    public static boolean isOperator(char c){
        switch(c){
            case '-':
            return true;
            case '+':
            return true;
            case '*':
            return true;
            case '/':
            return true;
            case '(':
            return true;
            case ')':
            return true;
            default: return false;
        }
    }

    public static int precedance(char op){
        switch(op){
            case '-':
                return 1;
            case '+':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default: return 0;
        }
    }

}

interface List <E> {
    int size();
    boolean isEmpty();
}

interface IStack <E> extends List <E> {
    void push(E e);
    E top();
    E pop();
}

interface IQueue <E> extends List<E> {
    void enqueue(E e);
    E dequeue();
    E first();
}

class ArrayStack <E> implements IStack <E> {

        /*
     * Data Fields: necessary data fields
     * Constuctors: ArrayStack(): default capacity = 1000, ArrayStack(int capacity)
     * Methods: Required methods, toString
     */
    private E[] data;
    private int size;
    public ArrayStack(int c){
        data= (E[])new Object[c];
        size=0;
    }
    public ArrayStack(){
        this(1000);
    }

    public E[] getData() {
         return data;
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
    public void push(E e) {
        if(size==-1)
            size=0;
        if(size<data.length){
            data[size++]=e;
        }
    }

    @Override
    public E top() {
        if(size==-1)
            size=0;
        if(isEmpty())
            return null;
        return data[size-1];
    }

    @Override
    public E pop() {
        E e=data[--size];
        data[size]=null;
        if(size==-1)
            size=0;
        return e;
    }

     // Your code here..
     @Override
     public String toString() {
         String result="";
         for (E e : data) {
            result+=e+", ";
         }
         return result;
     }
}

class Node <E> {
    private E data;
    private Node<E> next;

    public Node(E e, Node<E> n){
        data=e;
        next=n;
    }
    /*
     * Data Fields: element, next
     * Constuctor: Node(element, next)
     * Methods: getElement, getNext, setNext, toString
     */
    public E getData() {
        return data;
    }
    public Node<E> getNext() {
        return next;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return data.toString()+", "+next;
    }

     // Your code here..
    
}

class LinkedStack <E> implements IStack <E> {
        /*
     * Data Fields: necessary data fields
     * Constuctor: LinkedStack()
     * Methods: Required methods, toString
     */

     // Your code here..
    private Node<E> top = null;
    private int size;
    public LinkedStack(){
        top=null;
        size=0;
    }

    public Node<E> getTop() {
        return top;
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
    public void push(E e) {
        Node<E> node=new Node<>(e, top);
        top=node;
        size++;
    }

    @Override
    public E top() {
        if(top==null)
            return null;
        return top.getData();
    }

    @Override
    public E pop() {
        if(isEmpty())
            return null;
        E d=top.getData();
        top=top.getNext();
        size--;
        return d;
    }

    @Override
    public String toString() {
        if(top==null)
            return "stack is empty!";
        return top.toString();
    }
}


class ArrayQueue <E> implements IQueue <E> {
    /*
     * Data Fields: necessary data fields
     * Constuctors: ArrayQueue(): default capacity = 1000, ArrayQueue(int capacity)
     * Methods: Required methods, toString
     */

     // Your code here..
    private E[] data;
    int size;

    public ArrayQueue(int c){
        size=0;
        data= (E[])new Object[c];
    }
    public ArrayQueue(){
        this(1000);
    }

    public E[] getData() {
        return data;
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
        if(size<data.length){
            data[size++]=e;
        }
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            return null;
        E first=data[0];
        for (int i = 0; i < size-1; i++) {
            data[i]=data[i+1];
        }
        data[--size] = null;
        return first;
    }

    @Override
    public E first() {
        if(isEmpty())
            return null;
        return data[0];
    }

    @Override
    public String toString() {
        String result="";
        for (E e : data) {
            result+=" "+data+",";
        }
        return result;
    }

}