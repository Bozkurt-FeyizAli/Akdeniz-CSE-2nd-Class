
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
    public TreeNode<Entry<K,V>> theLowestinRight(TreeNode<Entry<K,V>> node){
        if(node.left==null&&node.right==null)
            return null;
            TreeNode<Entry<K,V>> r = node.right;
            while (r.left != null) {
                r = r.left;
            }
            return r;
    }
    public void swap(TreeNode<Entry<K,V>> a, TreeNode<Entry<K,V>> b){
        if(a!=null&&b!=null){
        Entry<K, V> a1=a.entry;
        a.entry=b.entry;
        b.entry=a1;
        }
        else{
            System.out.println("problem so that swap");
        }
    }

    public void inorderTraversal() {
        recInorderTraversal(root);
    }
    public void recInorderTraversal(TreeNode<Entry<K,V>> r) {
        if (r == null) return;
        recInorderTraversal(r.left);
        System.out.println(r.entry.getValue());
        recInorderTraversal(r.right);
    }
    
}

class AVLTree {
    // Node class
    static class Node {
        int key, height;
        Node left, right, parent;

        Node(int key) {
            this.key = key;
            height = 1; // Height is initially 1
            left = right = null;
        }
    }

    private Node root;

    public AVLTree() {
        root = null;
    }

    public void insert(int key) {
        // To be implemented
    }

    public void delete(int key) {
        // To be implemented
    }

    public Node search(int key) {
        // To be implemented
        return recSearvh(root, key);
    }

    public Node recSearvh(Node n, int k){
        if(n.key==k)
            return n;
        else if(n.key>k)
            return recSearvh(n.right, k);
        else if(n.key<=k)
            recSearvh(n.left, k);
        return null;
        
    }

    private int getHeight(Node node) {
        // To be implemented
        if(node==null)
        return 1;
        int l=-1;
        int r=-1;
        if(node.left!=null)
            l=getHeight(node.left);
        if(node.right!=null)
            r=getHeight(node.right);
        return Math.max(l, r);
    }

    private int getBalanceFactor(Node node) {
        // To be implemented
        return 0;
    }

    public void leftRotation(Node root, Node rigthChild, Node RRigrhChild){
        root.right=rigthChild.left;
        if (rightChild.left != null) 
        rightChild.left.parent = root;
        rigthChild.left=root;
        if(root.parent!=null)
            if(root.parent.right==root)
                root.parent.right=rigthChild;
            else root.parent.left=rigthChild;
        rightChild.parent = root.parent;
        root.parent=rigthChild;
    }

    public void rightRotation(Node root, Node leftChild, Node LLeftChild){
        root.left=leftChild.right;
        leftChild.right.parent=root;
        leftChild.right=root;
        if(root.parent.right==root)
            root.parent.right=leftChild;
        else root.parent.left=leftChild;
        root.parent=leftChild;
    }

    public void dleftRightR(Node root, Node lefthChild, Node lRigrhChild){
        leftRotation(lefthChild, lRigrhChild, null);
        rightRotation(root, lRigrhChild, lefthChild);
    }
    public void dRightLeft(Node root, Node rightChild, Node rLeftChild){
        rightRotation(rightChild, rLeftChild, null);
        leftRotation(root, rLeftChild, rightChild);
    }
}


class SplayTree {
    // Node class
    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root;

    public SplayTree() {
        root = null;
    }

    public void insert(int key) {
        // To be implemented
    }

    public void delete(int key) {
        // To be implemented
    }

    public Node search(int key) {
        // To be implemented
        return null;
    }

    private Node splay(Node root, int key) {
        // To be implemented
        return null;
    }

    private Node rotateLeft(Node node) {
        // To be implemented
        return null;
    }

    private Node rotateRight(Node node) {
        // To be implemented
        return null;
    }
}


class Entry <K extends Comparable <? super K>, V> implements Comparable<K> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int compareTo(K o) {
        return key.compareTo(o);
    }
} 

class TreeNode <T> {
    T entry;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parrent;

    public TreeNode(T entry) {
        this.entry = entry;
    }

}