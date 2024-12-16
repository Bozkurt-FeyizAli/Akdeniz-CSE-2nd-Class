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
