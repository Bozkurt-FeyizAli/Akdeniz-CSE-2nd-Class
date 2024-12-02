
public class trees{
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();

        // Test 1: Insert nodes
        System.out.println("Inserting elements...");
        bst.insert(50, "Node50");
        bst.insert(30, "Node30");
        bst.insert(70, "Node70");
        bst.insert(20, "Node20");
        bst.insert(40, "Node40");
        bst.insert(60, "Node60");
        bst.insert(80, "Node80");

        // Test 2: In-order traversal
        System.out.println("\nIn-order traversal:");
        bst.inorderTraversal(); // Should print: Node20, Node30, Node40, Node50, Node60, Node70, Node80

        // Test 3: Search for specific keys
        System.out.println("\nSearching for keys:");
        System.out.println("Search for 40: " + (bst.search("Node40") != null)); // Should be true
        System.out.println("Search for 100: " + (bst.search("Node100") != null)); // Should be false

        // Test 4: Delete a node with no children
        System.out.println("\nDeleting a leaf node (Node20)...");
        TreeNode<Entry<Integer, String>> nodeToDelete = bst.search("Node20");
        if (nodeToDelete != null) {
            bst.delete(nodeToDelete);
        }
        System.out.println("In-order traversal after deleting Node20:");
        bst.inorderTraversal(); // Should print: Node30, Node40, Node50, Node60, Node70, Node80

        // Test 5: Delete a node with one child
        System.out.println("\nDeleting a node with one child (Node30)...");
        nodeToDelete = bst.search("Node30");
        if (nodeToDelete != null) {
            bst.delete(nodeToDelete);
        }
        System.out.println("In-order traversal after deleting Node30:");
        bst.inorderTraversal(); // Should print: Node40, Node50, Node60, Node70, Node80

        // Test 6: Delete a node with two children
        System.out.println("\nDeleting a node with two children (Node50)...");
        nodeToDelete = bst.search("Node50");
        if (nodeToDelete != null) {
            bst.delete(nodeToDelete);
        }
        System.out.println("In-order traversal after deleting Node50:");
        bst.inorderTraversal(); // Should print: Node40, Node60, Node70, Node80

        System.out.println("\nTest completed.");
    }
}
