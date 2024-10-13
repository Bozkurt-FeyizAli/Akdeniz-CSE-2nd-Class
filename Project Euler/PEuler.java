public class PEuler{
    public static void main(String[] args) {
        System.out.println(summationofPrimes(2000000));
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
        for (int i = 2; i <= d; i++) {
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

    public static long Question6(int n){
        int sum=(n*(n+1))/2;
        int sumSquare=0;
        for (int i = 0; i <= n; i++) {
            sumSquare+=Math.pow(i, 2);
        }
        return sum*sum-sumSquare;
    }

    public static long nthPrimeNumber(int n){
        int count=0;
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            if(isPrime(i))
                count++;
            if(count==n)
                return i;
        }
        return -1;
    }

    public static long biggestNNumber(String s, int n){
        long result =0;
        long l=0;
        for (int i = 0; i < s.length()-n-1; i++) {
            l= Long.parseLong(s.substring(i, i+n));
            // if(s.substring(i, i+13).contains("0"))
            //     continue;
            if(basasmkCarpim(l)>result)
                result=basasmkCarpim(l);
        }
        System.out.println(l);
        return result;
    }

    public static long basasmkCarpim(long l){
        long result=1;
        while (l!=0) {
            result*=l%10;
            l/=10;
        }
        return result;
    }

    public static int[] specialPythagoreanTriplet(int n){
        int[] result= new int[10];
        int index=0;
        for (int i = 1; i < n/2; i++) {
            for (int j = 1; j < n/2; j++) {
                int k=(int)(Math.sqrt(j*j+i*i));
                if(isDecimal(Math.sqrt(j*j+i*i)))
                if(isTriangle(i, j, k))
                    if(k+i+j==n){
                        result[index]=i;
                        index++;
                        result[index]=j;
                        index++;
                        result[index]=k;
                        index++;
                    }                
            }
        }
        
        return result;
    }

    public static boolean isDecimal(double d){
        String dd= Double.toString(d);
        dd=dd.substring(dd.indexOf(".")+1);
        for (int i = 0; i < dd.length(); i++) {
            if(dd.charAt(i)!='0')
                return false;
        }
        return true;
    }

    public static boolean isTriangle(int a, int b, int c){
        if(Math.abs(a-b)>=c)
            return false;
        else if(Math.abs(a-c)>=b)
            return false;
        else if(Math.abs(c-b)>=a)
            return false;
        return true;
    }

    public static long summationofPrimes(int n){
        long result=0;
        for (int i = 0; i < n; i++) {
            if(isPrime(i))
                result+=i; 
        }
        return result;
    }


}
