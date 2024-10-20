public class lesson {
    public static void main(String[] args) {
        int[][] arr={{1,2,3}, {1,2,3}, {1,2,3}, {1,2,3}};
        System.out.println(recursiveSum2DArray(arr, 2, 3, 2));
    }   

    public static int recursiveSum2DArray(int[][] arr, int x, int y, int valueX){
        if(x==-1&&y==0)
            return 0;
        else if(x==-1){
            y=y-1;
            x=valueX;
        }
        return arr[y][x]+recursiveSum2DArray(arr, x-1, y, valueX);
    }
}
