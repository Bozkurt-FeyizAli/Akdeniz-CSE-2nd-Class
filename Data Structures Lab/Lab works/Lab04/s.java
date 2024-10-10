public class s {
 
    public static void main(String[] args) {
        // generatePermutations("abc", "");
        // System.out.println(factorial(5));
        //should print abc, acb, bac, bca, cab, cba
        System.out.println(subsetSum(new int[]{1, 2, 3, 9}, 4, 10));
    }

    /*
     * 1. Write a recursive method 'static int factorial(int n)' 
     * that returns the factorial of given n
     */
    public static int factorial(int n){
        if(n==0)
            return 1;
        return n*factorial(n-1);
    }
    /*
     * 2. Write a recursive method 'static double power(double base, int exponent)'
     *  to compute the result of raising base to the power of exponent
     */

     /*
     * 3. Write a recursive method 'static boolean isPalindrome(String s)' 
     *  that checks if a given string is palindrome
     */

     /*
     * 4. Write a recursive method 
     * 'static int binarySearch(int[] arr, int target, int low, int high)'
     *  to find the index of target in a sorted array
     */

     /*
     * 5.1. Write a recursive method 'static int fibonacci(int n)'
     *  that returns the nth fibonacci number
     *  fibonacci(5) should return 3: sequence(0, 1, 1, 2, 3, 5)
     */

     /*
     * 5.2. Write a recursive method 'static int betterFibonacci(int n, int[] sequence)'
     *  that returns the nth fibonacci number
     *  betterFibonacci(5) should return 3: sequence(0, 1, 1, 2, 3, 5)
     */

     /*
     * 5.3. Investigate the performance difference between 5.1 and 5.2
     */

    /*
     * 6. Write a recursive method 'static void generatePermutations(String str, string prefix)'
     *  that prints all permutations
     * geneatePermutations("abc", "") should print abc, acb, bac, bca, cab, cba
     */
    public static void generatePermutations(String str, String prefix){
        if(str.length()==prefix.length());
        for (int index = 0; index < str.length(); index++) {
           
        }
        generatePermutations(str.substring(0, str.length()-1), prefix);  
    }

/*
 * 7. Write a recursive method 'static boolean subsetSum(int[] array, int n, int sum)'
 *  that determines if there exists a subset of the array  that adds up to sum
 * subsetSum(new int[]{1, 2, 3, 4}, 4, 5) should return true because 1 + 4 = 5
 */

 public static boolean subsetSum(int[] array, int n, int sum){
    if(n==0)
        return false;
    // int total=0;
    // for (int i = 0; i < n; i++) {
    //     total=array[i];
    //     for (int j = i; j < n; j++) {
    //         total+=array[j];
    //         if(total==sum)
    //             return true;
    //     }
    // }
    //return false;
    int total=0;
    for (int i = 1; i < n; i++) {
        total+=array[i];
        if(total==sum)
            return true;
    }       
    return subsetSum(array, n, sum-total);
 }

/*
 * 8. Write a recursive method List<List<Integer>> getSubsequences(int[] array, int n, List<Integer> current)
 *  that returns all subsequences of an array.
 * getSubsequences(new int[]{1, 2, 3}, 0, new ArrayList<>()) should return list similar to
 * [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
 */

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
