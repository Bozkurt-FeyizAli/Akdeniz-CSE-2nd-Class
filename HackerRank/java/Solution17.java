import java.io.*;
import java.util.*;

public class Solution17 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s= new Scanner(System.in);
        String word=s.nextLine();
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)!=word.charAt(word.length()-1-i)){
                System.out.println("No");
                return;
            }
                
        }
        System.out.println("Yes");
    }
}