import java.util.LinkedList;
import java.util.Queue;

public class Lab09 {
    public static void main(String[] args) {
        //NodeHeap<Integer, String> heap = new NodeHeap<>();
        //ArrayHeap<Integer, String> heap = new ArrayHeap<>(500);
        NodeHeap<Integer, String> heap= new NodeHeap<>();
        // Inserting elements into the heap
        heap.insert(10, "Ten");
        heap.insert(20, "Twenty");
        heap.insert(5, "Five");
        heap.insert(30, "Thirty");
        heap.insert(15, "Fifteen");
        heap.insert(25, "Twenty-Five");
        heap.insert(1, "One");
        heap.remove();

        // Display the heap (level-order)
        System.out.println("Heap after insertions (level-order):");
        heap.levelorder();

        NodeHeap<Integer, String> heap2 = new NodeHeap<>();
        //ArrayHeap<Integer, String> heap2 = new ArrayHeap<>(500);

        heap2.insert(8, "Ten");
        heap2.insert(23, "Twenty");
        heap2.insert(3, "Five");
        heap2.insert(27, "Thirty");
        heap2.insert(16, "Fifteen");
        heap2.insert(22, "Twenty-Five");
        heap2.insert(2, "One");

                // Display the heap (level-order)
         System.out.println("\nHeap after insertions (level-order):");
         heap2.levelorder();

        System.out.println("\nHeap after merge (level-order):");
        //var heap3 = NodeHeap.merge(heap, heap2, 6, "Six");
        NodeHeap<Integer, String> heap3 = NodeHeap.merge(heap, heap2, 1, "12");
        heap3.levelorder();
        //((ArrayHeap<Integer, String>) heap3).levelorder();
        //System.out.println(heap3.().entry.getValue());

        /* int[] array = {1, 5, 3, 2, 6, 4};
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        } */
    }

    public static void heapSort(int[] array) {
        /*
         * heap sort implementation
         */
    }
