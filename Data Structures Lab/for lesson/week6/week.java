public class week{
    public static void main(String[] args) {

        BinaryTree<Integer> binaryTree= new BinaryTree<>();
        binaryTree.insert(16);
        binaryTree.insert(32);
        binaryTree.insert(64);
        binaryTree.insert(128);
        binaryTree.insert(256);
        binaryTree.inorderTraversal();
       
        binaryTree.insert(8);
        binaryTree.insert(22);
        binaryTree.insert(40);
        binaryTree.insert(90);
        binaryTree.insert(200);
        binaryTree.inorderTraversal();
        
        
    }

    public static void clearArray(int[] array){
        int index= (int)(Math.random()*array.length);
        array[index]=0;

        for (int i = 0; i < array.length; i++) {
            if(array[i]!=0)
                clearArray(array);
        }
        return;
    }

    public static double pow(double x, int n) {
        if(n<0)
            return 1/pow(x, 0-n);
        if(n==0)
            return 1;
        else{
            double a=pow(x, n/2);
            if(n%2==1)
                return a*a*x;
            else return a*a;
        }
    }
}






interface  NodeInterface<E> {
    E getData();
    void setData(E data);
    NodeInterface<E> getLeft();
    void setLeft(Node<E> left);
    NodeInterface<E> getRight();
    void setRight(Node<E> right);
}

class Node<E> implements NodeInterface<E>{

    private E data;
    private Node<E> left;
    private Node<E> right;

    public Node(E data){
        this.data=data;
    }

    public Node(E data, Node<E> left, Node<E> right){
        this.data=data;
        this.left=left;
        this.right=right;
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
    public Node<E> getLeft() {
        return left;
    }

    @Override
    public void setLeft(Node<E> left) {
        this.left=left;
    }

    @Override
    public Node<E> getRight() {
        return right;
    }

    @Override
    public void setRight(Node<E> right) {
        this.right=right;
    }

    @Override
    public String toString() {
        return data.toString();
    }
    
}


interface BinaryTreeInterface<E> {
    void insert(E data);
    boolean search(E data);
    void inorderTraversal();
}

class BinaryTree<E> implements BinaryTreeInterface<E>{

    private Node<E> root;
    private int size;

    @Override
    public void insert(E data) {
        Node<E> newNode= new Node<>(data);
        if(root==null){
            root= newNode;
            size++; return;
        }
        Node<E> node=root;
        while (node!=null) {
        if((int)data>(int)node.getData()&&node.getRight()==null){
            node.setRight(newNode); break;}
        else if((int)data<(int)node.getData()&&node.getLeft()==null){
            node.setLeft(newNode); break;}
        else if((int)data>(int)node.getData()){
            node=node.getRight();}
        else if((int)data<(int)node.getData()){
            node=node.getLeft(); }
        }
        size++;
    }

    public boolean isEmpty(){
        return size==0;
    }



    @Override
    public boolean search(E data) {
        if(root==null)
            return false;
        Node<E> r=root;
        while (r!=null) {
            if(root.getData()==data)
                return true;
            if((int) data<(int)r.getData())
                r=r.getLeft();
            else r=r.getLeft();
        }
        return false;
    }

    @Override
    public void inorderTraversal() {
        if(root==null)
            return;
        inorderRecursive(root);
    }

    private void inorderRecursive(Node<E> root) {
        if (root != null) {
            inorderRecursive(root.getLeft());
            System.out.print(root.toString() + " ");
            inorderRecursive(root.getRight());
        }
    }

    private void inorderRecursive1(Node<E> root) {
        if (root.getLeft()!= null||root.getRight()!=null) {
            if(root.getLeft()!= null)
                System.out.print(root.getLeft().toString() + " ");
            if(root.getRight()!= null)
                System.out.print(root.getRight().toString() + " ");
            if(root.getLeft()!= null)
                inorderRecursive1(root.getLeft());
            if(root.getRight()!= null)
                inorderRecursive1(root.getRight());
        }
    }

    
}
