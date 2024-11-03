public class forMiddterm{
    public static void main(String[] args) {
        System.out.println(5/2);
        System.out.println(reverse(-12, 0));
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
}