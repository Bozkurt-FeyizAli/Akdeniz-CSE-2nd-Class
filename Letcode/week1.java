import java.util.*;
public class week1{
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static int romanToInt(String s) {  // has problems IV is not 4
        char[][] symbol={{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};
        int result=0;

        for (char st : s.toCharArray()) {
            for (int i = 0; i < symbol.length; i++) {
                if(symbol[i][0]==st)
                    result+=symbol[i][1];

            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        String result="";
        int shortestLong=Integer.MAX_VALUE;
        for (String string : strs) {
            if(string.length()<shortestLong)
                shortestLong=string.length();
        }
        for (int i = 0; i < shortestLong; i++) {
            char c=strs[0].charAt(i);
            boolean b=false;
            for (String string : strs) {
                if(string.charAt(i)!=c)
                    b=true;
            }
            if(b)
                break;
            result+=c;

        }
        return result;
    }

    public static boolean isValid(String metin){
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result= new ListNode();
        boolean l1= true;
        boolean l2=true;
        if(l1){
                result.val=list1.val;
                if(list2.next!=null)
                result.next=list2.next;
            }
        else 
            result.val=list2.val;
        while (l2==false&&l1==false) {
            if(l1)
                result.next=list1.next;
            if(l2)
                result.next=list2.next;
            if(list1.next==null)
                l1=false;
            if(list2.next==null)
                l2=false;

        }

        return result;
    }



 
}

class ListNode {
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public ListNode getNext() {
        return next;
    }
    public int getVal() {
        return val;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
    public void setVal(int val) {
        this.val = val;
    }
}