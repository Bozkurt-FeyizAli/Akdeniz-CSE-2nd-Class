import java.io.*;
import java.util.*;

public class Solution8 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s= new Scanner(System.in);
        int h=s.nextInt();
        int b=s.nextInt();
        if(b<=0||h<=0)
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        else 
            System.out.println(b*h);
    }
}
