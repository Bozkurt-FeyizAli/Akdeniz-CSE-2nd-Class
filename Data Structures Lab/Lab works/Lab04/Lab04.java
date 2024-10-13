
public class Lab04 {
    public static void main(String[] args) {
        // int[] neww ={0,0,0,0,0,0};
        // System.out.println(betterFibonacci(5, neww));
        // for (int i : neww) {
        //     System.out.println(i);
        // }
        // System.out.println(subsetSum(new int[]{1, 2, 3, 9}, 4, 14));
        // SinglyLinkedList<Integer> s= new SinglyLinkedList<>();
        // s.addLast(3);
        // s.addLast(2);
        // s.addLast(1);
        // System.out.println(s.toString());
        // s.reverse(s.head );
        // System.out.println(s);
        // generatePermutations("abc", "");
        // System.out.println(factorial(32));
        
    }

    /*
     * 1. Write a recursive method 'static int factorial(int n)' 
     * that returns the factorial of given n
     */
    public static int factorial(int n){
        if(n<0)
            throw new IllegalArgumentException();
        if(n==0)
            return 1;
        else return n*factorial(n-1);
    }
    /*
     * 2. Write a recursive method 'static double power(double base, int exponent)'
     *  to compute the result of raising base to the power of exponent
     */

     public static double power(double base, int exponent){
        if(exponent<0)
            return 1/power(base, 0-exponent);
        if(exponent==0)
            return 1;
        if(exponent%2==1){
            double d=power(base, exponent/2);
            return base*d*d;
        }
        else{
            double d=power(base, exponent/2);
            return d*d;
        }
     }
     /*
     * 3. Write a recursive method 'static boolean isPalindrome(String s)' 
     *  that checks if a given string is palindrome
     */
     public static boolean isPalindrome(String s){
        int length =s.length();
        if(length<2)
            return true;
        if(s.indexOf(0)==s.indexOf(length-1))
            return false;
        else return isPalindrome(s.substring(1, length-1));
     }
     /*
     * 4. Write a recursive method 
     * 'static int binarySearch(int[] arr, int target, int low, int high)'
     *  to find the index of target in a sorted array
     */
     public static int binarySearch(int[] arr, int target, int low, int high){
        if(low>high)
            return -1;
        int mid=(low+high)/2;
        if(arr[mid]==target)
            return mid;
        else if(arr[mid]>target)
            return binarySearch(arr, target, low, mid-1);
        else 
            return binarySearch(arr, target, mid+1, high);
     }
     /*
     * 5.1. Write a recursive method 'static int fibonacci(int n)'
     *  that returns the nth fibonacci number
     *  fibonacci(5) should return 3: sequence(0, 1, 1, 2, 3, 5)
     */
     public static int fibonacci(int n){
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        else return fibonacci(n-1)+fibonacci(n-2);
     }
     /*
     * 5.2. Write a recursive method 'static int betterFibonacci(int n, int[] sequence)'
     *  that returns the nth fibonacci number
     *  betterFibonacci(5) should return 3: sequence(0, 1, 1, 2, 3, 5)
     */
     public static int betterFibonacci(int n, int[] sequence){
        if(n<2){
            sequence[n]=n;
            return n;
        }
        else{
            if(sequence[n]==0)
                sequence[n]=betterFibonacci(n-1, sequence)+betterFibonacci(n-2, sequence);
            return sequence[n];
        }
     }
     /*
     * 5.3. Investigate the performance difference between 5.1 and 5.2
     */

    /*
     * 6. Write a recursive method 'static void generatePermutations(String str, string prefix)'
     *  that prints all permutations
     * geneatePermutations("abc", "") should print abc, acb, bac, bca, cab, cba
     */
    public static void generatePermutations(String str, String prefix){
        if (str.length() == 0) {
            System.out.println(prefix); 
        }
        for (int i = 0; i < str.length(); i++) {
            String sub = str.substring(0, i) + str.substring(i+1);
            generatePermutations(sub, prefix+str.charAt(i));
        }
    }
    public static void swap(char[] array, int i, int j) {
        char temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }


    /*
     * 7. Write a recursive method 'static boolean subsetSum(int[] array, int n, int sum)'
     *  that determines if there exists a subset of the array  that adds up to sum
     * subsetSum(new int[]{1, 2, 3, 4}, 4, 5) should return true because 1 + 4 = 5
     */
    public static boolean subsetSum(int[] array, int n, int sum){
        // if(n==0)
        // return false;
        // int total=0;
        // for (int j = 0; j < n; j++) {
        //     total+=array[j];
        // }
        // if(total==sum)
        //     return true;
        // else return subsetSum(array, n-1, sum);

        if(n==0)
        return false;
    int total=0;
    for (int i = 0; i < n; i++) {
        total=array[i];
        for (int j = i; j < n; j++) {
            total+=array[j];
            if(total==sum)
                return true;
        }
    }
    return false;
    // int t=0;
    // for (int i = 0; i < n; i++) {
    //     t=array[i];
    //     if(t==sum)
    //         return true;
    //     for (int j = 0; j < n; j++) {
    //         t+=array[j];
    //         if(t==sum)
    //             return true;
    //     }
    // }
    // return subsetSum(array, n-1, sum-array[array.length-n]);
    // int total=0;
    // for (int i = 1; i < n; i++) {
    //     total+=array[i];
    //     if(total==sum)
    //         return true;
    // }       
    // return subsetSum(array, n, sum-total);
        
    }

    /*
     * 8. Write a recursive method List<List<Integer>> getSubsequences(int[] array, int n, List<Integer> current)
     *  that returns all subsequences of an array.
     * getSubsequences(new int[]{1, 2, 3}, 0, new ArrayList<>()) should return list similar to
     * [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
     */
    // public static List<List<Integer>> getSubsequences(int[] array, int n, List<Integer> current){
    //     return null;
    // }
     /*
      * 9. Implement a basic singly linked list
      * 9.1. Implement a Node class
      * 9.1.1 Node class with only public data and next fields
      * 9.1.2. should have a toString() method to test your code
      * 9.2. Implement a SinglyLinkedList class
      * 9.2.1. SinglyLinkedList class should only have a public head field
      * 9.2.2. void addLast(T data)
      * 9.2.3. Write a recursive method Node<T> reverse(Node<T> node)
      * which reverses a linked list with its given head
      * 9.2.4. should have a toString() method to test your code
      */
        
}

class Node<T>{
    T data;
    Node<T> next;
   
    public Node(T data, Node<T> next){
        this.data=data;
        this.next=next;
      
    }
    public Node<T> getNext() {
        return next;
    }
    public T getData() {
        return data;
    }
    public void setNext(Node<T> n){
        this.next=n;
    }


    @Override
    public String toString() {
            return data.toString();
    }
}
class SinglyLinkedList<T>{
    Node<T> head=null;
    int size=0;
    public SinglyLinkedList(){
        head=null;
        size=0;
    }

    public void addLast(T data){
        Node<T> newNode=new Node<>(data, null);
        if(size==0){
            head=newNode;
        }
        else{
            Node<T> h=head;
            while(h.getNext()!=null){
                h=h.next;
            }
            h.next=newNode;
        }
        size++;
    }

    public void reverse(Node<T> node){
        Node<T> h=head;
        if(node==null||node.next==null){
            head=node;
            return;
        }
        else{
            reverse(node.next);
            node.next.setNext(node);
            node.next=null;
        }
     

    }

    @Override
    public String toString() {
        Node<T> h=head;
        String s="";
        while(h!=null){
            s+=h.toString()+"\n";
            h=h.next;
        }
        return s;
    }

}
