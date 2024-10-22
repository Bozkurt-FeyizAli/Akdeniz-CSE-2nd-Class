public class week{
    public static void main(String[] args) {

        int[] arr= {1,2,3,4,5,6,7,8,9};
        clearArray(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        
    }

    public static void clearArray(int[] array){
        int index= (int)(Math.random()*array.length);
        array[index]=0;

        for (int i = 0; i < array.length; i++) {
            if(array[i]!=0)
                clearArray(array);
        }
        return;
    }
}