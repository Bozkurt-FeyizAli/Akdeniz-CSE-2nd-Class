import java.util.ArrayList;
import java.util.Stack;

public class forMiddterm{
    public static void main(String[] args) {
        System.out.println(palindromiksayı(1211));
    }

    public static String reverse(int number, int i){
        String num=Integer.toString(number);
        if(number<0)
            return "-"+reverse(0-number, i);
        else if(num.length()/2==i&&num.length()%2!=0)
            return Character.toString(num.charAt(i));
        else if(num.length()/2==i)
            return "";
        else return Character.toString(num.charAt(num.length()-1-i))+ reverse(number, i+1)  + Character.toString(num.charAt(i));   
    }

    public static String betterNumReversse(int number){
        if(number<10)
            return Integer.toString(number);
        return Integer.toString(number%10)+betterNumReversse(number/10);
    }
    public static void betterNumReversse1(int number){
        if(number<10)
            System.out.println( Integer.toString(number));
        else{
        System.out.println(Integer.toString(number%10)) ;
        betterNumReversse1(number/10);
        }
    }

    public static ArrayList<Integer> findDublicate(int[] arr){
        ArrayList<Integer> result= new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]==arr[j])
                    result.add(arr[i]);
            }
        }
        return result;
    }

    public static boolean parantezKontrol(String s){
        Stack<Character> characters= new Stack<>();
        char[] c=s.toCharArray();
        String open="({[";
        String close=")}]";
        for (char d : c) {
            if(open.indexOf(d)!=-1)
                characters.add(d);
            else if(close.indexOf(d)!=-1)
            if(characters.isEmpty())
                return false;
            else if(open.indexOf(characters.peek())==close.indexOf(d))
                characters.pop();
        }


        return characters.isEmpty();
    }

    public static ArrayList<Integer> asalÇarpanlar(int num){
        ArrayList<Integer> result= new ArrayList<>();
        int i=2;
        while(num!=1){
            if(num%i!=0){
                i++;
                continue;
            }
            else{
                if(!result.contains(i))
                    result.add(i);
                num=num/i;
            }
        }
        return result;
    }

    public static boolean palindromiksayı(int i){
        int[] arr= new int[(int)Math.log10(i)+1];
        for (int j = 0; i!=0; j++) {
            arr[j]=i%10;
            i=i/10;
        }
        for (int j = 0; j < arr.length/2; j++) {
            if(arr[j]!=arr[arr.length-1-j])
                return false;
        }
        return true;
    }
}