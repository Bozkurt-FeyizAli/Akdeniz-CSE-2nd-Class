import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class a {
    public static void main(String[] args) {
        AVL<Integer> tree = new AVL<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        int i=1;
        tree.leftRotate(tree.root);
        //tree.insert(8);
        ArrayList<Integer> list = new ArrayList<>();
        tree.levelorder(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    //     AVL<Integer> tree = new AVL<>();
    //     tree.insert(10);
    //     tree.insert(5);
    //     tree.insert(15);
    //     tree.insert(8);
    //     ArrayList<Integer> list = new ArrayList<>();
    //     tree.inorder(list);
    //     for (Integer integer : list) {
    //         System.out.print(integer + " ");
    //     }

    //     AVL<Integer> avlTree = new AVL<>();

    //     // Test 1: Ekleme işlemi ve AVL dengeleme kontrolü
    //     System.out.println("Test 1: Ekleme ve dengeleme");
    //     avlTree.insert(10);
    //     avlTree.insert(20);
    //     avlTree.insert(30); // Sağ-sağ dengesizlik: Sol dönüş yapılmalı
        
    //     // AVL ağacının kökünü kontrol et
    //     System.out.println("Kök: " + avlTree.getRoot().element); // Beklenen: 20
    //     System.out.println("Kök sol çocuğu: " + avlTree.getRoot().left.element); // Beklenen: 10
    //     System.out.println("Kök sağ çocuğu: " + avlTree.getRoot().right.element); // Beklenen: 30

    //     // Test 2: Sol-sağ dengesizliği
    //     System.out.println("\nTest 2: Sol-Sağ dönüşü");
    //     avlTree.insert(25); // Sol-sağ dengesizlik oluşmalı
    //     System.out.println("Kök: " + avlTree.getRoot().element); // Beklenen: 20
    //     System.out.println("Kök sağ çocuğu: " + avlTree.getRoot().right.element); // Beklenen: 25

    //     // Test 3: Silme işlemi
    //     System.out.println("\nTest 3: Silme işlemi ve dengeleme");
    //     avlTree.remove(10); // Dengede bir düğüm silinir
    //     System.out.println("Kök: " + avlTree.getRoot().element); // Beklenen: 20
    //     System.out.println("Kök sol çocuğu: " + (avlTree.getRoot().left != null ? avlTree.getRoot().left.element : "null")); // Beklenen: null
        
    //     avlTree.remove(20); // Kök silinir, dengeleme yapılır
    //     System.out.println("Yeni kök: " + avlTree.getRoot().element); // Beklenen: 25

    //     // Test 4: Daha karmaşık bir ağaç
    //     System.out.println("\nTest 4: Daha karmaşık bir ağaç");
    //     avlTree.insert(5);
    //     avlTree.insert(15);
    //     avlTree.insert(35);
    //     avlTree.insert(40);
    //     avlTree.insert(50);
        
    //     System.out.println("Kök: " + avlTree.getRoot().element); // Ağacın dengeli bir kökü olmalı
    //     System.out.println("Kök sol çocuğu: " + avlTree.getRoot().left.element);
    //     System.out.println("Kök sağ çocuğu: " + avlTree.getRoot().right.element);
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
