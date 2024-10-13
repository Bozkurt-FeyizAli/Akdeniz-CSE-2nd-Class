public class PEuler{
    public static void main(String[] args) {
        System.out.println(smallestMultiple(1, 20));
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

    public static boolean isPalindrome(int n){
        String numb=Integer.toString(n);
        for (int i = 0; i < numb.length()/2; i++) {
            if(numb.charAt(i)!=numb.charAt(numb.length()-1-i))
                return false;
        }
        return true;
    }

    public static int Question4(int n){
        int result=0;
        for (int i = 0; i < Math.pow(10, n); i++) {
            for (int j = 0; j < Math.pow(10, n); j++) {
                if(isPalindrome(i*j))
                    if(i*j>result)
                        result=i*j;
            }
        }
        return result;
    } 

    public static long smallestMultiple(int start, int last){
        long i=0;
        boolean divide=true;
        while(true){
            i++;
            divide=true;
            for (int j = start; j <= last; j++) {
                if(i%j!=0)
                    divide=false;
            }
            if(!divide)
                continue;
            return i;
        }
    }
}
