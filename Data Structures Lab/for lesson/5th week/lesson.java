import java.util.Iterator;
import java.util.Stack;

public class lesson {
    public static void main(String[] args) {
        /*
         * int[][] arr={{1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}};
        System.out.println(recursiveSum2DArray(arr, 1, 1, 1));
         */

        System.out.println(parantezMatch("{(w[e]r)t}y{}"));
    }   

    public static int recursiveSum2DArray(int[][] arr, int x, int y, int valueX){
        if(x==0&&y==0)
            return arr[0][0];
        else if(x==-1){
            y=y-1;
            x=valueX;
        }
        return arr[y][x]+recursiveSum2DArray(arr, x-1, y, valueX);
    }

    public static boolean htmlMatch(String html){
        Stack<String> tags= new Stack<>();
        while (html.length()!=0) {
            int first= html.indexOf('<');
            if(first==-1)
                return false;
            int last= html.indexOf('>', first);
            if(last==-1)
                return false;
            String tag=html.substring(first, last+1);
            if(tag.indexOf('/')==-1)
                tags.add('/'+html.substring(first+1, last));
            else if(tags.peek().equals(html.substring(first+1, last)))
                tags.pop();
            html=html.substring(last+1);
        }
        return tags.isEmpty();
    }

    public static boolean parantezMatch(String metin){
        Stack<Character> parantezler= new Stack<>();
        String open="({[";
        String close=")}]";
        char[] caharacters= metin.toCharArray();
        for (char c : caharacters) {
            if(open.indexOf(c)!=-1)
                parantezler.add(c);
            else if(close.indexOf(c)!=-1){
                if(parantezler.isEmpty())
                    return false;
                if(close.indexOf(c)==open.indexOf(parantezler.peek()))
                    parantezler.pop();
                else    return false;
            }
                
        }
        return parantezler.isEmpty();
    }
    
}
