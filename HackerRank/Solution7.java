import java.io.*;
import java.util.*;

public class Solution7 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s= new Scanner(System.in);
        for (int i = 1; ; i++) {
            try{
            String st=s.nextLine();
            System.out.println(i+" "+st);
            if(st.endsWith("end-of-file"))
                break;
            }
            catch(Exception e){
                break;
            }
        }
        s.close();;
    }
}
