import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HW05_Test {

    private ArrayHeap<Integer, String> heap;

    @BeforeEach
    public void setUp() {
        heap = new ArrayHeap<>(10);
    }


    @Test
    public void testInsert() {
        heap.insert(10, "Ten");
        heap.insert(5, "Five");
        heap.insert(20, "Twenty");
        
        assertEquals("Five", heap.peek(), "The element with the smallest priority should be 'Five'");
    }

    @Test
    public void testRemove() {
        heap.insert(10, "Ten");
        heap.insert(5, "Five");
        heap.insert(20, "Twenty");

        String removed = heap.remove();
        assertEquals("Five", removed, "The element with the smallest priority should be removed first");

        removed = heap.remove();
        assertEquals("Ten", removed, "The next smallest element should be 'Ten'");
    }

    @Test
    public void testIsEmpty() {
        assertTrue(heap.isEmpty(), "Heap should be empty initially");
        
        heap.insert(15, "Fifteen");
        assertFalse(heap.isEmpty(), "Heap should not be empty after inserting an element");
    }

    @Test
    public void testSize() {
        assertEquals(0, heap.size(), "Heap size should be 0 initially");
        
        heap.insert(15, "Fifteen");
        heap.insert(10, "Ten");
        assertEquals(2, heap.size(), "Heap size should be 2 after inserting two elements");
    }

    @Test
    public void testPeek() {
        heap.insert(30, "Thirty");
        heap.insert(5, "Five");
        heap.insert(10, "Ten");

        assertEquals("Five", heap.peek(), "Peek should return the element with the smallest priority without removing it");
    }


    @Test
    public void testInsertBeyondCapacity() {
        ArrayHeap<Integer, String> smallHeap = new ArrayHeap<>(3);
        smallHeap.insert(10, "Ten");
        smallHeap.insert(20, "Twenty");
        smallHeap.insert(30, "Thirty");
    
        smallHeap.insert(40, "Forty");
    
        assertEquals(3, smallHeap.size(), "Heap size should remain 3 after attempting to insert beyond capacity");
    
        assertEquals("Ten", smallHeap.peek(), "The root of the heap should still be 'Ten' after attempting to insert beyond capacity");
    }
    

    @Test
    public void testRemoveFromEmptyHeap() {
        
        assertNull(heap.remove(), "Removing from an empty heap should return null");
    }

    @Test
    public void testMergeTwoEmptyHeaps() {
        ArrayHeap<Integer, String> emptyHeap1 = new ArrayHeap<>(10);
        ArrayHeap<Integer, String> emptyHeap2 = new ArrayHeap<>(10);

        ArrayHeap<Integer, String> mergedHeap = ArrayHeap.merge(emptyHeap1, emptyHeap2);
        assertTrue(mergedHeap.isEmpty(), "Merging two empty heaps should result in an empty heap");
    }

    @Test
    public void testMergeWithDifferentCapacities() {
        ArrayHeap<Integer, String> heap1 = new ArrayHeap<>(3);
        ArrayHeap<Integer, String> heap2 = new ArrayHeap<>(5);

        heap1.insert(10, "Ten");
        heap1.insert(20, "Twenty");
        heap2.insert(5, "Five");
        heap2.insert(15, "Fifteen");

        ArrayHeap<Integer, String> mergedHeap = ArrayHeap.merge(heap1, heap2);
        assertEquals(4, mergedHeap.size(), "Merged heap should have 4 elements");
        assertEquals("Five", mergedHeap.peek(), "The smallest element after merging should be 'Five'");
    }

    @Test
    public void testInsertDuplicateKeys() {
        heap.insert(10, "Ten");
        heap.insert(10, "Another Ten");
        heap.insert(5, "Five");

        assertEquals("Five", heap.peek(), "Peek should return the element with the smallest priority");
        heap.remove();
        assertEquals("Ten", heap.peek(), "Peek should return one of the elements with priority 10");
    }

    @Test
    public void testMergeHeapIntoLargerCapacity() {
        ArrayHeap<Integer, String> heap1 = new ArrayHeap<>(3);
        ArrayHeap<Integer, String> heap2 = new ArrayHeap<>(10);

        heap1.insert(10, "Ten");
        heap2.insert(5, "Five");

        ArrayHeap<Integer, String> mergedHeap = ArrayHeap.merge(heap1, heap2);
        assertEquals(2, mergedHeap.size(), "Merged heap should contain all elements from both heaps");
        assertEquals("Five", mergedHeap.peek(), "Peek should be 'Five'");
    }

    @Test
    public void testPeekEmptyHeap() {
        assertNull(heap.peek(), "Peek on an empty heap should return null");
    }

    @Test
    public void testHeapifyWithDecreasingOrder() {
        ArrayHeap<Integer, String> decreasingHeap = new ArrayHeap<>(10);
        decreasingHeap.insert(30, "Thirty");
        decreasingHeap.insert(20, "Twenty");
        decreasingHeap.insert(10, "Ten");

        assertEquals("Ten", decreasingHeap.peek(), "The element with the lowest key should always be at the root");
    }

    @Test
    public void testRemoveAllElements() {
        heap.insert(15, "Fifteen");
        heap.insert(10, "Ten");
        heap.insert(5, "Five");

        heap.remove();
        heap.remove();
        heap.remove();

        assertTrue(heap.isEmpty(), "Heap should be empty after removing all elements");
        assertNull(heap.peek(), "Peek should return null on an empty heap");
    }

    @Test
    public void testHeapSortEdgeCases() {
        int[] array = {};
        HW05.heapSort(array);
        assertArrayEquals(new int[]{}, array, "Heap sort on an empty array should return an empty array");
    
        array = new int[]{1};
        HW05.heapSort(array);
        assertArrayEquals(new int[]{1}, array, "Heap sort on a single element array should return the same array");
    
        array = new int[]{5, 3, 8, 1, 2, 7};
        HW05.heapSort(array);
    
        boolean isAscending = true;
        boolean isDescending = true;
    
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isAscending = false;
            }
            if (array[i] < array[i + 1]) {
                isDescending = false;
            }
        }
    
        assertTrue(isAscending || isDescending, "Heap sort should return an array sorted in either ascending or descending order");
    }
    

    @Test
    public void testHeapWithNegativeKeys() {
        heap.insert(-10, "Minus Ten");
        heap.insert(-20, "Minus Twenty");
        heap.insert(5, "Five");

        assertEquals("Minus Twenty", heap.peek(), "The smallest negative key should be at the root");
    }

    @Test
    public void testHeapifyEdgeCase() {
        heap.insert(10, "Ten");
        heap.insert(5, "Five");
        heap.insert(15, "Fifteen");
        
        heap.remove(); 
        assertEquals("Ten", heap.peek(), "Heapify should adjust the root to 'Ten' after removal");
    }
}
