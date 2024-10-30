import java.util.ArrayList;
import java.util.List;

public class Lab06 {
    public static void main(String[] args) {
        
    


    }
}


// TreeNode<E> generic class represents a single node in the tree
/*
 * Data Fields: Data, parent and List of getChildren
 * Constructor(E data, TreeNode<E> parent)
 * Methods:
 *      Accessors for fields
 *      addChild(TreeNode<E> child)
 */


 // GeneralTree<E> generic class represents a tree
 /*
  * Data Fields: TreeNode<E> root
  * Constructor: Tree() sets root as null
  * Methods:
  *     addRootChild(E data)
  *     getHeight(TreeNode<E> node)
  *     getDepth(TreeNode<E> node)
  *     preorder(TreeNode<E> node)
  *     postorder(TreeNode<E> node)
  */


  class TreeNode<E>{
    private E data;
    private List<TreeNode<E>> listOfChildren;
    private TreeNode<E> parent;

    public TreeNode(E data, TreeNode<E> parent){
        this.data=data;
        this.parent=parent;
        listOfChildren= new ArrayList<>();
    }

    public TreeNode(E data){
        this.data=data;
        this.parent=null;
        listOfChildren= new ArrayList<>();
    }

    public void addChild(TreeNode<E> child){
        listOfChildren.add(child);
    }

    public E getData() {
        return data;
    }
    public List<TreeNode<E>> getChildren() {
        return listOfChildren;
    }
    public TreeNode<E> getParent() {
        return parent;
    }

  }

  class GeneralTree<E>{
    private TreeNode<E> root;
    public GeneralTree(){
        root=null;
    }
    public GeneralTree(TreeNode<E> node){
        root=node;
    }

    public void addRootChild(E data){
        if(root!=null)
            root.addChild(new TreeNode<>(data, root));
        else
            root=new TreeNode<>(data, root); 
    }

    public int getHeight(TreeNode<E> node){
        
        int h = 0;
        if(node.getChildren()==null)
        for (var a : node.getChildren())
            h = Math.max(h, getDepth(a));
        return h;
    }

    public int getDepth(TreeNode<E> node){
        if(node==root)
            return 0;
        return 1+ getDepth(node.getParent());
    }

    public void preorder(TreeNode<E> node){
        if(node.getParent()==null||node==null)
        return;
        preorder(node.getParent());
        System.out.println(node.getData());
    }

    public void postorder(TreeNode<E> node){
        if(node==null)
            return;
        if(node.getChildren()==null)
            return;
        
        for (var p : node.getChildren()) {
            
            postorder(p);
        }
        System.out.println(p.getData());
    }

    public TreeNode<E> getRoot() {
        return root;
    }
}
