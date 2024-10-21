public class week1{
    public static void main(String[] args) {
        
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
}