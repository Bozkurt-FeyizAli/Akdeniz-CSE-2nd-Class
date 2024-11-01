import java.util.Scanner;
import java.util.TreeMap;

public class Solution18 {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String a=s.nextLine().toLowerCase();
        String b=s.nextLine().toLowerCase();
        TreeMap<Character, Integer> fi=s(a);
        TreeMap<Character, Integer> se=s(b);
        if(fi.size()!=se.size()){
            System.out.println("Not Anagrams");
            return;
        }
        for (var varr : fi.entrySet()) {
            try{
            if(!se.containsKey(varr.getKey())){
                System.out.println("Not Anagrams");
                return; 
            }
            if(varr.getValue()!=se.get(varr.getKey())){
                System.out.println("Not Anagrams");
                return;   
            }
        }catch(Exception e){
            System.out.println("Not Anagrams");
                return;   
        }
        }

        System.out.println("Anagrams");

    }


    public static TreeMap<Character, Integer> s(String s){
        TreeMap<Character, Integer> result= new TreeMap<>();
        for (char c : s.toCharArray()) {
            if(!result.containsKey(c)){
                result.put(c, 0);
            }
            else{
                result.put(c, result.get(c)+1);
            }
        }

        return result;
    }
    
}


