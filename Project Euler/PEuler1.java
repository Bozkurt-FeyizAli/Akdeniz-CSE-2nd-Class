
import java.util.*;

public class PEuler1 {
    public static void main(String[] args) {
        String result="";
        for (int i = 0; i <= 1001; i++) {
            result+=new Number(i).toString();
        }
    System.out.println(result.replace(" ", ""));
    }   

    public static long highlyDivisibleTriangularNumber(int n){
        long result=0;
        int divisor=0;
        for (long i = 1;; i++) {
            result=(i*(i+1))/2;
            divisor=2;
            for (long j = 2;j<=result/2; j++) {
                if(result%j==0)
                    divisor++;
            }
            if(divisor>n)
                break;
        }
        return result;

        
    }

    public static long highlyDivisibleTriangularNumber1(int n) {
        long result = 0;
        int divisor = 0;
        HashMap<Long, Integer> divisorCounts = new HashMap<>(); // Store divisor counts for efficient lookup

        // Calculate divisor counts for numbers up to a certain limit (adjust as needed)
        for (long i = 1; i <= 100000; i++) {
            divisorCounts.put(i, countDivisors(i));
        }

        // Iterate through triangular numbers
        for (long i = 1; i <= 76576500; i++) {
            result = (i * (i + 1)) / 2;
            divisor = divisorCounts.getOrDefault(result, countDivisors(result)); // Efficiently retrieve divisor count

            if (divisor > n) {
                break;
            }
        }

        return result;
    }

    // Efficiently count divisors up to the square root of the number
    private static int countDivisors(long number) {
        int divisorCount = 2; // 1 and the number itself are always divisors
        for (long j = 2; j * j <= number; j++) {
            if (number % j == 0) {
                divisorCount += 2; // Add 2 divisors (j and number/j)
                if (j * j == number) {
                    divisorCount--; // Adjust if j is the square root
                }
            }
        }
        return divisorCount;
    }

    public static int[] largeSum(int[][] numbers){
        int[] result= new int[numbers[0].length+1];
        int carry=0;
        for (int i = numbers[0].length-1; i>=0; i--) {
            carry=0;
        for (int j = 0; j < numbers.length; j++) {
            carry+=numbers[j][i];
        }
            // carry/=10;
            result[i]=carry;
        }
        for (int i = result.length-1;i>0; i--) {
            carry=result[i]/10;
            if(i!=0){
                result[i-1]=result[i-1]+carry;
                result[i]=result[i]%10;
            }
            else{
                result[0]=carry;
                result[1]=result[1]%10;}
        }
        return result;

        /*
         * int[][] numbers= new int[100][50];
        int index=0;
        // System.out.println((int)'0');
                        for (int i = 0; i < 100; i++) {
                            for (int j = 0; j < 50; j++) {
                                numbers[i][j]=n.charAt(index++)-48;
                               
                            }
                        }
         */
    }


    public static long longestCollatzSequence(int n) {
        int maxSet = 0;
        long number = 0;
        for (long i = 1; i < n; i++) {
            int count = 1; 
            long currentNumber = i;
            
            while (currentNumber != 1) {
                if (currentNumber % 2 == 0) {
                    currentNumber /= 2;
                } else {
                    currentNumber = currentNumber * 3 + 1;
                }
                count++;
                if (currentNumber==1) { 
                    break;
                }
            }
            if (count > maxSet) {
                maxSet = count;
                number = i;
            }
        }
        return number;
    }

    public static long latticePaths(int n){
        // int[] grid= new int[2*n];
        long a=0;
        // int i=0;
        // while (!isAllTheSma(grid, 1)) {
        //     if(grid[i]==0){
        //         grid[i]=1;
        //     }
        //     else{
        //         grid[i]=0;
        //         grid[i+1]+=1;
        //     }
        //     if(i<grid.length)
        //         if(grid[i+1]==2){
        //             grid[i+1]=0;
        //             grid[i+2]+=1;
        //         }
        //     a++;
        //     i++;
        // }

        return a;
    }

    public static boolean isAllTheSma(int[] n, int i){
        for (int j : n) {
            if(j!=i)
                return false;
        }
        return true;
    }

    public static long factorial(int n){
        if(n<2)
            return n;
        return n*factorial(n-1);
    }

    public static int powerDigitSum2(int n, int m){
        
        int result=0;
        // int basamak=0;
        // String s= Double.toString(Math.pow(n, m));
        // int a=0;
        // for (int i = 0; i < number.length(); i++) {
        //     result+=(int)number.charAt(i)-48;
        // }
        return result;
    }
    
}
class Number{
    String number;
    public Number(int n){
        number=numberasString(n);
    }

    public static String numberasString(int n){
        String result="";
        if(n<21){
            return tenthDigit(n);
        }
        else if(n<=100){
            result=digitAsString(n/10);
            n%=10;
            return result+tenthDigit(n);
        }
        else if(n<1000){
            result=tenthDigit(n)+"hundred and";
            n%=10;
            result+=digitAsString(n/10);
            n%=10;
            return result+tenthDigit(n);
        }
        else{
            result="one thousand";
        }
        return "";
    }

    public static String digitAsString(int n){
        switch (n) {
            case 1:
            return "";
            case 2:
            return "twenty";
            case 3:
            return "thity";
            case 4:
            return "fourty";
            case 5:
            return "fivety";
            case 6:
            return "sixty";
            case 7:
            return "seventy";
            case 8:
            return "eighty";
            case 9:
            return "ninety";        
            default:
                return "";
        }
    }

    public static String tenthDigit(int n){
        switch (n) {
            case 1:
            return "one";
            case 2:
            return "two";
            case 3:
            return "three";
            case 4:
            return "four";
            case 5:
            return "five";
            case 6:
            return "six";
            case 7:
            return "seven";
            case 8:
            return "eight";
            case 9:
            return "nine";
            case 10:
            return "ten";
            case 11:
            return "eleven";
            case 12:
            return "twelve";
            case 13:
            return "thirteen";
            case 14:
            return "fouteen";
            case 15:
            return "fifteen";
            case 16:
            return "sixteen";
            case 17:
            return "seventeen";
            case 18:
            return "eighteen";      
            case 19:
            return "nineteen";
            case 20:
            return "twenty";    
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return number;
    }
}
