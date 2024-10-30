import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        if(N%2==1)
            System.out.println("Weird");
        else if(N%2==0&&N>=2&&N<=5)
            System.out.println("Not Weird");
        else if(N%2==0&&N>=6&&N<=20)
            System.out.println("Weird");
        else if(N>=20)
            System.out.println("Not Weird");

        bufferedReader.close();
    }
}


import java.io.*;
import java.util.*;

class Solution1 {

  //  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner s= new Scanner(System.in);
      //  int i=s.nextInt();
     //   double d=s.nextDouble();
      //  s.nextLine();
    //    String st=s.nextLine();
     //   System.out.println("String: "+st);
     //   System.out.println("Double: "+d);
      //  System.out.println("Int: "+i);
    //}
}
