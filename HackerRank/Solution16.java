import java.io.*;
import java.util.*;


public class Solution16 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s= new Scanner(System.in);
        String word=s.nextLine();
        int l=s.nextInt();
        
        TreeSet<String> list= new TreeSet<>();
        for (int i = 0; i <= word.length() - l; i++) {
            String subStr = word.substring(i, i + l);
            list.add(subStr);
        }
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}