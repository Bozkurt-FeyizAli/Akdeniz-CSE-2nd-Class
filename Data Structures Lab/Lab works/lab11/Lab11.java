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
    int size=0;

    public RBTree(){
        root=null;
        size=0;
    }
 


    public Node<T> aunt(Node<T> node) {
        if (node == null || node.parent == null || node.parent.parent == null) {
            return null; 
        }
        Node<T> grandparent = node.parent.parent;
        return (node.parent == grandparent.left) ? grandparent.right : grandparent.left;
    }

    @Override
    public void insert(T element) {
        // TODO Auto-generated method stub
        if(isEmpty()){
            root = new Node(element, false);
            size++;
            return;
        }
        root=insertRec(root,element);
        root.color=false;
    }
    
    public Node<T> findSibling(Node<T> node) {
        if (node == null || node.parent == null) {
            return null; 
        }
        Node<T> parent = node.parent;
        if (parent.left == node) {
            return parent.right;
        } 
        return parent.left;
    }

    public Node<T> insertRec(Node<T> node, T element){
        if(node ==null){
            size++;
            return new Node<>(element, true);
        }
        Node<T> newchild=null;
        if (element.compareTo(node.element) < 0) {
            node.left = insertRec(node.left, element);
            node.left.parent = node;
            newchild=node.left;
        }
        else if (element.compareTo(node.element) > 0) {
            node.right = insertRec(node.right, element);
            node.right.parent = node;
            newchild=node.right;
        }
        if(newchild!=null&&newchild.color==true&& newchild.parent.color==true){
            Node<T> sibling=findSibling(node);
            if(sibling!=null&&sibling.color==true){
               
                recolor(node.parent);
            }
            else{
                Node<T> newSubTree =reconstruction(newchild);
                return newSubTree;
            }
        }return node;
    }


    private boolean isRed(Node<T> node) {
        return node != null && node.color;
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
        return recContains(root, element);
    }
 

    public boolean recContains(Node<T> node, T e){
        if(node!=null){
            if(node.element==e)
                return true;
            if(e.compareTo(node.element)>0)
                return recContains(node.right, e);
            else return recContains(node.left, e);
        }
        return false;
    }

    @Override
    public void inorder(List<T> list) {
        recInorder(list, root);
    }

    public void recInorder(List<T> list, Node<T> node){
        if(node==null)
            return;
        recInorder(list, node.left);
        list.add(node.element);
        recInorder(list, node.right);
    }

    @Override
    public void levelorder(List<T> list) {
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
    public int size() {
      return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public Node<T> leftRotate(Node<T> node) {
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
        return nleft;
    }
   
    public Node<T> reconstruction1(Node<T> nNode) {
        if(nNode.parent.color){
            Node<T> aunt =aunt(nNode);
            if(aunt.color){
                aunt.changeColor();
                nNode.changeColor();
                nNode.parent.changeColor();
            }
            else{
                if(aunt==nNode.parent.parent.left){
                if(nNode.parent.left==nNode){
                    nNode.parent=rightRotate(nNode);
                    nNode.parent=leftRotate(nNode);
                }
                else {
                    nNode.parent=leftRotate(nNode);
                }
            }
                else{
                    if(aunt==nNode.parent.parent.left){
                        if(nNode.parent.left==nNode){
                        nNode.parent=rightRotate(nNode);
                        }
                        else {
                        nNode.parent=leftRotate(nNode);
                        nNode.parent=rightRotate(nNode);
                        }
                    }
                }
            }
        }
        return nNode;
    }
