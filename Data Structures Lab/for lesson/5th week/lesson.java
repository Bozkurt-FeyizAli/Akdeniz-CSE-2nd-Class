
import java.util.Stack;

public class lesson {
    public static void main(String[] args) {
        /*
         * int[][] arr={{1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}};
        System.out.println(recursiveSum2DArray(arr, 1, 1, 1));
         */
        
        System.out.println(evaluate1("(4+3)*9"));

        
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

    public static int evaluate(String expression) {
        /*
         * Write a function to evaluate a given arithmetic expression containing integers,
         *  parentheses, and operators. The function should correctly follow the order of
         *  operations (precedence) and handle parentheses appropriately.
         *  Your task is to complete the evaluate(String expression) method
         *  which returns the result of the expression.
         * 
         * You may also need following methods or any other:
         * boolean isOperator(char c): returns true if given character is an operator
         * int precedance(char op): returns the precedance of the character
         * int applyOp(char op, int b, int a): applys the operator on operands
         */
        // Your code here..
        Stack<Integer> valStk= new Stack<>();
        Stack<Character> opStk= new Stack<>();
        expression+=" $";

        for (int i = 0; i < expression.length(); i++) {
            char c= expression.charAt(i);
            if (c==' ')
                continue;
            if (Character.isDigit(c)) {
                String result="";
                while (i< expression.length()&&Character.isDigit(expression.charAt(i)))
                    result+=expression.charAt(i++);
                valStk.push(Integer.parseInt(result));
                i--; 
            } 
            else if (isOperator(c)||c=='$') {
                repeatOps(c, valStk, opStk);
                opStk.push(c); 
            }
        }
        repeatOps('$', valStk, opStk);
        return valStk.pop();
    }

    public static void repeatOps(char refOp, Stack<Integer> valStk, Stack<Character> opStk) {
        while (valStk.size()>1&&precedance(refOp)<=precedance(opStk.peek())) {
            doOp(valStk, opStk);
        }
    }

    public static void doOp(Stack<Integer> valStk, Stack<Character> opStk) {
        int x= valStk.pop();
        int y= valStk.pop();
        char op= opStk.pop();
        valStk.push(applyOp(op, y, x)); 
    }

    public static int evalutaPart(String expression){
        Stack<Integer> valueStack= new Stack<>();
        Stack<Character> progresStack= new Stack<>();
        char[] characters=expression.toCharArray();
        for (char c : characters) {
            if(c<10)
                valueStack.add((int)c);
            else if(isOperator(c))
                progresStack.add(c);
            else 
                throw new IllegalArgumentException();
        }


        return 0;
    }

    public static int applyOp(char op, int b, int a){
        switch(op){
            case('-'):
                return b-a;
            case('+'):
                return b+a;
            case('*'):
                return b*a;
            case('/'):
                return b/a;
            
            default: return 0;
        }
    }

    public static boolean isOperator(char c){
        switch(c){
            case('-'):
                return true;
            case('+'):
                return true;
            case('*'):
                return true;
            case('/'):
                return true;
            case(')'): return true;
            default: return false;
        }
    }

    public static int precedance(char op){
        switch(op){
            case('-'):
                return 1;
            case('+'):
                return 1;
            case('*'):
                return 2;
            case('/'):
                return 2;
            // case('<'):
            //     return 1;
            // case('+'):
            //     return 1;
            // case('*'):
            //     return 2;
            // case('/'):
            //     return 2;
            case('$'): return 0;
            default: return 0;
        }
    }
    
    public static void recursiveReverseArray(int[] arr, int s, int f){
        if(s<0||f>=arr.length)
            return;
        if(s<f){
            if(s==f||s+1==f)
                return;
            int swap=arr[s];
            arr[s]=arr[f];
            arr[f]=swap;
        }
        recursiveReverseArray(arr, s+1, f-1);
    }

    public static int binarySearch(int[] arr, int s, int f, int target){
        while (s<=f) {
            int mid=(s+f)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target)
                f--;
            else 
                s++;
        }
        return -1;
    }

    public static boolean isPalindrome(int x) {
        String n=Integer.toString(x);
        if(n.length()==1)
            return true;
        if(n.charAt(0)!=n.charAt(n.length()-1))
            return false;
        if(n.length()==2)
            return true;
        else return isPalindrome(Integer.parseInt(n.substring(1, n.length()-1)));
         
    }

    public static int reverse(int x) {
        String n=Integer.toString(x);
        String result="";
        if(n.charAt(0)=='-'){
            n=n.substring(1);
            result+='-';
        }
        for(int i=n.length()-1;i>=0;i--)
            result+=n.charAt(i);
        return Integer.parseInt(result);
    }


    public static int evaluate1(String s){
        Stack<Character> opStk= new Stack<>();
        Stack<Integer> valStk= new Stack<>();
        s+="$";
        s.replace(" ", "");
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (Character.isDigit(c)) {
                String result="";
                while (i< s.length()&&Character.isDigit(s.charAt(i)))
                    result+=s.charAt(i++);
                valStk.push(Integer.parseInt(result));
                i--; 
            } 
            else if (isOperator(c)||c=='$') {
                repeatOps(c, valStk, opStk);
                opStk.push(c); 
            }
        }
        repeatOps('$', valStk, opStk);
        return valStk.pop();
    }

    
    public static void doOp1(Stack<Integer> valStk, Stack<Character> opStk){
        int x=valStk.pop();
        int y=valStk.pop();
        char op=opStk.pop();
        switch(op){
            case('+'): valStk.push(x+y); break;
            case('-'): valStk.push(x-y); break;
            case('*'): valStk.push(x*y); break;
            case('/'): valStk.push(x/y); break;
            default: System.out.println("problem in doOp");

        }
    }

    public static void repeatOps1(char refOp, Stack<Integer> valStk, Stack<Character> opStk){
        while (valStk.size()>1&&precedance(refOp)<=precedance(opStk.peek())) {
            doOp1(valStk, opStk);
        }
    }








}
