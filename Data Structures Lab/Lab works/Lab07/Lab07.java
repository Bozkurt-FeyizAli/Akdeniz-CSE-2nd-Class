import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import java.util.List;
import java.util.ArrayList;

/*
 * Please don't use any generative AI,
 * 
 * I choose to showcase how to use Strategy design pattern in action,
 * Because of this it may look complicated, but really, it is not
 * 
 * contains method's main implementation of the method will be in
 * DFS and BFS classes. These classes just have 2 methods each, which will be the actual
 * Depth-first search and Breadth-first search implementations.
 * hint: you can use get methods in contains methods
 */
public class Lab07 {
    public static void main(String[] args) {
        BinaryTree<Integer> b= new BinaryTree<>(new BFS<>());
        for (int i = 0; i < 3; i++) {
            b.insert(i);
        }
        System.out.println(b);
        b.delete(1);
        System.out.println(b);
    }
}

interface Search <T> {
    boolean contains(BinaryTree.Node<T> root, T value);
    BinaryTree.Node<T> get(BinaryTree.Node<T> root, T value);
}

/*
 * Binary Tree interface
 */
interface IBinaryTree <T> {
    void insert(T value);
    boolean contains(T value);
    boolean delete(T value);
    int height();
    boolean isEmpty();
    int size();
    void traverse(int order);
}

/*
 * This is not a BST! order in which elements are stored doesn't matter
 * !!Needs to satisfy complete binary tree properties at all times!!
 */
class BinaryTree <T> implements IBinaryTree <T> {
    static class Node <T> {

        private T data;
        private Node <T> left;
        private Node <T> right;

        public Node(T data){
            this.data=data;
            left=null;
            right=null;

        }
        public void setLeft(Node<T> left) {
            this.left = left;
        }
        public void setRight(Node<T> right) {
            this.right = right;
        }
        public T getData() {
            return data;
        }
        public Node<T> getLeft() {
            return left;
        }
        public Node<T> getRight() {
            return right;
        }

        /*
         * no parent reference
         */
    }

    private Node <T> root;
    private int size;
    private Search<T> traversalStrategy;

    public BinaryTree(Search<T> Search){
        this.traversalStrategy=Search;
        size=0;
        root=null;
        
    }
    /*
     * Necessary data fields:
     *  Node root, int size, Search traversalStrategy (only going to use in contains)
     */

    /*
     * Constructor(Search)
     */

    public Node<T> getRoot() {
        /* Convenience method for me to test your code */
        if(root==null)
            return null;
        
        return root;
    }

    /*
     * public boolean delete(T value),for now, it is optional,
     *      ^^ find taret node (node with value), find last node (target) in BFS manner
     *      ^^ (Optional) can use strategy.get(T value) for target, 
     *      ^^ only if strategy is from BFS class, if DFS would be incorrect
     * private boolean deleteLastNode(Node<T> root, Node<T> target) // recursive DFS implementation
     * private int heightRec(Node<T> node) // Recursive helper implemenation
     */

     /*
      * All required methods, additionally below ones
      * private List<T> inorder(Node<T> node) // recursive DFS inorder traversal
      * private List<T> postorder(Node<T> node) // recursive DFS postorder traversal
      * private List<T> preorder(Node<T> node) // recursive DFS preorder traversal
      * private List<T> levelorder(Node<T> node) // iterative BFS levelorder traversal
      * return a list with values, order matters, optionally print to observer
      */

      /*
       * public void traverse(int order)
       * Simply, use switch-case to determine traversal technique [1, 2, or 3], by default level-order
       * 1: preorder
       * 2: inorder
       * 3: postorder
       * default: level-order
       */

       /*
        * ===================== toString() ==========================
        * to see the tree, first implement height method
        */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<List<String>> levels = new ArrayList<>();
        int height = height();

        fillLevels(root, levels, 0);


        int maxWidth = (int) Math.pow(2, height) - 1;
        for (int i = 0; i < levels.size(); i++) {
            List<String> level = levels.get(i);
            int gap = (maxWidth / (int) Math.pow(2, i + 1));

            sb.append(" ".repeat(gap));
            for (String s : level) {
                sb.append(s);
                sb.append(" ".repeat(2 * gap + 1));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private void fillLevels(Node<T> node, List<List<String>> levels, int depth) {
        if (depth >= levels.size()) {
            levels.add(new ArrayList<>());
        }
        if (node == null) {
            levels.get(depth).add(" ");
            return;
        }
        levels.get(depth).add(node.data.toString());
        fillLevels(node.left, levels, depth + 1);
        fillLevels(node.right, levels, depth + 1);
    }

    @Override
    public void insert(T value) {
        Node<T> newNode=new Node<>(value);
        if(root==null)
            root=newNode;
        else{
        Queue<BinaryTree.Node<T>> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree.Node<T> node=queue.poll();
            if(node.getLeft()==null){
                node.setLeft(newNode);
                break;
            }
            else    
                queue.add(node.getLeft());
            if(node.getRight()==null){
                node.setRight(newNode);
                break;
            }
            else    
                queue.add(node.getRight());
        }
        }
        size++;
    }

    private boolean deleteLastNode(Node<T> root, Node<T> target){
        if(root==null)
        return false;
        if(root.getLeft()==target){
            root.setLeft(null);
            return true;}
        if(root.getRight()==target){
            root.setRight(null);
            return true;
        }
            if(!(deleteLastNode(root.getLeft(), target)))
            return deleteLastNode(root.getRight(), target);
            return true;
        
        
    }

        

    private List<T> inorder(Node<T> node){
        
        List<T> result= new ArrayList<>();
        return recursiveInorder(node, result);
    }
    public List<T> recursiveInorder(Node<T> node, List<T> result){
        if(node!=null){
            recursiveInorder(node.getLeft(), result);
            result.add(node.getData());
            System.out.println(node.getData());
            recursiveInorder(node.getRight(), result);
        }
        return result;

    }

    private List<T> postorder(Node<T> node){
        List<T> result=new ArrayList<>();
        return recursivePostorder(node, result);
    }

    public List<T> recursivePostorder(Node<T> node, List<T> result){
        if(node!=null){
            recursivePostorder(node.getLeft(), result);
            recursivePostorder(node.getRight(), result);
            result.add(node.getData());
            System.out.println(node.getData());
        }
        return result;
    }
    private List<T> preorder(Node<T> node){
        List<T> result= new ArrayList<>();
        return recursivePreorder(node, result);
    }

    public List<T> recursivePreorder(Node<T> node, List<T> result){
        if(node!=null){
            result.add(node.getData());
            System.out.println(node.getData());
            recursivePreorder(node.getLeft(), result);
            recursivePreorder(node.getRight(), result);
        }
        return result;
    }

    private List<T> levelorder(Node<T> node) {
        if(node==null)
            return null;
        Queue<T> queue= new LinkedList<>();
        List<T> result= new ArrayList<>();
        queue.add(root.getData());

        while (!queue.isEmpty()) {
            T t=queue.poll();
            result.add(t);
            if(root.getLeft()!=null)
                queue.add(root.getLeft().getData());
            if(root.getRight()!=null)
                queue.add(root.getRight().getData());
        }

        return result;
    }

    public Node<T> lastNode(Node<T> root){
        if(root==null)
            return null;
            int last=0;
            Queue<BinaryTree.Node<T>> queue= new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                if(last+1==size)
                    break;
                BinaryTree.Node<T> node=queue.poll();
                if(node.getLeft()!=null)
                    queue.add(node);
                if(node.getRight()!=null)
                    queue.add(node.getRight());
                    last++;
            }

            return queue.poll();

    }

    

    




    @Override
    public boolean contains(T value) {
        return recursiveContains(value, root);
    }

    public boolean recursiveContains(T value, Node<T> node) {
        if(node!=null){
            if(node.getData()==value){
                return true;
            }
            recursiveContains(value, node.getLeft());
            recursiveContains(value, node.getRight());
        }
        return false;
    }

    @Override
    public boolean delete(T value) {
        if(!traversalStrategy.contains(root, value))
        return false;
        Node<T> target=traversalStrategy.get(root, value);
        Node<T> last=lastNode(root);
        T temp=target.getData();
        target.data=last.getData();
        last.data=temp;
        return deleteLastNode(root, last);
    }

    @Override
    public int height() {
        return recursiveHeight(root);
    }
    
    public int recursiveHeight(Node<T> root) {
        if(root==null) return 0;
        return 1+ (int)Math.max(recursiveHeight(root.getLeft()), recursiveHeight(root.getRight()));
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void traverse(int order) {
        switch (order) {
            case 1:
               preorder(root); 
                break;
            case 2:
                inorder(root); 
                 break;
            case 3:
                 postorder(root); 
                  break;
                  default:
                  levelorder(root); 
                   break;
        
        
        }
    }

}

class BFS<T> implements Search<T>{

    @Override
    public boolean contains(BinaryTree.Node<T> root, T value) {
        if(root==null)
            return false;
        Queue<BinaryTree.Node<T>> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree.Node<T> node=queue.poll();
            if(node.getData().equals(value))
                return true;
            if(node.getLeft()!=null)
                queue.add(node.getLeft());
            if(node.getRight()!=null)
                queue.add(node.getRight());

        }
        return false;
    }

    @Override
    public BinaryTree.Node<T> get(BinaryTree.Node<T> root, T value) {
        if(root==null)
            return null;
        Queue<BinaryTree.Node<T>> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree.Node<T> node=queue.poll();
            if(node.getData().equals(value))
                return node;
            if(node.getLeft()!=null)
                queue.add(node.getLeft());
            if(node.getRight()!=null)
                queue.add(node.getRight());

        }
        return null;
    }
    
}

class DFS<T> implements Search<T>{

    @Override
    public boolean contains(BinaryTree.Node<T> root, T value) {
        if(root==null)
            return false;
        Stack<BinaryTree.Node<T>> queue= new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree.Node<T> node=queue.pop();
            if(node.getData().equals(value))
                return true;
            if(node.getLeft()!=null)
                queue.add(node.getLeft());
            if(node.getRight()!=null)
                queue.add(node.getRight());

        }
        return false;
    }

    @Override
    public BinaryTree.Node<T> get(BinaryTree.Node<T> root, T value) {
            if(root==null)
                return null;
            Stack<BinaryTree.Node<T>> queue= new Stack<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryTree.Node<T> node=queue.pop();
                if(node.getData().equals(value))
                    return node;
                if(node.getLeft()!=null)
                    queue.add(node.getLeft());
                if(node.getRight()!=null)
                    queue.add(node.getRight());
    
            }
            return null;
    }
    
}

/*
* concrete BFS generic class which implements Search interface
*/

/*
* concrete DFS generic class which implements Search interface
* ITERATIVE DFS implementation!
*/