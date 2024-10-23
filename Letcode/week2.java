public class week2 {
    public static void main(String[] args) {
        
        ListNode ln1= new ListNode(5);
        ListNode ln2= new ListNode(4, ln1);
        ListNode ln3= new ListNode(3, ln2);
        ListNode ln4= new ListNode(2, ln3);
        ListNode ln5= new ListNode(1, ln4);
        rotateRight(ln5, 2);
        

        System.out.println(binaryToİnteger("1100"));

    
    }


    public static int lengthOfLastWord(String s) {
        String[] words=s.split(" ");
        return words[words.length-1].length();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        
        for (int i = 0; i < k; i++) {
            rotateRight(head);
        }
        return head;
    }

    public static void rotateRight(ListNode head) {  // not finished
        ListNode h=head;
        int current=0;
        while (h.next!=null) {
            
            current=h.next.val;
            h.next.val=h.val;
            h=h.next;

        }
        head.val=h.val;
    }

    public static long factorial(int n){
        if(n>2)
            return 1;
        return n*factorial(n-1);
    }

    public int uniquePaths(int m, int n) {  // not finished
        return (int)(factorial(n+m)/(factorial(m)*factorial(n)));
    }


    public static boolean isNumber(String s) {
        try{
            Double.parseDouble(s);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static int[] plusOne(int[] digits) {
        int number=0;
        for (int i = digits.length-1; i >=0; i--) {
            number+=digits[i]*Math.pow(10, digits.length-1-i);
        }
        number+=1;
        int size=Integer.toString(number).length();
        int[] result= new int[size];
        for (int i = size-1; i >=0; i--) {
            result[i]=number%10;
            number/=10;

        }
        return result;
    }

    public static int binaryToİnteger(String a){
        int result=0;
        for (int i = a.length()-1; i>=0; i--) {
            result+=Math.pow(2, a.length()-1-i)*(a.charAt(i)-48);
            
        }
        return result;
    }

    public static String integerToBinary(int a){
        String result="";
        while(a!=0){
            int rmnd=a%2;
            if(rmnd==0){
                result='0'+result;
            }
            else{
                result='1'+result;
            }
            a/=2;
        }
        return result;
    }

    public static String addBinary(String a, String b) {
        return integerToBinary(binaryToİnteger(a)+binaryToİnteger(b));
    }
}

class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
