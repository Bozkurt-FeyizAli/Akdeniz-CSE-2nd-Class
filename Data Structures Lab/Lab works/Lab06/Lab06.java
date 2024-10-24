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
    private ArrayList<TreeNode<E>> listOfChildren;
    private TreeNode<E> parent;

    public TreeNode(E data, TreeNode<E> parent){
        this.data=data;
        this.parent=parent;
        listOfChildren= new ArrayList<>();
    }

    public void addChild(TreeNode<E> child){
        listOfChildren.add(child);
    }

    public E getData() {
        return data;
    }
    public ArrayList<TreeNode<E>> getChildren() {
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

    public void addRootChild(E data){
        if(root!=null)
            root.addChild(new TreeNode<>(data, root));
    }

    public int getHeight(TreeNode<E> node){
        if(root==null||root.getChildren()==null)
            return 0;
        int height=0;
        for (TreeNode<E> child : root.getChildren()) {
            int h=0;
            for (TreeNode<E> c : child.getChildren()) {
                h++;
            }
            if(h>height)
                height=h;
        }
        return height+1;
    }

    public int getDepth(TreeNode<E> node){
        if(root==null||root.getParent()==null)
            return 0;
        int result=0;
        while (node.getParent()!=null) {
            result++;
            node=node.getParent();
        }
        return result;
    }
  }
