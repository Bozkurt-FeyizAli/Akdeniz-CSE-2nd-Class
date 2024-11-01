import java.io.*;
import java.util.*;

public class Solution13 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s= new Scanner(System.in);
        String a=s.nextLine();
        String b=s.nextLine();
        System.out.println(a.length()+b.length());
        
        System.out.println((a.compareTo(b)>0)? "Yes": "No" );
        System.out.println(Character.toUpperCase(a.charAt(0))+a.substring(1)+Character.toUpperCase(b.charAt(0))+b.substring(1));
    }
}