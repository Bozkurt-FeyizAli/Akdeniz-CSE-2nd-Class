public class PEuler{
    public static void main(String[] args) {
        int[] s = new int[36];
       s[0] = 1; // İlk elemanı 1 olarak ayarla
        s[1] = 1; // İkinci elemanı 1 olarak ayarla
        Question2( 31, s);
        long sum=0;
        for (int i : s) {
            // if(i<4000000&&i>0)
            sum+=i;
        }
        System.out.println(sum);
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
}
