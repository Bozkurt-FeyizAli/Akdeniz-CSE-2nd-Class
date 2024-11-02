import java.util.*;

public class Solution12 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s= new Scanner(System.in);
        double d=s.nextDouble();
        String n=comaNumber(d);
        System.out.println("US: $"+n);
        System.out.println("India: Rs."+n);
        System.out.println("China: ￥"+n);
        System.out.println("France: "+n.substring(0, n.indexOf(','))
        +" "+n.substring(n.indexOf(',')+1)+" €");
        s.close();;
       }
       
       public static String comaNumber(double d){
           String s=Double.toString(d);
           int hane=s.substring(0, s.indexOf('.')).length();
           hane=(int)((hane/3))-1;
           int f=s.indexOf('.');
           for (int index = 1; index <= hane; index++) {
               s=s.substring(0, f-3)+","+s.substring(f-3);
               f=f-3;
           }
           return s;
       }
}