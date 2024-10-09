

public class Secondweek{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10,11};
        int[][] arr2={{1,2,3, 4,5,6},{7,8,9,10,11,12}};
        // recursiveReverseArray(arr, 0, arr.length-1);
        // for (int is : arr) {
        //     System.out.println(is);
        // }
        System.out.println(recursiveSquare(2, 10));
    }

    public static boolean binarySearch(int[ ] data, int target, int low, int high){
        if(low>high)
            return false;
        int mid=(low+high)/2;
        while(low<=high){
            mid=(int)((low+high)/2);
            if(data[mid]==target)
                return true;
            else if(data[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
    }

    public static boolean recursiveBinarySearch(int[] data, int target, int low, int high){
        if(low>high)
            return false;
        else{
        int mid=Math.round(((low+high)/2));
        
            if(data[mid]==target){
                return true;
            }
            else if(data[mid]>target){
                return recursiveBinarySearch(data, target, low, mid-1);
            }
            else{
                return recursiveBinarySearch(data, target, mid+1, high);
            }
        }
    }

    public static int recursiveSum1darray(int[] array, int base){
        if(base>=array.length)
            return 0;
        else{
            return array[base]+recursiveSum1darray(array, base+1);
        }
    }

    public static int recursiveSum2darray(int[][] array, int x, int y){
        if(x>= array.length)
            return 0;
        else if(y>= array[0].length)
            return 0;
        if(x>0&&y>0){
            return array[x][y]+recursiveSum2darray(array, x, y-1);
        }
        else if(y>0&&y>0){
            return array[x][y]+recursiveSum2darray(array, x-1, y);
        }
        else return 0;
    }

    public static void recursiveReverseArray(int[] arr, int low, int high){
        if(low<high){
            int swap=arr[low];
            arr[low]=arr[high];
            arr[high]=swap;
            recursiveReverseArray(arr, low+1, high-1);
        }
    }

    public static int recursiveSquare(int a, int b){
        if(b==0)
            return 1;
        else if(b%2==1){
            int s=recursiveSquare(a, (b-1)/2);
            return a*s*s;
        }
        else{
            int s=recursiveSquare(a, b/2);
            return s*s;
        }
    } 

}