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

        // // Test 9: Test if tree is empty after removing all nodes
        // System.out.println("\nTest 9: Check if tree is empty after removing all nodes");
        // bst.remove(5);
        // bst.remove(12);
        // bst.remove(18);
        // System.out.println("Is tree empty? " + bst.isEmpty());  // Expected: true

        // // Test 10: Test remove on an empty tree
        // System.out.println("\nTest 10: Try to remove from an empty tree");
        // System.out.println("Remove 10 from empty tree: " + bst.remove(10));  // Expected: false
    
        
    }
}

interface Tree<T> {
    int size();
    boolean isEmpty();
    void insert(T element);
    boolean remove(T element);
    boolean contains(T element);
    void levelorder(List<T> list);
    void inorder(List<T> list);
    void preorder(List<T> list);
    void postorder(List<T> list);
}


class TreeNode<T> {
    T element;
    TreeNode<T> left, right;

    public TreeNode(T element) {
        this.element = element;
    }
}

/*
 * Node-based BST implementation
 */
class BSTNode <T extends Comparable<? super T>> implements Tree<T> {
    private TreeNode<T> root;
    private int size;

    public BSTNode(){
        root=null;
        size=0;
    }
    public TreeNode<T> getRoot() {
        // Convenience method for me
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void insert(T element) {
        root=recInsert(root, element);
        size++;
    }

    public TreeNode<T> recInsert(TreeNode<T> n, T e){
        if(n==null){
            return new TreeNode<>(e);
        }
        else if(e.compareTo(n.element)>0)
            n.right= recInsert(n.right, e);
        else n.left= recInsert(n.left, e);
        return n;
    }

    @Override
    public boolean remove(T element) {
        if(isEmpty())
            return false;
        root = recRemove(root, element);
        if (root != null) {
            size--;
            return true;
        }
        return false;
    }

    private TreeNode<T> recRemove(TreeNode<T> node, T element) {
        if (node==null) return null;
        else if (element.compareTo(node.element) < 0) {
            node.left = recRemove(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = recRemove(node.right, element);
        } else {
            if (node.left==null&&node.right==null) {
                return null; 
            } else if (node.left==null) {
                return node.right; 
            } else if (node.right==null) {
                return node.left;
            } else {
                TreeNode<T> inorderSuccessor=findMin(node.right); 
                node.element=inorderSuccessor.element;
                node.left=recRemove(node.right, inorderSuccessor.element);
            }
        }
        return node;
    }

    private TreeNode<T> findMin(TreeNode<T> node) {
        while (node!=null&&node.left != null) {
            node = node.left;
        }
        return node;
    }
    private TreeNode<T> findMax(TreeNode<T> node) {
        while (node!=null&&node.right != null) {
            node = node.right;
        }
        return node;
    }

    private boolean delete(TreeNode<T> root, TreeNode<T> target){
        if(root!=null){
        if(root.left==target){
            root.left=null;
            return true;}
        if(root.right==target){
            root.right=null;
            return true;
        }
        if(target.element.compareTo(root.element)>0)
            return delete(root.right, target);
            return delete(root.left, target);
    }
    return false;
        
    }

    public void swap(TreeNode<T> i, TreeNode<T> j){
        if(i!=null&&j!=null){
            T s=i.element;
            i.element=j.element;
            j.element=s;
        }
    }

    public TreeNode<T> inorderForRight(TreeNode<T> n){
        if(n!=null){
            inorderForRight(n.left);
            return n;
        }
        return null;
    }
