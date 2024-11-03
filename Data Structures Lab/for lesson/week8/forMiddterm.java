public class forMiddterm{
    public static void main(String[] args) {
        System.out.println(5/2);
        System.out.println(reverse(100000, 0));
        System.out.println(betterNumReversse(100000));
        betterNumReversse1(1000000);
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
}