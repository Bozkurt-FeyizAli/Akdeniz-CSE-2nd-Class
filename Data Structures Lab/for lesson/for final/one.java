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
