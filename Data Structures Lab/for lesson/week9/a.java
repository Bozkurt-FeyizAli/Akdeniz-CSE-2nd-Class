public class a{
    public static void main(String[] args) {
        int[][] deneme= {{1,2,3},{1,2,3},{1,2,3},{1,2,3}};
        System.out.println(sum2DArray(deneme, 3, 2));
    }

    public static int sum2DArray(int[][] arr, int y, int x){
        if(y<0||x<0)
            return -1;
        if(x==0&&y==0)
            return arr[0][0];
        if(x==0){
            y--;
            x=arr[0].length-1;
            return arr[y][0]+sum2DArray(arr, y, x);
        }
        return arr[y][x]+sum2DArray(arr, y, x-1);
    }
}