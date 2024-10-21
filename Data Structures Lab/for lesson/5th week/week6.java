import java.util.*;

public class week6 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public int maxUniqueSplit(String s) {  // dont work

        HashSet<String> results= new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            String result=Character.toString(s.charAt(i));
            results.add(result);
            for (int j = i; j < s.length(); j++) {
                result+=s.charAt(j);
                results.add(result);
            }

        }
        String result="";
        for (int i = 0; i < s.length(); i++) {
            result+=Character.toString(s.charAt(i));
            results.add(result);
            for (int j = i; j < s.length(); j++) {
                result+=s.charAt(j);
                results.add(result);
            }

        }
        return results.size();
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result=0;
        for (int i : nums2) {
            result+=i;
        }
        for (int i : nums1) {
            result+=i;
        }
        return result/(nums1.length+nums2.length);
    }

    public static String longestPalindrome(String s) {
        String result="";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++){
                if(i<j){
                String str=s.substring(i, j);
                if(isPalindrome(str))
                if(str.length()>result.length())
                    result=str;
                }
            }
            
         

        }
        /*
         * or (int i = s.length()-1; i>=0; i--) {
            for (int j = s.length()-1-i; j>=0; j--) {
                String str=s.substring(j, i+1);
                if(isPalindrome(str))
                    if(str.length()>result.length())
                        result=str;
    
            }

        }
         */

        return result;
    }

    public static boolean isPalindrome(String s){
        if(s.isEmpty()||s.length()==1)
            return true;
        else if(s.charAt(0)!=s.charAt(s.length()-1))
            return false;
        else return isPalindrome(s.substring(1, s.length()-1));
    } 
}
