import java.net.CacheRequest;
import java.util.Stack;

public class Lab05 {
    public static void main(String[] args) {

        
    }

    /*
     * You first need to implement bellow classes
     */


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
        ArrayStack<Character> parantezler= new ArrayStack<>(expression.length());
        for(int i=0; i<expression.length();i++){
            char index=expression.charAt(i);
            if(open.indexOf(index)!=-1)
                    parantezler.push(index);
            else if (close.indexOf(index)!=-1) { 
                if (parantezler.isEmpty( )) 
                    return false;
                if (close.indexOf(index)!=open.indexOf(parantezler.pop()))
                    return false;
            }
        }    
            
        
            // for(int j=0;j<close.length();j++){
            //     if(open.indexOf(index)==close.indexOf(close))
            //         parantezler.pop();
            // }
        
        return parantezler.isEmpty();
    }

    public static char zitParantez(char c){
        switch(c){
            case('}'):
                return '{';
            case(']'):
                return '[';
            case(')'):
                return '(';
            default: return 0;
        }
    }

    public static String reverse(String str) {  //tested
        /*
         * Write a function that reverses a given string using a stack.
         *  In this problem, you will leverage the Last-In-First-Out (LIFO)
         *  property of a stack to reverse the order of characters in a string.
         */
        // Your code here..
        ArrayStack<Character> kelimeHarfler= new ArrayStack<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            kelimeHarfler.push(str.charAt(i));
        }
        String result="";
        for (int i = 0; i < str.length(); i++) {
            result+=kelimeHarfler.pop();
        }
        return result;
    }

    public static boolean isHTMLMatching(String html) {
        /*
         * In HTML, every opening info (like <div>) must have a corresponding closing
         *  info (like </div>). Write a function to check whether all the HTML infos in
         *  a given string are properly matched. A properly matched HTML string has balanced
         *  and correctly nested infos.
         */
        // Your code here..

        ArrayStack<String> htmlMatch= new ArrayStack<>();
        int index=html.indexOf('<'); 
        while (index!= -1) {
            int k=html.indexOf('>', index+1); 
            if (k==-1){
                return false;
            }
            String info = html.substring(index+1, k);
            if (!info.startsWith("/")){
                 htmlMatch.push(info);
            }
            else { 
                if (html.isEmpty( )){
                    return false;
                } 
                if (!info.substring(1).equals(htmlMatch.pop())){
                    return false;
                } 

                index= html.indexOf('<', k+1); 
                }
            }
            return htmlMatch.isEmpty();
    }

    public static int evaluate(String expression) {
        /*
         * Write a function to evaluate a given arithmetic expression containing integers,
         *  parentheses, and operators. The function should correctly follow the order of
         *  operations (precedence) and handle parentheses appropriately.
         *  Your task is to complete the evaluate(String expression) method
         *  which returns the result of the expression.
         * 
         * You may also need following methods or any other:
         * boolean isOperator(char c): returns true if given character is an operator
         * int precedance(char op): returns the precedance of the character
         * int applyOp(char op, int b, int a): applys the operator on operands
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
            else if (isOperator(c)||c=='$') {
                repeatOps(c, valStk, opStk);
                opStk.push(c); 
            }
        }
        repeatOps('$', valStk, opStk);
        return valStk.pop();
    }

    public static void repeatOps(char refOp, ArrayStack<Integer> valStk, ArrayStack<Character> opStk) {
        while (valStk.size()>1&&precedance(refOp)<=precedance(opStk.top())) {
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
                    return b/a;
                default: return 0;
            }
        }

        public static boolean isOperator(char c){
            switch(c){
                case('-'):
                    return true;
                case('+'):
                    return true;
                case('*'):
                    return true;
                case('/'):
                    return true;
                default: return false;
            }
        }

        public static int precedance(char op){
            switch(op){
                case('-'):
                    return 1;
                case('+'):
                    return 1;
                case('*'):
                    return 2;
                case('/'):
                    return 2;
                // case('<'):
                //     return 1;
                // case('+'):
                //     return 1;
                // case('*'):
                //     return 2;
                // case('/'):
                //     return 2;
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
    private int size;
    private E[] stack;
    // private int capacity;
    private static final int defaultCapacity = 1000;

    public ArrayStack(int capacity){
        size=0;
        stack= (E[])new Object[capacity];
        // this.capacity=capacity;
    }
    public ArrayStack(){
        this(defaultCapacity);
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
        if(size!=stack.length){
            stack[size]=e;
            size++;
        }
    }

    @Override
    public E top() {
        if(isEmpty())
            return null;
        return stack[size-1];
    }

    @Override
    public E pop() {
        if(isEmpty())
            return null;
        E e=stack[size-1];
        stack[size-1]=null;
        size--;
        return e;
    }
    /*
     * Data Fields: necessary data fields
     * Constuctors: ArrayStack(): default capacity = 1000, ArrayStack(int capacity)
     * Methods: Required methods, toString
     */

     // Your code here..
}

class Node <E> {

    private E data;
    private Node<E> next;
    Node(E data, Node<E> next){
        this.data=data;
        this.next=next;
    }

    // public void setData(E data) {
    //     this.data = data;
    // }
    public void setNext(Node<E> next) {
        this.next = next;
    }
    public E getData() {
        return data;
    }
    public Node<E> getNext() {
        return next;
    }
    @Override
    public String toString() {
        return data.toString();
    }
    /*
     * Data Fields: data, next
     * Constuctor: Node(data, next)
     * Methods: getData, getNext, setNext, toString
     */

     // Your code here..
}

class LinkedStack <E> implements IStack <E> {

    private int size;
    private Node<E> top;

    public LinkedStack(){
        size=0;
        top=null;
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
        Node<E> node= new Node<E>(e, top);
        top=node;
        size++;
        // if(top==null){
        //     top=node;
        // }else{
        //     top.setNext(node);
        //     top=node;
        // }
        // size++;
    }

    @Override
    public E top() {
        if(isEmpty())
            return null;
        return top.getData();
    }

    @Override
    public E pop() {
        if(isEmpty())
            return null;
        else{
            E e=top.getData();
            top=top.getNext();
            size--;
            return e;
        }
    }

    @Override
    public String toString() {
        String result="";
        Node<E> t=top;
        while (t!=null) {
            result+=t.toString()+" ";
            t=t.getNext();
        }
        return result;
    }
    /*
     * Data Fields: necessary data fields
     * Constuctor: LinkedStack()
     * Methods: Required methods, toString
     */

     // Your code here..
}

class ArrayQueue <E> implements IQueue <E> {

    private static final int defaultCapacity = 1000;
    private int size;
    private E[] datas;

    public ArrayQueue(int capacity){
        size=0;
        datas= (E[])new Object[capacity];
    }
    public ArrayQueue(){
        this(defaultCapacity);
    }
    /*
     * Data Fields: necessary data fields
     * Constuctors: ArrayStack(): default capacity = 1000, ArrayStack(int capacity)
     * Methods: Required methods, toString
     */
    @Override
    public int size() {
       return size+1;
    }
    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public void enqueue(E e) {
        if(size+1==datas.length){
            return;
        }
        else{
            datas[size]=e;
            size++;
        }
    }
    @Override
    public E dequeue() {
        if(isEmpty())
            return null;
        else{
            E e= datas[size];
            datas[size]=null;
            size--;
            return e;
        }
    }
    @Override
    public E first() {
        if(size==0)
            return null;
        else{
            return datas[size];
        }
    }

    @Override
    public String toString() {
        String result="";
        for (int i = 0; i < size; i++) {
           result+=datas[i].toString()+" ";
        }
        return result;
    }

     // Your code here..
}

class LinkedQueue <E> implements IQueue <E> {
    private int size;
    private Node<E> first;
    private Node<E> last;
    private int capacity;

    private static final int defaultCapacity = 1000;
    public LinkedQueue(int capacity){
        size=0;
        first=null;
        last=null;
        this.capacity=capacity;
    }
    public LinkedQueue(){
        this(defaultCapacity);
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
        Node<E> newNode= new Node<E>(e, null);
        if(isEmpty()){
            first=newNode;
            last=newNode;
        }
        else{
            if(size+1==capacity){
                return;
            }
            else{
                last.setNext(first);
                last=newNode;
            }
        }
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            return null;
        }
        E e=last.getData();
        first=first.getNext();
        if(first==null){
            last=first;
        }
        size--;
        return e;
    }

    @Override
    public E first() {
        if(isEmpty())
            return null;
        return last.getData();
    }
    /*
     * Data Fields: necessary data fields
     * Constuctors: ArrayStack(): default capacity = 1000, ArrayStack(int capacity)
     * Methods: Required methods, toString
     */

     // Your code here..
     @Override
    public String toString() {
        String result="";
        Node<E> f=first;
        while (f.getNext()!=null) {
            result+=f.toString()+" ";
            f=f.getNext();
        }
        return result;
    }
}