public class PEuler{
    public static void main(String[] args) {
        System.out.println(LargestPrimeFactor(600851475143L));
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

    public static int Question2(int n, int[] sequence){
        if(n<2){
            sequence[n]=n;
            return n;
        }
        else{
            if(sequence[n]==0)
                sequence[n]=Question2(n-1, sequence)+Question2(n-2, sequence);
            return sequence[n];
        }
    }

    public static int LargestPrimeFactor(Long n){
        int result=0;
        double d=Math.sqrt(n);
        for (int i = 1; i < d; i++) {
            if(n%i==0&&isPrime(i))
                result=i;
        }
        return result;
    }

    public static boolean isPrime(long n){
        if(n<2)
            return false;
        if(n<4)
            return true;
        double d=Math.sqrt(n);
        for (int i = 2; i < d; i++) {
            if((n%i==0))
            return false;
        }
        return true;
    }
}
