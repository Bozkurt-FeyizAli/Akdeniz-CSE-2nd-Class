public class a{
    public static void main(String[] args) {
        System.out.println(A(-124));
    }

    public static String A(int a){
        if(a<0)
            return "-"+A(0-a);
        if(a<10)
            return ""+a;
        return a%10+A(a/10);
    }
}