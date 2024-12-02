
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

class BinarySearchTree<K extends Comparable <? super K>, V> {
    // Root of the BST
    private TreeNode<Entry<K,V>> root;
    private int size;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(K prio, V value) {
        TreeNode<Entry<K,V>> child=new TreeNode<>(new Entry<>(prio, value));
        if(root==null){
            root=child;
        }
        else {
            TreeNode<Entry<K, V>> current = root; 
            TreeNode<Entry<K, V>> parent = null; 
            
            while (current != null) {
                parent = current; 
                if (child.entry.getKey().compareTo(current.entry.getKey()) < 0) {
                    current = current.left; 
                } else {
                    current = current.right; 
                }
            }
            if (child.entry.getKey().compareTo(parent.entry.getKey()) < 0) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            child.parrent = parent;
        }
        size++;
    }
    public void delete(TreeNode<Entry<K,V>> t) {
        recDelete(t, t);
    }
    public TreeNode<Entry<K,V>> recDelete(TreeNode<Entry<K,V>> r, TreeNode<Entry<K,V>> t){
            if(root==null){
                return null;
            }
            int cmp = t.entry.getKey().compareTo(r.entry.getKey());
            if (cmp < 0) {
                r.left = recDelete(r.left, t);
            } else if (cmp > 0) {
                r.right = recDelete(r.right, t);
            } else {
                // Node found
                if (r.left == null) return r.right;
                if (r.right == null) return r.left;
                // Replace with successor
                TreeNode<Entry<K,V>> min = findMin(r.right);
                r.entry = min.entry;
                r.right = recDelete(r.right, min);
            }
            return r;
    }
    private TreeNode<Entry<K,V>> findMin(TreeNode<Entry<K,V>> node) {
        while (node.left != null) node = node.left;
        return node;
    }
    private void deletChild(TreeNode<Entry<K,V>> r, TreeNode<Entry<K,V>> t) {
        if (r == null) return;
        if(r==t){
            r=null;
            if(r.parrent!=null)
                if(r.parrent.left==t)
                    r.parrent.left=null;
                else r.parrent.right=null;
            size--;
            return;
        }
        if(r.entry.getKey().compareTo(t.entry.getKey())<0)
            deletChild(r.right, t);
        else 
            deletChild(r.left, t);

    }


    public TreeNode<Entry<K,V>> search(V v) {
        return recSearch(root, v);
    }
    public TreeNode<Entry<K,V>> recSearch(TreeNode<Entry<K,V>> r, V v){
        if(r.entry.getValue()==v)
            return r;
        if(r.left!=null)
        return recSearch(r.left, v);
        if(r.right!=null)
        return recSearch(r.right, v);
        return null;
    }

    public TreeNode<Entry<K,V>> theHighrdtinLeft(TreeNode<Entry<K,V>> node){
        if(node.left==null&&node.right==null)
            return null;
            if (node == null || node.left == null) return null;
            TreeNode<Entry<K,V>> r = node.left;
            while (r.right != null) {
                r = r.right;
            }
            return r;
    }
