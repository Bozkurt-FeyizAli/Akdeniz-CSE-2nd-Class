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

    @Override
    public E getData() {
        return data;
    }

    @Override
    public void setData(E data) {
        this.data=data;
    }

    @Override
    public NodeInterface<E> getLeft() {
        return left;
    }

    @Override
    public void setLeft(Node<E> left) {
        this.left=left;
    }

    @Override
    public NodeInterface<E> getRight() {
        return right;
    }

    @Override
    public void setRight(Node<E> right) {
        this.right=right;
    }
    
}


interface BinaryTreeInterface {
    void insert(int data);
    boolean search(int data);
    void inorderTraversal();
}
