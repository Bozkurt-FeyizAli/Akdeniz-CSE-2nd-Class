import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HW04 {
    public static void main(String[] args) {
        System.out.println("Testing SortedPriorityQueue:");
        SortedPriorityQueue<Integer, String> spq = new SortedPriorityQueue<>();
        spq.insert(3, "C");
        spq.insert(1, "A");
        spq.insert(2, "B");

        System.out.println("Peek: " + spq.peek()); // Expected: "A"
        System.out.println("Remove: " + spq.remove()); // Expected: "A"
        System.out.println("Remove: " + spq.remove()); // Expected: "B"
        System.out.println("Remove: " + spq.remove()); // Expected: "C"
        System.out.println("Is Empty: " + spq.isEmpty()); // Expected: true

        // UnsortedPriorityQueue Test
        System.out.println("\nTesting UnsortedPriorityQueue:");
        UnsortedPriorityQueue<Integer, String> upq = new UnsortedPriorityQueue<>();
        upq.insert(3, "C");
        upq.insert(1, "A");
        upq.insert(2, "B");

        System.out.println("Peek: " + upq.peek()); // Expected: "A"
        System.out.println("Remove: " + upq.remove()); // Expected: "A"
        System.out.println("Peek: " + upq.peek()); // Expected: "A"
        System.out.println("Remove: " + upq.remove()); // Expected: "B"
        System.out.println("Remove: " + upq.remove()); // Expected: "C"
        System.out.println("Is Empty: " + upq.isEmpty()); // Expected: true

        // Additional Tests
        System.out.println("\nAdditional Tests:");
        spq.insert(5, "E");
        spq.insert(4, "D");
        System.out.println("Peek after re-insert: " + spq.peek()); // Expected: "D"
        System.out.println("Size: " + spq.size()); // Expected: 2
    
        // BSTArray<Integer> bst = new BSTArray<>(15);

        // // Test 2: Insert elements
        // System.out.println("Test 2: Insert elements");
        // bst.insert(10);
        // bst.insert(5);
        // bst.insert(15);
        // bst.insert(3);
        // bst.insert(7);
        // bst.insert(12);
        // bst.insert(18);

        // // Verify the elements are inserted correctly
        // List<Integer> inorderList = new ArrayList<>();
        // bst.levelorder(inorderList);
        // System.out.println("Inorder Traversal: " + inorderList); // Should be [3, 5, 7, 10, 12, 15, 18]
        
        // // Test 3: Test 'contains' method
        // System.out.println("\nTest 3: Contains method");
        // System.out.println("Contains 7: " + bst.contains(7));  // Expected: true
        // System.out.println("Contains 20: " + bst.contains(20)); // Expected: false
        // bst.remove(10);
        // inorderList.clear();
        // bst.levelorder(inorderList);
        // System.out.println(inorderList);

        // // Test 4: Remove a leaf node
        // // System.out.println("\nTest 4: Remove leaf node (3)");
        // // bst.remove(3);  // Remove leaf node
        // // inorderList.clear();
        // // bst.levelorder(inorderList);
        // // System.out.println("Inorder Traversal after removing 3: " + inorderList); // Expected: [5, 7, 10, 12, 15, 18]

        // // Test 5: Remove a node with one child (15)
        // // System.out.println("\nTest 5: Remove node with one child (15)");
        // // bst.remove(15);  // Remove node with one child (12 should replace 15)
        // // inorderList.clear();
        // // bst.levelorder(inorderList);
        // // System.out.println("Inorder Traversal after removing 15: " + inorderList); // Expected: [5, 7, 10, 12, 18]

        // // Test 6: Remove a node with two children (10)
        // System.out.println("\nTest 6: Remove node with two children (10)");
        // bst.remove(10);  // Remove node with two children (12 should replace 10)
        // inorderList.clear();
        // bst.levelorder(inorderList);
        // System.out.println("Inorder Traversal after removing 10: " + inorderList); // Expected: [5, 7, 12, 18]

        // // Test 7: Remove a node that doesn't exist
        // System.out.println("\nTest 7: Try to remove a node that doesn't exist (20)");
        // boolean result = bst.remove(20);  // This should return false
        // System.out.println("Remove 20 result: " + result); // Expected: false

        // // Test 8: Remove the root node (7)
        // System.out.println("\nTest 8: Remove root node (7)");
        // bst.remove(7);  // Remove root node
        // inorderList.clear();
        // bst.levelorder(inorderList);
        // System.out.println("Inorder Traversal after removing 7: " + inorderList); // Expected: [5, 12, 18]
