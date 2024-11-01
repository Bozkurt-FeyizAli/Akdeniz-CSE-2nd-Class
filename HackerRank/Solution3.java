import java.io.*;
import java.util.*;

public class Solution3 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String[][] arr= new String[3][2];
        Scanner s= new Scanner(System.in);
        for (int index = 0; index <3; index++) {
            arr[index][0]=s.next();
            arr[index][1]=s.next();
        }
        System.out.println("================================");
         for (int index = 0; index <3; index++) {
            System.out.print(arr[index][0]);
            for (int i = 0; i < 15-arr[index][0].length(); i++) {
                System.out.print(" ");
            }
            if(arr[index][1].length()<2)  
                System.out.print("00"+arr[index][1]);
            else if(arr[index][1].length()<3)  
                System.out.print("0"+arr[index][1]);
            else 
                System.out.print(arr[index][1]);
                System.out.println();
         }
         System.out.println("================================");
    }
}
