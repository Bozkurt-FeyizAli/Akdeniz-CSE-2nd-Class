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
