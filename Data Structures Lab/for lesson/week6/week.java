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






interface NodeInterface {
    int getData();
    void setData(int data);
    NodeInterface getLeft();
    void setLeft(NodeInterface left);
    NodeInterface getRight();
    void setRight(NodeInterface right);
}


interface BinaryTreeInterface {
    void insert(int data);
    boolean search(int data);
    void inorderTraversal();
}
