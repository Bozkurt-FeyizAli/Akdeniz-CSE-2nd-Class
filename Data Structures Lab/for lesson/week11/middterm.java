
    

    public static int sum3DArray(int[][] arr, int x, int y){
        if(x<0||y<0)
            return -1;
        if(x==0&&y==0)
            return arr[y][x];
        if(x==0){
            x=arr[0].length-1;
            y--;
            return arr[y+1][0]+sum3DArray(arr, x, y);
        }
        return arr[y][x]+sum3DArray(arr, x-1, y);
    }

    public static void clear2DArray(int[][] arr){
        int x=(int)(Math.random()*arr[0].length);
        int y=(int)(Math.random()*arr.length);
        arr[y][x]=0;
        for (int[] is : arr) {
            for (int is2 : is) {
                if(is2!=0)
                    clear2DArray(arr);
            }
        }
    }
}
