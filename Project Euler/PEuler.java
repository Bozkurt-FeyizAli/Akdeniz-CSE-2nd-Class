public class PEuler{
    public static void main(String[] args) {
        System.out.println(Question1(999, 3)+Question1(999, 5)-Question1(999, 15));
    }



    public static int Question1(int n, int m){
        if(m>n) return 0;
        int last=0;
        for (int i = n; i>0; i--) {
            if(i%m==0){ last=i; break;}
        }
        int times=last/m;
        return m*((times*(times+1))/2);
    }
}