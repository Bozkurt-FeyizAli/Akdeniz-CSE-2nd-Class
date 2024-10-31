import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s= new Scanner(System.in);
        int t=s.nextInt();
        
        for (int i = 0; ; i++) {
            if(!s.hasNext())
                break;
            int a=s.nextInt();
            int b=s.nextInt();
            int n=s.nextInt();
            int result=a;
        for (int j = 0; j <n; j++) {
                result+=Math.pow(2, j)*b;
                System.out.print(result+" ");
        }
        System.out.println();
        }
    }
}
