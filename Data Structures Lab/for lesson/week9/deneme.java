public class deneme {
    public static void main(String[] args) {
        NumTers(123);
    }

    public static void NumTers(int number){
        int[] arr= new int[(int)Math.log10(number)+1];
        for (int j = 0; number!=1; j++) {
            arr[j]=number%10;
            number/=10;
        }
        for (int j=arr.length-1 ; j >=0; j--) {
            System.out.print(arr[j]);
        }
    }
}
