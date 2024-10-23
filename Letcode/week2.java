public class week2 {
    public static void main(String[] args) {
        


    }


    public static int lengthOfLastWord(String s) {
        String[] words=s.split(" ");
        return words[words.length-1].length();
    }
}
