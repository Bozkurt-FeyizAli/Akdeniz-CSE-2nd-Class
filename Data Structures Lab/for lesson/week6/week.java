public class week{
    public static void main(String[] args) {

        System.out.println(pow(2, 10));
        
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
    int size;

    @Override
    public void insert(E data) {
        Node<E> node= new Node<E>(data);
        if(root==null){
            root=node;
            size++;
            return; }
        Node<E> r=root;
        while(r.getLeft()!=null||r.getRight()!=null){
            if((int)data>(int)r.getData())
                r=r.getRight();
            else if((int)data<(int)r.getData())
                r=r.getRight();
            else    
                System.out.println("this data is already in the tree");
        }
        if((int)data>(int)r.getData())
            r.setRight(node);;
        if((int)data<(int)r.getData())
            r.setLeft(node);
            size++;
        System.out.println("the data is succesfull added");

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
    
}
