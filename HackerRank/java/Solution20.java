import java.io.*;
import java.util.*;

public class Solution20 {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String ss= s.nextLine();
        ss.replace(" ", "  ");
        String[] words = ss.split("[ !,?._'@]+");
        System.out.println(words.length);
        for (String string : words) {
            System.out.println(string);
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}