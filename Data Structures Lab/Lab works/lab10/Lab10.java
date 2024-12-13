import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lab10 {
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
