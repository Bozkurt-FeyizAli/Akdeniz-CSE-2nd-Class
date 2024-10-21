import java.util.*;

public class week6 {
    public static void main(String[] args) {
        
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
}
