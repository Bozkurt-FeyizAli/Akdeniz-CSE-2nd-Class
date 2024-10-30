import java.util.ArrayList;
import java.util.*;

public class Lab061 {
    public static void main(String[] args) {
        Tree<Integer> t= new Tree<>();
        TreeNode<Integer> r= new TreeNode<Integer>(1, null);
        t.addRootChild(r);
        TreeNode<Integer> r1= new TreeNode<Integer>(1, null);
        TreeNode<Integer> r2= new TreeNode<Integer>(1, null);
        TreeNode<Integer> r3= new TreeNode<Integer>(1, null);
        TreeNode<Integer> r4= new TreeNode<Integer>(1, null);
        r.addChild(r4);
        System.out.println(t.getDepth(r4));
	// RG)S*6uEmO:GyfG+
    }
}

// TreeNode<E> generic class represents a single node in the tree
/*
 * Data Fields: Data, parent and List of children
 * Constructor(E data, TreeNode<E> parent)
 * Methods:
 *      Accessors for fields
 *      addChild(TreeNode<E> child)
 */

class TreeNode<E> {
    private TreeNode<E> parent;
    private E data;
    private List<TreeNode<E>> children;

    public TreeNode(E data, TreeNode<E> parent){
        this.parent=parent;
        this.data=data;
        children= new ArrayList<>();
    }

    public List<TreeNode<E>> getChildren() {
        return children;
    }
    public E getData() {
        return data;
    }

    public void addChild(TreeNode<E> child){
        children.add(child);
    }
    public TreeNode<E> getParent() {
        return parent;
    }

}


 // GeneralTree<E> generic class represents a tree
 /*
  * Data Fields: TreeNode<E> root
  * Constructor: Tree() sets root as null
  * Methods:
  *     addRootChild(TreeNode<E> data)
  *     getHeight(TreeNode<E> node)
  *     getDepth(TreeNode<E> node)
  *     preorder(TreeNode<E> node)
  *     postorder(TreeNode<E> node)
  */


class Tree<E>{
    private TreeNode<E> root;
    private int size;
    

    public Tree(){
        root=null;

    }
    public Tree(E data){
        root=new TreeNode<>(data, null);

    }

    public boolean isEmpty(){
        return size==0;

    }

    /*,public void addRootChild(E data){
        TreeNode<E> treeNode= new TreeNode<E>(data, null);
        if(root==null)
            root=treeNode;
        else 
            root.addChild(treeNode);

    } */

    public void addRootChild(TreeNode<E> node){
        if(root==null)
            root=node;
        else 
            root.addChild(node);
        size++;

    }

    public int getDepth(TreeNode<E> node){
        /*if(node== root)
            return 0;
        int height=0;
        for (TreeNode<E> child : root.getChildren()) {
            
        } */

        Queue<TreeNode<E>> queue= new LinkedList<>();
        queue.offer(root);
        int depth=0;
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                var current=queue.poll();
                if(current==node)
                    return depth;
                for (TreeNode<E> treeNode : current.getChildren()) {
                    queue.offer(treeNode);
                }
            }
            depth++;
        }

        /*
         * if(node==null)
            return -1;
        return 1+ getDepth(node.getParent());
         */




        return -1;
    }

    public int getHeight(TreeNode<E> node){
        /*
         * if(node==null)
            return 0;
        int index=0;
        while(node.getParent()!=null){
            node=node.getParent();
            index++;
        }   getdepth;;;;;;;;
         */

        if(node==null)
            return 0;
        int max=0;
        for (TreeNode<E> child : node.getChildren()) {
            max=Math.max(max, getHeight(child)+1);
        }

        return max+1;



        
        //return index;
    }


// önce cocok ya da data  inordera bak   ,   binary tree 
    
}
