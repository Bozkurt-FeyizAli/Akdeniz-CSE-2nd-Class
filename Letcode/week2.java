public class week2 {
    public static void main(String[] args) {
        
        ListNode ln1= new ListNode(5);
        ListNode ln2= new ListNode(4, ln1);
        ListNode ln3= new ListNode(3, ln2);
        ListNode ln4= new ListNode(2, ln3);
        ListNode ln5= new ListNode(1, ln4);
        rotateRight(ln5, 2);
        



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
}

class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
