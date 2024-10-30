import java.util.Scanner;

public class GeneralTreeTest {
    private static GeneralTree<String> tree = new GeneralTree<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        // Başlangıç kök düğümünü ekle
        tree.addRootChild("root");

        while (!exit) {
            displayMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addChild();
                    break;
                case 2:
                    displayPreorder();
                    break;
                case 3:
                    displayPostorder();
                    break;
                case 4:
                    displayHeight();
                    break;
                case 5:
                    displayDepth();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }

        System.out.println("Genel Ağaç uygulamasını kullandığınız için teşekkürler. Hoşça kalın!");
    }

    private static void displayMenu() {
        System.out.println("\n--- Genel Ağaç Ana Menü ---");
        System.out.println("1. Çocuk Ekle");
        System.out.println("2. Preorder Dolaşımı Göster");
        System.out.println("3. Postorder Dolaşımı Göster");
        System.out.println("4. Ağacın Yüksekliğini Göster");
        System.out.println("5. Düğüm Derinliğini Göster");
        System.out.println("0. Çıkış");
        System.out.print("Seçiminizi girin: ");
    }

    private static int getChoice() {
        return scanner.nextInt();
    }

    private static void addChild() {
        System.out.print("Ebeveyn düğüm verisini girin: ");
        String parentData = scanner.next();
        TreeNode<String> parentNode = findNode(tree.getRoot(), parentData);
        if (parentNode != null) {
            System.out.print("Yeni çocuk düğüm verisini girin: ");
            String childData = scanner.next();
            parentNode.getChildren().add(new TreeNode<>(childData, parentNode));
            System.out.println("Çocuk düğüm eklendi.");
        } else {
            System.out.println("Ebeveyn düğüm bulunamadı.");
        }
    }

    private static void displayPreorder() {
        System.out.println("Preorder Dolaşımı: ");
        tree.preorder(tree.getRoot());
        System.out.println();
    }

    private static void displayPostorder() {
        System.out.println("Postorder Dolaşımı: ");
        tree.postorder(tree.getRoot());
        System.out.println();
    }

    private static void displayHeight() {
        System.out.println("Ağacın Yüksekliği: " + tree.getHeight(tree.getRoot()));
    }

    private static void displayDepth() {
        System.out.print("Derinliğini bulmak istediğiniz düğüm verisini girin: ");
        String data = scanner.next();
        TreeNode<String> node = findNode(tree.getRoot(), data);
        if (node != null) {
            System.out.println(data + " düğümünün derinliği: " + tree.getDepth(node));
        } else {
            System.out.println("Düğüm bulunamadı.");
        }
    }

    private static TreeNode<String> findNode(TreeNode<String> root, String data) {
        if (root == null) {
            return null;
        }
        if (root.getData().equals(data)) {
            return root;
        }
        for (TreeNode<String> child : root.getChildren()) {
            TreeNode<String> result = findNode(child, data);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
