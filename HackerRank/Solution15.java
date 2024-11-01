import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}
public class Solution15{
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        while (!s.hasNextLine()) {
            String line=s.nextLine();
            for (int i = 0; i < 3; i++) {
                int index=line.indexOf(".");
                if(index==-1){
                    System.out.println("false");
                    break;
                }
                else{
                    String n=line.substring(0, index);
                    try {
                        Integer.parseInt(n);
                    } catch (Exception e) {
                        System.out.println("false");
                        break;
                    }
                }
                System.out.println("true");
            }
        }
        
    }
}
//Write your code here