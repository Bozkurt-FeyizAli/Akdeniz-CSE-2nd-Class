public class one{
    public static void main(String[] args) {
        System.out.println(isVowelMore("feyiiz", 0, "aeıiuüöoAEIİUÜÖO"));
        int[][] arr={{1,2,3,4},
                     {1,2,3,4},
                     {1,2,3,4},
                     {1,2,3,4},
                     {1,2,3,4}   

        };
        System.out.println(sum2DArray(3, 1, arr));

        System.out.println(reverse("null"));
    }

    public static boolean isVowelMore(String s, int i, String vowels){
        if(s.length()==0)
        return i>0;
        if(vowels.indexOf(s.charAt(0))!=-1)
            i++;
        else i--;
        return isVowelMore(s.substring(1), i, vowels);
    }

    public static int sum2DArray(int x, int y, int[][] arr){
        if(x==0&&y==0)
            return arr[0][0];
        if(x<0||x>=arr[0].length||y<0||y>=arr.length)
            throw new IllegalArgumentException();
        if(x==0){
            x=arr[0].length-1;
            y--;
            return arr[y+1][0]+sum2DArray(x, y, arr);
        }
        return arr[y][x]+ sum2DArray(x-1, y, arr);
    }

    public static String reverse(String s){
        if(s.length()<2)
            return s;
        else return reverse(s.substring(1))+ s.charAt(0);
    }

    
}