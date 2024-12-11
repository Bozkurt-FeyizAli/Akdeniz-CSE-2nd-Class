import java.util.List;

class ListNode <T> {
    private T data;
    private ListNode<T> right;
    private ListNode<T> left;
    private ListNode<T> parent;

    public ListNode(T data, ListNode<T> r, ListNode<T> l, ListNode<T> p) {
        this.data = data;
        right=r;
        left=l;
        parent=p;
    }

    public ListNode(T data) {
        this.data = data;
        right=null;
        left=null;
        parent=null;
    }

    public T getData() {
        return data;
    }

    public ListNode<T> getLeft() {
        return left;
    }
    public ListNode<T> getParent() {
        return parent;
    }
    public ListNode<T> getRight() {
        return right;
    }
    public void setLeft(ListNode<T> left) {
        this.left = left;
    }
    public void setParent(ListNode<T> parent) {
        this.parent = parent;
    }
    public void setRight(ListNode<T> right) {
        this.right = right;
    }
}

class Entry <K extends Comparable<? super K>, V> {
    /*
     * key-value data fields
     * Constructor(K, V)
     * getKey()
     * getValue()
     */

    K key;
    V value;
    public Entry(K k, V v){  // infor friends
        key=k;
        value=v;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }

}

interface Tree<T> {
    int size();
    boolean isEmpty();
    void insert(T element);
    boolean remove(T element);
    boolean contains(T element);
    void levelorder(List<T> list);
    void inorder(List<T> list);
    void preorder(List<T> list);
    void postorder(List<T> list);
}


class TreeNode<T> {
    byte bit;
    T element;
    TreeNode<T> left, right, parent;

    public TreeNode(T element, Byte i) {
        this.element = element;
        bit=i;
    }
    public void setBit(Byte bit) {
        this.bit = bit;
    }
}

class RBTree<K extends Comparable<? super K>> implements Tree<K>{
    TreeNode<K> root;
    int size;

    @Override
    public int size() {
       return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

   

    @Override
    public void insert(K element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    public TreeNode<K> recInsert(TreeNode<K> node, K element){
        if(node==null)
            return new TreeNode<>(element, 0);
        else if(element.compareTo(node.element)>0)
            return recInsert(node.right, element);
        else return recInsert(node.left, element);
    }

    @Override
    public boolean remove(K element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    // @Override
    // public boolean contains(K element) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'contains'");
    // }

    // @Override
    // public void levelorder(List<K> list) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'levelorder'");
    // }

    // @Override
    // public void inorder(List<K> list) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'inorder'");
    // }

    // @Override
    // public void preorder(List<K> list) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'preorder'");
    // }

    // @Override
    // public void postorder(List<K> list) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'postorder'");
    // }

}