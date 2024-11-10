import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class work{
    public static void main(String[] args) {
        
    }

    public static TreeMap<String, Integer> timesString(String fileName){
        TreeMap<String, Integer> result= new TreeMap<>();
        File file=new File(fileName);
        try{
        Scanner s= new Scanner(file);
        while (s.hasNext()) {
            String word=s.next();
            result.putIfAbsent(word, 0);
            if(result.containsKey(word)){
                result.put(word, result.get(word)+1);
            }
        }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static boolean sumOfTwoIntegersInArray(int[] arr, int n){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if((arr[i]+arr[j])==n)
                    return true;
            }
        }
        return false;
    }
}