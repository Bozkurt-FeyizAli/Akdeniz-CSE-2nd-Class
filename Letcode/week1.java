public class week1{
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static int romanToInt(String s) {  // has problems IV is not 4
        char[][] symbol={{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};
        int result=0;

        for (char st : s.toCharArray()) {
            for (int i = 0; i < symbol.length; i++) {
                if(symbol[i][0]==st)
                    result+=symbol[i][1];

            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        String result="";
        int shortestLong=Integer.MAX_VALUE;
        for (String string : strs) {
            if(string.length()<shortestLong)
                shortestLong=string.length();
        }
        for (int i = 0; i < shortestLong; i++) {
            char c=strs[0].charAt(i);
            boolean b=false;
            for (String string : strs) {
                if(string.charAt(i)!=c)
                    b=true;
            }
            if(b)
                break;
            result+=c;

        }
        return result;
    }
}