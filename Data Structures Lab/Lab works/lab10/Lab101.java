import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Lab10 {
    public static void main(String[] args) {
        // AVL<Integer> tree = new AVL<>();
        // tree.insert(10);
        // tree.insert(5);
        // tree.insert(15);
        // tree.insert(8);
        // ArrayList<Integer> list = new ArrayList<>();
        // tree.inorder(list);
        // for (Integer integer : list) {
        //     System.out.print(integer + " ");
        // }

        // AVL<Integer> avlTree = new AVL<>();

        // // Test 1: Ekleme işlemi ve AVL dengeleme kontrolü
        // System.out.println("Test 1: Ekleme ve dengeleme");
        // avlTree.insert(10);
        // avlTree.insert(20);
        // avlTree.insert(30); // Sağ-sağ dengesizlik: Sol dönüş yapılmalı
        
        // // AVL ağacının kökünü kontrol et
        // System.out.println("Kök: " + avlTree.getRoot().element); // Beklenen: 20
        // System.out.println("Kök sol çocuğu: " + avlTree.getRoot().left.element); // Beklenen: 10
        // System.out.println("Kök sağ çocuğu: " + avlTree.getRoot().right.element); // Beklenen: 30

        // // Test 2: Sol-sağ dengesizliği
        // System.out.println("\nTest 2: Sol-Sağ dönüşü");
        // avlTree.insert(25); // Sol-sağ dengesizlik oluşmalı
        // System.out.println("Kök: " + avlTree.getRoot().element); // Beklenen: 20
        // System.out.println("Kök sağ çocuğu: " + avlTree.getRoot().right.element); // Beklenen: 25

        // // Test 3: Silme işlemi
        // System.out.println("\nTest 3: Silme işlemi ve dengeleme");
        // avlTree.remove(10); // Dengede bir düğüm silinir
        // System.out.println("Kök: " + avlTree.getRoot().element); // Beklenen: 20
        // System.out.println("Kök sol çocuğu: " + (avlTree.getRoot().left != null ? avlTree.getRoot().left.element : "null")); // Beklenen: null
        
        // avlTree.remove(20); // Kök silinir, dengeleme yapılır
        // System.out.println("Yeni kök: " + avlTree.getRoot().element); // Beklenen: 25

        // // Test 4: Daha karmaşık bir ağaç
        // System.out.println("\nTest 4: Daha karmaşık bir ağaç");
        // avlTree.insert(5);
        // avlTree.insert(15);
        // avlTree.insert(35);
        // avlTree.insert(40);
        // avlTree.insert(50);
        
        // System.out.println("Kök: " + avlTree.getRoot().element); // Ağacın dengeli bir kökü olmalı
        // System.out.println("Kök sol çocuğu: " + avlTree.getRoot().left.element);
        // System.out.println("Kök sağ çocuğu: " + avlTree.getRoot().right.element);

    }

    
}

 interface IList<T> {
    int size();
    boolean isEmpty();
 } 

 interface ITree<T> extends IList<T> {
    void insert(T element);
    boolean remove(T element);
    boolean contains(T element);
    void inorder(List<T> list);
    void levelorder(List<T> list);
 }

 interface IAVL<T> extends ITree<T> {
    Node<T> rebalance(Node<T> node);
    Node<T> leftRotate(Node<T> node);
    Node<T> rightRotate(Node<T> node);
    Node<T> doubleRotateLR(Node<T> node);
    Node<T> doubleRotateRL(Node<T> node);
 }

 class Node <T> {
    int height;
    T element;
    Node<T> parent;
    Node<T> left;
    Node<T> right;

    Node(T element) { this.element = element; }
 }

 class BST <T extends Comparable<? super T>> implements ITree<T> {
    protected Node<T> root;
    private int size;

    public Node<T> getRoot() {
        return root;
    }

    public BST() {}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void insert(T element) {
        root = insertRec(root, element);
    }

    protected Node<T> insertRec(Node<T> node, T element) {
        if (node == null) {
            size++;
            return new Node<>(element);
        }

        if (element.compareTo(node.element) < 0) {
            node.left = insertRec(node.left, element);
            node.left.parent = node;
        }

        if (element.compareTo(node.element) > 0) {
            node.right = insertRec(node.right, element);
            node.right.parent = node;
        }

        return node;
    }

    @Override
    public boolean remove(T element) {
        if (contains(element)) {
            root = removeRec(root, element);
            size--;
            return true;
        }
        return false;
    }


    protected Node<T> removeRec(Node<T> node, T element) {
        if (node == null)
            return null;
        if (element.compareTo(node.element) < 0)
            node.left = removeRec(node.left, element);
        else if (element.compareTo(node.element) > 0)
            node.right = removeRec(node.right, element);
        else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            node.element = findMin(node.right);
            node.right = removeRec(node.right, node.element);
        }
        return node;
    }

    private T findMin(Node<T> node) {
        Node<T> current = node;
        while (current.left != null)
            current = current.left;
        return current.element;
    }

    private T findMax(Node<T> node) {
        Node<T> current = node;
        while(current.right != null)
            current = current.right;
        return current.element;
    }

    @Override
    public boolean contains(T element) {
        return containsRec(root, element);
    }

    private boolean containsRec(Node<T> node, T element) {
        if (node == null)
            return false;
        if (element.compareTo(node.element) == 0)
            return true;
        return element.compareTo(node.element) < 0
                ? containsRec(node.left, element)
                : containsRec(node.right, element);
    }

    @Override
    public void inorder(List<T> list) {
        inorderRec(root, list);
    }

    private void inorderRec(Node<T> node, List<T> list) {
        if (node == null)
            return;

        inorderRec(node.left, list);
        list.add(node.element);
        inorderRec(node.right, list);
    }

    @Override
    public void levelorder(List<T> list) {
        if (root == null) {
            return;
        }
    
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
    
        while (!queue.isEmpty()) {
            Node<T> current = queue.poll(); 
            list.add(current.element);    
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }
 }

 class AVL<T extends Comparable<? super T>> extends BST<T> implements IAVL<T> {
    public AVL(){
        super();
    }

    public Node<T> tallerChild(Node<T> node){
        if(node==null)
            return null;
        int leftH=height(node.left);
        int rightH=height(node.right);
        if(node.left==null)
            return node.right;
        if(leftH>rightH)
            return node.left;
        else if(rightH>leftH)
            return node.right;
        else return node.left;
    } 
   

    private int height(Node<T> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalanceFactor(Node<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private void updateHeight(Node<T> node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    @Override
    public Node<T> rebalance(Node<T> node) {
        updateHeight(node);
        int oldH;
        int newH;
        do{
            oldH=node.height;
            if(getBalanceFactor(node)>1||getBalanceFactor(node)<-1){
                node=rebalance(tallerChild(tallerChild(node)));
                updateHeight(leftRotate(node));
                updateHeight(rightRotate(node));
            }
            updateHeight(node);
            newH=node.height;
            node=node.parent;
        }while(oldH!=newH&&node!=null);
        return node;
    }
    @Override
    public void insert(T element) {
        super.insert(element);
        //recUpdateHeight(super.root);
        rebalance(super.root);
    }

    public void recUpdateHeight(Node<T> node){
        if(node==null)
            return;
        if(node.left!=null)
        recUpdateHeight(node.right);
        if(node.right!=null)
        recUpdateHeight(node.left);
        updateHeight(node);
    }

    @Override
    public Node<T> leftRotate(Node<T> node) {
        Node<T> nright=node.right;
        node.right=nright.left;
        if(nright.left!=null)
            nright.left.parent=node;
        nright.parent=node.parent;
        if(node.parent==null)
            root=nright;
        else if(node==node.parent.left)
            node.parent.left=nright;
        else node.parent.right=nright;
        nright.left=node;
        node.parent=nright;
        updateHeight(node);
        updateHeight(nright);
        return nright;
    }

    @Override
    public Node<T> rightRotate(Node<T> node) {
        Node<T> nleft=node.left;
        node.left=nleft.right;
        if(nleft.right!=null)
            nleft.right.parent=node;
        nleft.parent=node.parent;
        if(node.parent==null)
            root=nleft;
        else if(node==node.parent.right)
            node.parent.right=nleft;
        else node.parent.left=nleft;
        nleft.right=node;
        node.parent=nleft;
        updateHeight(node);
        updateHeight(nleft);
        return nleft;
    }

    @Override
    public Node<T> doubleRotateLR(Node<T> node) {
        node.left=leftRotate(node.left);
        return rightRotate(node);
    }

    @Override
    public Node<T> doubleRotateRL(Node<T> node) {
        node.right=rightRotate(node.right);
        return leftRotate(node);
    }
}



