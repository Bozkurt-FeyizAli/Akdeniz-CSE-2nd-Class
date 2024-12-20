import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lab11 {
    public static void main(String[] args) {

        
        RBTree<Integer> tree = new RBTree<>();
        tree.insert(4);
        tree.insert(2);
        tree.insert(7);
        tree.insert(6);
    
        List<Integer> list = new ArrayList<>();
        tree.levelorder(list);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        
    }

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

interface IRB<T> extends ITree<T> {
    Node<T> leftRotate(Node<T> node);
    Node<T> rightRotate(Node<T> node);
    Node<T> reconstruction(Node<T> node);
    void recolor(Node<T> node);
}

class Node<T> {
    boolean color; // False: black, True: red
    T element;
    Node<T> parent;
    Node<T> left;
    Node<T> right;

    Node(T element, boolean color) { 
        this.element = element;
        this.color = color;
    }

    public void changeColor(){
        color=!color;
    }
    public T getElement() {
        return element;
    }
    public Node<T> getLeft() {
        return left;
    }
    public Node<T> getParent() {
        return parent;
    }
    public Node<T> getRight() {
        return right;
    }
    
    public void setColor(boolean color) {
        this.color = color;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
    
  // Simple ASCII-based Tree Visualization
  public static void visualizeTree(RBTree<Integer> tree) {
    System.out.println("Visualizing Tree:");
    printTree(tree.root, "", true);
}

public static void printTree(Node<Integer> node, String prefix, boolean isLeft) {
    if (node == null || node.element == null) {
        return;
    }
    System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.element +
                       (node.color ? " (R)" : " (B)"));
    printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
    printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
}
}

/*
 * Every node is red or black
 * New insertions always red
 * every path from root to leaf has the same # black
 * no path can have two consecutive red
 * every leaf (null) is considered black
 */
class RBTree <T extends Comparable<? super T>> implements IRB<T> {
    Node<T> root;
    private final Node<T> TNULL;
    int size=0;

    public RBTree(){
        TNULL=new Node<>(null, false);
        root=TNULL;
        size=0;
    }
 
    public Node<T> aunt(Node<T> node) { // done
        if(node==null||node.parent==null||node.parent.parent==null)
            return null; 
        Node<T> gparent=node.parent.parent;
        if(node.parent==gparent.left)
            return gparent.right;
        else return gparent.left;
    }

    @Override  // done
    public void insert(T element) {
        Node<T> newNode=new Node<>(element, true);
        newNode.left=TNULL;
        newNode.right=TNULL;

        Node<T> y=null;
        Node<T> x=root;

        while(x!=TNULL){
            y=x;
            if(newNode.element.compareTo(x.element)<0)
                x=x.left;
            else
                x=x.right;
        }
        newNode.parent=y;
        if(y==null||y==TNULL)
            root=newNode;
        else if(newNode.element.compareTo(y.element)<0)
            y.left=newNode;
        else
            y.right=newNode;
        reconstruction(newNode);
        root.color=false;
        size++;
    }
    
    @Override
    public boolean remove(T element) {  // done
        if (contains(element)) {
            root = removeRec(root, element);
            size--;
            return true;
        }
        return false;
    }


    protected Node<T> removeRec(Node<T> node, T element) {  // done
        if(node==TNULL)
            return node;
        if(element.compareTo(node.element)<0)
            node.left=removeRec(node.left, element);
        else if(element.compareTo(node.element)>0)
            node.right=removeRec(node.right, element);
        else{
            if(node.left==TNULL)
                return node.right;
            if(node.right==TNULL)
                return node.left;
            node.element=findMin(node.right);
            node.right=removeRec(node.right, node.element);
        }
        return node;
    }
    private T findMin(Node<T> node) {  // done
        Node<T> current=node;
        while(current.left!=TNULL)
            current=current.left;
        return current.element;
    }

    // private T findMax(Node<T> node) { // done
    //     Node<T> current = node;
    //     while(current.right != TNULL)
    //         current = current.right;
    //     return current.element;
    // }


    @Override
    public boolean contains(T element) { // done
        return recContains(root, element);
    }
 

    public boolean recContains(Node<T> node, T e){ // done
        if(node!=TNULL){
            if(node.element.equals(e))
                return true;
            if(e.compareTo(node.element)>0)
                return recContains(node.right, e);
            else 
                return recContains(node.left, e);
        }
        return false;
    }

    @Override
    public void inorder(List<T> list) {  // done
        recInorder(list, root);
    }

    public void recInorder(List<T> list, Node<T> node){  // done
        if(node==null)
            return;
        recInorder(list, node.left);
        list.add(node.element);
        recInorder(list, node.right);
    }

    @Override
    public void levelorder(List<T> list) {  // done
        if(root==null)
            return;
        Queue<Node<T>> que= new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            Node<T> n=que.poll();
            list.add(n.element);
            if(n.left!=null)
                que.add(n.left);
            if(n.right!=null)
                que.add(n.right);
        }
    }

    @Override
    public int size() {  // done
      return size;
    }

    @Override
    public boolean isEmpty() {  // done
        return size==0;
    }
    @Override
    public Node<T> leftRotate(Node<T> node) {  // done
        Node<T> right=node.right;
        node.right=right.left;
        if(right.left!=null)
            right.left.parent=node;
        right.parent=node.parent;
        if(node.parent==null)
            root=right;
        else if(node==node.parent.left)
            node.parent.left=right;
        else node.parent.right=right;
        right.left=node;
        node.parent=right;
        return right;
    }
    @Override
    public Node<T> rightRotate(Node<T> node) {  // done
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
        return nleft;
    }
   @Override
    public Node<T> reconstruction(Node<T> nNode) {
        while (nNode.parent!=null&&nNode.parent.color){ 
            Node<T> gparent=nNode.parent.parent;
            Node<T> aunt=aunt(nNode);
    
            if(nNode.parent==gparent.left){ 
                if(aunt!=null&&aunt.color){ 
                    nNode.parent.color=false;
                    aunt.color=false;
                    gparent.color=true;
                    nNode=gparent;
                }else{ 
                    if(nNode==nNode.parent.right){
                        nNode=nNode.parent;
                        leftRotate(nNode);
                    }
                    nNode.parent.color=false;
                    gparent.color=true;
                    rightRotate(gparent);
                }
            }else{ 
                if(aunt!=null&&aunt.color){
                    nNode.parent.color=false;
                    aunt.color=false;
                    gparent.color=true;
                    nNode=gparent;
                }else{
                    if(nNode==nNode.parent.left){
                        nNode=nNode.parent;
                        rightRotate(nNode);
                    }
                    nNode.parent.color=false;
                    gparent.color=true;
                    leftRotate(gparent);
                }
            }
            if(nNode==root) break;
        }
        root.color=false;
        return nNode;
    }

     @Override
    public void recolor(Node<T> node) {
        if(node==null||node==TNULL)
            return;
        node.color=!node.color;
        if(node.left!=TNULL)
            node.left.color=!node.left.color;
        if(node.right!=TNULL)
            node.right.color=!node.right.color;
    }

    }