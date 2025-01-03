import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class trees{
    
    public static void main(String[] args) {
        BTS<Integer> binaryTree= new BTS<>();
        binaryTree.insert(16);
        binaryTree.insert(32);
        binaryTree.insert(64);
        binaryTree.insert(128);
        binaryTree.insert(256);
        binaryTree.insert(8);
        binaryTree.insert(22);
        binaryTree.insert(40);
        binaryTree.insert(90);
        binaryTree.insert(200);
        System.out.println(binaryTree.search(8));
        //binaryTree.inorderTraversal();
        //binaryTree.postorderTraversal(binaryTree.getRoot());
        
    }
}

interface BinaryTreeInterface<E> {
    void insert(E data); 
    boolean search(E data);
    void inorderTraversal();
    void preorderTraversal(BinaryTreeNodeInterface<E> node);
    void postorderTraversal(BinaryTreeNodeInterface<E> node);
}

class BinaryTree<E> implements BinaryTreeInterface<E>{
    private BinaryTreeNodeInterface<E> root;
    private int size;

    public BinaryTree(){
        root=null;
    }
    public BinaryTree(E data){
        root=new BinaryTreeNode<>(data);
    }

    @Override
    public void insert(E data) {
        BinaryTreeNodeInterface<E> node= new BinaryTreeNode<>(data);
        if(root==null)
            root=node;
        else{
            BinaryTreeNodeInterface<E> r=root;
            while(r!=null){
                if((int)data>(int)r.getData())
                    if(r.getRight()==null){
                        r.setRight(node);
                        return;
                    }
                    else
                        r=r.getRight();
                else if((int)data<(int)r.getData())
                    if(r.getLeft()==null){
                        r.setLeft(node);
                        return;
                    }
                    else
                        r=r.getLeft();
                else 
                    System.out.println("this data is already exist");

            }
        }
        size++;
    }

    @Override
    public boolean search(E data) {
        return recursiveSearch(data, root);
    }
    public boolean recursiveSearch(E data, BinaryTreeNodeInterface<E> node){
        if(node ==null)
            return false;
        if(node.getData().equals(data))
            return true;
        if((int)node.getData()>(int)data)
        return recursiveSearch(data, node.getLeft());
        return recursiveSearch(data, node.getRight());
    }


    @Override
    public void inorderTraversal() {
        if(root==null)
            return;
        recursiveInorderTraversal(root);
    }

    public void recursiveInorderTraversal(BinaryTreeNodeInterface<E> node){
        if(node!=null){
            recursiveInorderTraversal(node.getLeft());
            System.out.println(node.toString());
            recursiveInorderTraversal(node.getRight());
        }
    }

    @Override
    public void preorderTraversal(BinaryTreeNodeInterface<E> node) {
        if(node==null)
            return;
        System.out.println(node.toString());
        preorderTraversal(node.getLeft());
        preorderTraversal(node.getRight());
    }

    @Override
    public void postorderTraversal(BinaryTreeNodeInterface<E> node) {
        if(node==null)
            return;
        postorderTraversal(node.getLeft());
        postorderTraversal(node.getRight());
        System.out.println(node.toString());
        
    }

    public BinaryTreeNodeInterface<E> getRoot() {
        return root;
    }

}

interface BSTInterface<E> {
    void insert(E data);
    boolean search(E data);
    void delete(E data);
    void inorderTraversal();
}

class BTS<E> implements BSTInterface<E>{
    private BSTNodeInterface<E> root;
    private int size;

    public BTS(E data){
        root= new BSTNode<>(data);
        size=0;
    }
    public BTS(){
        root=null;
        size=0;
    }

    @Override
    public void insert(E data) {
        BSTNodeInterface<E> node= new BSTNode<>(data);
        BSTNodeInterface<E> r=root;
        recursiveInsert(node, r);
        /* 
        if(root==null)
            root=node;
        else{
            BSTNodeInterface<E> r=root;
            while (r!=null) {
                if((int)r.getData()>(int)data){
                    if(r.getLeft()==null){
                        r.setLeft(r);
                        break;
                    }
                    else 
                        r=r.getLeft();
                }
                else if(data.equals(r.getData())){
                    System.out.println("data is exist");
                }
                else{
                    if(r.getRight()==null){
                        r.setRight(node);
                        break;
                    }
                    else 
                        r=r.getRight();
                }   
            }
        }
            */
        size++;
        
    }

    public void recursiveInsert(BSTNodeInterface<E> node, BSTNodeInterface<E> r ){
        if(r==null)
            r=node;
        else if(r.getData().equals(node.getData()))
            System.out.println("data is exist");
        else if((int)r.getData()>(int)node.getData())
            recursiveInsert(node.getLeft(), r);
        else 
            recursiveInsert(node.getRight(), r);
    }


    @Override
    public boolean search(E data) {

        return recursiveSearch(data, root);
/* 
        if(root==null)
            return false;
        if(root.getData().equals(data))
            return true;
        BSTNodeInterface<E> r=root;
        while (r!=null) {
            if(data.equals(r.getData()))
                return true;
            else if((int)r.getData()>(int)data)
                r=r.getLeft();
            else 
                r=r.getRight();
        }
        return false;
        */
    }

    public boolean recursiveSearch(E data, BSTNodeInterface<E> node){
        if(node==null)
            return false;
        if(node.getData().equals(data))
            return true;
        if((int)node.getData()>(int)data)
            return recursiveSearch(data, node.getLeft());
            return recursiveSearch(data, node.getRight());
    }

    @Override
    public void delete(E data) {
        if(root==null)
            return;
        BSTNodeInterface<E> r=root;
        while (r!=null) {
            if(data.equals(r.getData()))
                r=null;
            else if((int)r.getData()>(int)data)
              r.getRight();
            else r=r.getLeft();
        }
    }

    @Override
    public void inorderTraversal() {
        if(root==null)
            return ;
        recursiveInorderTraversal(root);
    }

    public void recursiveInorderTraversal(BSTNodeInterface<E> node){
        if(node!=null){
            recursiveInorderTraversal(node.getLeft());
            System.out.println(node.toString());
            recursiveInorderTraversal(node.getRight());
        }
    }
    
}

interface AVLTreeInterface<E> {
    void insert(E data);
    boolean search(E data);
    void delete(E data);
    void inorderTraversal();
    int height();
    boolean isBalanced();
}

class AVLTree<E> implements AVLTreeInterface<E>{
    private AVLTreeNodeInterface<E> root;

    public AVLTree(){
        root=null;
    }
    public AVLTree(E data){
        root=new AVLTreeNode<>(data);
    }

    @Override
    public void insert(E data) {
        AVLTreeNode<E> node=new AVLTreeNode<>(data);;
        if(root==null){
            root=node;
            return;
        }
        Queue<AVLTreeNodeInterface<E>> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            AVLTreeNodeInterface<E> pop=queue.poll();
            if(pop.getLeft()!=null){
                pop.setLeft(node);
                return;
            }
            else queue.add(pop.getLeft());
            if(pop.getRight()!=null){
                pop.setRight(node);
                return;
            }
            else queue.add(pop.getRight());
        }
        



    }

    

    @Override
    public boolean search(E data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    public boolean recursiveSearch(E data, AVLTreeNodeInterface<E> root) {
        if(root!=null){
            if(root.getData()==data)
                return true;
            if(root.getLeft()!=null)
                return recursiveSearch(data, root.getLeft());
            if(root.getRight()!=null)
                return recursiveSearch(data, root.getRight());
        }
        return false;
    }



    @Override
    public void delete(E data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void inorderTraversal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inorderTraversal'");
    }
    public void recursiveInorderTraversal(AVLTreeNodeInterface<E> root) {
        if(root.getLeft()!=null)
            recursiveInorderTraversal(root.getLeft());
        System.out.println(root.getData().toString());
        if(root.getRight()!=null)
            recursiveInorderTraversal(root.getRight());
    }

    @Override
    public int height() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'height'");
    }

    @Override
    public boolean isBalanced() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isBalanced'");
    }
    
} 

interface NaryTreeInterface {
    void insert(int parentData, int data);
    boolean search(int data);
    void traverse();
}


interface HuffmanTreeInterface {
    void buildTree(Map<Character, Integer> frequencyMap);
    String encode(String input);
    String decode(String encodedString);
}

 interface BinaryTreeNodeInterface<E> {           // done
    E getData();
    void setData(E data);
    BinaryTreeNodeInterface<E> getLeft();
    void setLeft(BinaryTreeNodeInterface<E> left);
    BinaryTreeNodeInterface<E> getRight();
    void setRight(BinaryTreeNodeInterface<E> right);
}

class BinaryTreeNode<E> implements BinaryTreeNodeInterface<E>{         // done
    private E data;
    private BinaryTreeNodeInterface<E> left;
    private BinaryTreeNodeInterface<E> right;

    public BinaryTreeNode(E data){
        setData(data);
    }
    public BinaryTreeNode(E data, BinaryTreeNodeInterface<E> left, BinaryTreeNodeInterface<E> right){
        setData(data);
        setLeft(left);
        setRight(right);
    }

    @Override
    public E getData() {
        return data;
    }

    @Override
    public void setData(E data) {
        this.data=data;
    }

    @Override
    public BinaryTreeNodeInterface<E> getLeft() {
        return left;
    }

    @Override
    public void setLeft(BinaryTreeNodeInterface<E> left) {
        this.left=left;
    }

    @Override
    public BinaryTreeNodeInterface<E> getRight() {
        return right;
    }

    @Override
    public void setRight(BinaryTreeNodeInterface<E> right) {
        this.right=right;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}

interface BSTNodeInterface<E> {  // done
    E getData();
    void setData(E data);
    BSTNodeInterface<E> getLeft();
    void setLeft(BSTNodeInterface<E> left);
    BSTNodeInterface<E> getRight();
    void setRight(BSTNodeInterface<E> right);
}

class BSTNode<E> implements BSTNodeInterface<E>{  // done

    private E data;
    private BSTNodeInterface<E> left;
    private BSTNodeInterface<E> right;

    public BSTNode(E data){
        setData(data);
    }
    public BSTNode(E data, BSTNodeInterface<E> left, BSTNodeInterface<E> right){
        setData(data);
        setLeft(left);
        setRight(right);
    }

    @Override
    public E getData() {
        return data;
    }

    @Override
    public void setData(E data) {
        this.data=data;
    }

    @Override
    public BSTNodeInterface<E> getLeft() {
        return left;
    }

    @Override
    public void setLeft(BSTNodeInterface<E> left) {
        this.left=left;
    }

    @Override
    public BSTNodeInterface<E> getRight() {
        return right;
    }

    @Override
    public void setRight(BSTNodeInterface<E> right) {
        this.right=right;
    }
    
}

interface AVLTreeNodeInterface<E> {
    E getData();
    void setData(E data);
    AVLTreeNodeInterface<E> getLeft();
    void setLeft(AVLTreeNodeInterface<E> left);
    AVLTreeNodeInterface<E> getRight();
    void setRight(AVLTreeNodeInterface<E> right);
    int getHeight();
    void setHeight(int height);
}

class AVLTreeNode<E> implements AVLTreeNodeInterface<E>{
    private E data;
    private AVLTreeNodeInterface<E> left;
    private AVLTreeNodeInterface<E> right;
    private int height;

    public AVLTreeNode(E data){
        setData(data);
    }
    public AVLTreeNode(E data, AVLTreeNodeInterface<E> left, AVLTreeNodeInterface<E> right){
        setData(data);
        setLeft(left);
        setRight(right);
    }
    @Override
    public E getData() {
        return data;
    }
    @Override
    public void setData(E data) {
        this.data=data;
    }
    @Override
    public AVLTreeNodeInterface<E> getLeft() {
        return left;
    }
    @Override
    public void setLeft(AVLTreeNodeInterface<E> left) {
       this.left=left;

    }
    @Override
    public AVLTreeNodeInterface<E> getRight() {
       return right;
    }
    @Override
    public void setRight(AVLTreeNodeInterface<E> right) {
        this.right=right;
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public void setHeight(int height) {
        this.height=height;
    }
}

 interface NaryTreeNodeInterface<E> {
    E getData();
    void setData(E data);
    List<NaryTreeNodeInterface<E>> getChildren();
    void addChild(NaryTreeNodeInterface<E> child);
}

class NaryTreeNode<E> implements NaryTreeNodeInterface<E>{
    private E data;
    private List<NaryTreeNodeInterface<E>> children;
    

    public NaryTreeNode(E data){
        setData(data);
        children= new ArrayList<>();
    }
    public NaryTreeNode(E data, List<NaryTreeNodeInterface<E>> children){
        setData(data);
        this.children= new ArrayList<>();
        this.children.addAll(children);
    }
    @Override
    public E getData() {
        return data;
    }
    @Override
    public void setData(E data) {
        this.data=data;
    }
    @Override
    public List<NaryTreeNodeInterface<E>> getChildren() {
        return children;
    }
    @Override
    public void addChild(NaryTreeNodeInterface<E> child) {
        children.add(child);
    }
}

interface HuffmanTreeNodeInterface<E> {
    E getData();
    void setData(E data);
    int getFrequency();
    void setFrequency(int frequency);
    HuffmanTreeNodeInterface<E> getLeft();
    void setLeft(HuffmanTreeNodeInterface<E> left);
    HuffmanTreeNodeInterface<E> getRight();
    void setRight(HuffmanTreeNodeInterface<E> right);
}

class HuffmanTreeNode<E> implements HuffmanTreeNodeInterface<E>{
    private E data;
    private int frequency;
    private HuffmanTreeNodeInterface<E> left;
    private HuffmanTreeNodeInterface<E> right;

    public HuffmanTreeNode(E data){
        setData(data);
    }
    public HuffmanTreeNode(E data, HuffmanTreeNodeInterface<E> left, HuffmanTreeNodeInterface<E> right){
        setData(data);
        setLeft(left);
        setRight(right);
    }
    
    @Override
    public E getData() {
        return data;
    }

    @Override
    public void setData(E data) {
        this.data=data;
    }

    @Override
    public int getFrequency() {
       return frequency;
    }

    @Override
    public void setFrequency(int frequency) {
        this.frequency= frequency;
    }

    @Override
    public HuffmanTreeNodeInterface<E> getLeft() {
        return left;
    }

    @Override
    public void setLeft(HuffmanTreeNodeInterface<E> left) {
       
        this.left=left;
    }

    @Override
    public HuffmanTreeNodeInterface<E> getRight() {
        return right;
    }

    @Override
    public void setRight(HuffmanTreeNodeInterface<E> right) {
        this.right=right;
    }

}
















/*
 * Temel Binary Tree Oluşturma:

Bir BinaryTree sınıfı oluşturun.

Bu sınıfın içine düğümler için Node sınıfını dahil edin.

Ağaca eleman eklemek, aramak ve inorder, preorder, postorder traversal işlemlerini gerçekleştiren yöntemler yazın.

Binary Search Tree (BST) Uygulaması:

Bir BinarySearchTree sınıfı oluşturun.

Bu sınıfın içerisine düğümler için BSTNode sınıfını dahil edin.

BST özelliklerini karşılayacak şekilde eleman eklemek, aramak ve silmek için yöntemler yazın.

AVL Ağacı:

AVL ağacı dengeli bir binary search tree'dir. Bu ağacı temsil eden bir AVLTree sınıfı oluşturun.

Düğüm sınıfı, her düğümün yüksekliğini ve alt düğümlerini içermeli.

Eleman ekleme ve silme işlemleri sırasında ağacın dengede kalmasını sağlayan yeniden düzenleme (rotasyon) yöntemlerini yazın.

N-ary Ağacı:

Bir NaryTree sınıfı oluşturun.

Her düğümün birden fazla çocuğu olabilen bir NaryNode sınıfı oluşturun.

Ağaca eleman ekleme, arama ve çeşitli dolaşım (traversal) yöntemleri ekleyin.

Huffman Ağacı:

Huffman algoritmasını kullanarak bir HuffmanTree sınıfı oluşturun.

Her düğümün karakter ve frekans bilgilerini içeren bir HuffmanNode sınıfı oluşturun.

Kodlama ve kod çözme işlemleri için yöntemler yazın.

Her sorunun ardından, yazdığınız sınıfları test etmek için örnek kullanım kodları da ekleyebilirsiniz. Başka bir şey mi lazım? Let’s dive deeper!




You
bunlaarı interface şeklinde verki daha kolya yazayım methodlaeın ne yapması gerektiğiini açıkla
Copilot
Tabii, işte Java'da gerekli interfaceler ve metodların ne yapması gerektiğine dair açıklamalar:

1. Temel Binary Tree Interface
java

Copy
public interface BinaryTreeInterface {
    void insert(int data); 
    boolean search(int data);
    void inorderTraversal();
    void preorderTraversal();
    void postorderTraversal();
}
insert(int data): Ağaca bir eleman ekler.

search(int data): Ağacın içinde bir elemanın olup olmadığını kontrol eder.

inorderTraversal(): Ağacı inorder olarak dolaşır ve elemanları yazdırır.

preorderTraversal(): Ağacı preorder olarak dolaşır ve elemanları yazdırır.

postorderTraversal(): Ağacı postorder olarak dolaşır ve elemanları yazdırır.

2. Binary Search Tree (BST) Interface
java

Copy
public interface BSTInterface {
    void insert(int data);
    boolean search(int data);
    void delete(int data);
    void inorderTraversal();
}
insert(int data): BST'ye bir eleman ekler.

search(int data): Belirli bir elemanın var olup olmadığını kontrol eder.

delete(int data): Belirtilen elemanı ağaçtan siler.

inorderTraversal(): BST'yi inorder olarak dolaşır ve elemanları yazdırır.

3. AVL Ağacı Interface
java

Copy
public interface AVLTreeInterface {
    void insert(int data);
    boolean search(int data);
    void delete(int data);
    void inorderTraversal();
    int height();
    boolean isBalanced();
}
insert(int data): AVL ağacına bir eleman ekler ve ağacı dengeler.

search(int data): Belirli bir elemanın var olup olmadığını kontrol eder.

delete(int data): Belirtilen elemanı ağaçtan siler ve ağacı dengeler.

inorderTraversal(): Ağacı inorder olarak dolaşır ve elemanları yazdırır.

height(): Ağacın yüksekliğini döner.

isBalanced(): Ağacın dengeli olup olmadığını kontrol eder.

4. N-ary Ağacı Interface
java

Copy
public interface NaryTreeInterface {
    void insert(int parentData, int data);
    boolean search(int data);
    void traverse();
}
insert(int parentData, int data): Belirtilen ebeveyn düğümüne bir çocuk düğüm ekler.

search(int data): Ağacın içinde bir elemanın var olup olmadığını kontrol eder.

traverse(): Ağacı dolaşır ve elemanları yazdırır.

5. Huffman Ağacı Interface
java

Copy
public interface HuffmanTreeInterface {
    void buildTree(Map<Character, Integer> frequencyMap);
    String encode(String input);
    String decode(String encodedString);
}
buildTree(Map<Character, Integer> frequencyMap): Verilen frekans haritasına dayanarak Huffman ağacını oluşturur.

encode(String input): Giriş stringini Huffman kodlama kullanarak kodlar.

decode(String encodedString): Kodlanmış stringi çözerek orijinal haline getirir.

Her bir interface'in metodları, ilgili sınıflarda uygun şekilde implement edilmelidir. Başka soruların var mı?




You
gerekli node classlarının interfacelerini de ver
Copilot
Tabii, işte her biri için gerekli Node interfaceleri:

Binary Tree Node Interface
java

Copy
public interface BinaryTreeNodeInterface {
    int getData();
    void setData(int data);
    BinaryTreeNodeInterface getLeft();
    void setLeft(BinaryTreeNodeInterface left);
    BinaryTreeNodeInterface getRight();
    void setRight(BinaryTreeNodeInterface right);
}
getData(): Düğümdeki veriyi döner.

setData(int data): Düğümdeki veriyi ayarlar.

getLeft(): Sol çocuğu döner.

setLeft(BinaryTreeNodeInterface left): Sol çocuğu ayarlar.

getRight(): Sağ çocuğu döner.

setRight(BinaryTreeNodeInterface right): Sağ çocuğu ayarlar.

Binary Search Tree (BST) Node Interface
java

Copy
public interface BSTNodeInterface {
    int getData();
    void setData(int data);
    BSTNodeInterface getLeft();
    void setLeft(BSTNodeInterface left);
    BSTNodeInterface getRight();
    void setRight(BSTNodeInterface right);
}
getData(): Düğümdeki veriyi döner.

setData(int data): Düğümdeki veriyi ayarlar.

getLeft(): Sol çocuğu döner.

setLeft(BSTNodeInterface left): Sol çocuğu ayarlar.

getRight(): Sağ çocuğu döner.

setRight(BSTNodeInterface right): Sağ çocuğu ayarlar.

AVL Ağacı Node Interface
java

Copy
public interface AVLTreeNodeInterface {
    int getData();
    void setData(int data);
    AVLTreeNodeInterface getLeft();
    void setLeft(AVLTreeNodeInterface left);
    AVLTreeNodeInterface getRight();
    void setRight(AVLTreeNodeInterface right);
    int getHeight();
    void setHeight(int height);
}
getData(): Düğümdeki veriyi döner.

setData(int data): Düğümdeki veriyi ayarlar.

getLeft(): Sol çocuğu döner.

setLeft(AVLTreeNodeInterface left): Sol çocuğu ayarlar.

getRight(): Sağ çocuğu döner.

setRight(AVLTreeNodeInterface right): Sağ çocuğu ayarlar.

getHeight(): Düğümün yüksekliğini döner.

setHeight(int height): Düğümün yüksekliğini ayarlar.

N-ary Ağacı Node Interface
java

Copy
import java.util.List;

public interface NaryTreeNodeInterface {
    int getData();
    void setData(int data);
    List<NaryTreeNodeInterface> getChildren();
    void addChild(NaryTreeNodeInterface child);
}
getData(): Düğümdeki veriyi döner.

setData(int data): Düğümdeki veriyi ayarlar.

getChildren(): Çocuk düğümleri döner.

addChild(NaryTreeNodeInterface child): Bir çocuk düğüm ekler.

Huffman Ağacı Node Interface
java

Copy
public interface HuffmanTreeNodeInterface {
    char getCharacter();
    void setCharacter(char character);
    int getFrequency();
    void setFrequency(int frequency);
    HuffmanTreeNodeInterface getLeft();
    void setLeft(HuffmanTreeNodeInterface left);
    HuffmanTreeNodeInterface getRight();
    void setRight(HuffmanTreeNodeInterface right);
}
getCharacter(): Düğümdeki karakteri döner.

setCharacter(char character): Düğümdeki karakteri ayarlar.

getFrequency(): Düğümdeki frekansı döner.

setFrequency(int frequency): Düğümdeki frekansı ayarlar.

getLeft(): Sol çocuğu döner.

setLeft(HuffmanTreeNodeInterface left): Sol çocuğu ayarlar.

getRight(): Sağ çocuğu döner.

setRight(HuffmanTreeNodeInterface right): Sağ çocuğu ayarlar.
 */