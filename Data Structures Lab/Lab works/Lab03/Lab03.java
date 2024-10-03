import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
 * INSTRUCTIONS:
 * 1. Implement each of the algorithms according to provided psudeo codes
 * 2. sysout each of their time complexities in the first line of functions (e.g. O(logn), O(n), O(nlogn), O(n**2), O(1))
 * Each method should be public static
 * 3. Test each method with various n, and see if it meets your expectations
 * 4. Compare execution times of worst-case and best-cases for each
 */
public class Lab03 {

    public static void main(String[] args) {
        List<Integer> array_list = new ArrayList<>();
        List<Integer> linked_list = new LinkedList<>();
        int[] n = {1000, 10000, 100000};
        for (int i = 0; i < n.length; i++) {
            int[] array = generateRandomArray(n[i]);
            //int[] array = generateSortedArray(n[i]);

            final int currentN = n[i];
            
            Runnable algorithm = () -> accessElement(array.clone(), n[0]/2);
            //Runnable algorithm = () -> listInsertion(currentN, linked_list);
            
            double timeTaken = measureExecutionTime(algorithm);
            System.out.printf("accessing element took: %.4f seconds; n: %d\n", timeTaken, n[i]);
            array_list.clear();
            linked_list.clear();
        }
    }

    public static double measureExecutionTime(Runnable algorithm) {
        long startTime = System.currentTimeMillis();
        algorithm.run();  // Execute the algorithm
        long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000.0;  // Return time in nanoseconds
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);  // Random integers between 0 and 9999
        }
        return array;
    }
    
    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;  // Sorted array from 0 to size-1
        }
        return array;
    }

    public static void listInsertion(int n, List<Integer> list) {
        for (int i = 0; i < n; i++) {
            list.addFirst(i);
        }
    }

    
// =======================================================================

/*
function accessElement(ARRAY, INDEX):
    return ARRAY[INDEX]
 */

        public static int accessElement(int[] array, int index){
            return array[index];
        }

/*
function findMax(ARRAY):
    MAX ← ARRAY[0]
    for i from 1 to length_of(ARRAY) - 1:
        if ARRAY[i] > MAX:
            MAX ← ARRAY[i]
    return MAX
*/
        public static int findMax(int[] array){
            int first=array[0];
            for (int i = 1; i < array.length; i++) {
                if(array[i]>first)
                    first=array[i];
            }
            return first;
        }
/*


function bubbleSort(ARRAY):
    N ← length_of(ARRAY)
    for i from 0 to N - 1:
        for j from 0 to N - i - 2:
            if ARRAY[j] > ARRAY[j + 1]:
                swap(ARRAY[j], ARRAY[j + 1])
 */
        public static void bubbleSort(int[] array){
            int n=array.length;
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < n-i-2; j++) {
                    if(array[j] > array[j + 1]){
                        swap(array, j, j+1);
                    }
                }
            }
        }

        public static void swap(int[] array, int i, int j){
            int swap=array[i];
            array[i]=array[j];
            array[j]=swap;
        }

/*
function mergeSort(ARRAY, LEFT, RIGHT):
    if LEFT < RIGHT:
        MID ← (LEFT + RIGHT) / 2
        mergeSort(ARRAY, LEFT, MID)
        mergeSort(ARRAY, MID + 1, RIGHT)
        merge(ARRAY, LEFT, MID, RIGHT)

function merge(ARRAY, LEFT, MID, RIGHT):
    L ← subarray(ARRAY, LEFT, MID)
    R ← subarray(ARRAY, MID + 1, RIGHT)
    i ← 0, j ← 0, k ← LEFT
    while i < length_of(L) and j < length_of(R):
        if L[i] ≤ R[j]:
            ARRAY[k] ← L[i]
            i ← i + 1
        else:
            ARRAY[k] ← R[j]
            j ← j + 1
        k ← k + 1
    copy_remaining_elements(L, ARRAY, i, k)
    copy_remaining_elements(R, ARRAY, j, k)
 */

 /*
function binarySearch(ARRAY, TARGET):
    LOW ← 0
    HIGH ← length_of(ARRAY) - 1
    while LOW ≤ HIGH:
        MID ← (LOW + HIGH) / 2
        if ARRAY[MID] = TARGET:
            return MID
        else if ARRAY[MID] < TARGET:
            LOW ← MID + 1
        else:
            HIGH ← MID - 1
    return -1  // Target not found

  */

  public static int binarySearch(int[] array, int key){
    int low=0;
    int high=array.length-1;
    while(low<=high){
        int mid=(low+high)/2;
        if(array[mid]==key)
            return mid;
        else if(array[mid]<key){
            low=mid+1;
        }
        else 
            high=mid-1;
    }
    return -1;
  }
}