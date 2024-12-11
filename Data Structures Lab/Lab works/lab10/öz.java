class AVL<T extends Comparable<? super T>> extends BST<T> implements IAVL<T> {

   
    
    private int height(Node<T> node) {
        return node == null ? 0 : node.height;
    }

    private int getBalanceFactor(Node<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private void updateHeight(Node<T> node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    @Override
    protected Node<T> insertRec(Node<T> node, T element){
        node=super.insertRec(node, element);
        updateHeight(node);
        return rebalance(node);
    }
    @Override
    protected Node<T> removeRec(Node<T> node, T element){
        node=super.removeRec(node, element);
        if(node==null){
            return null;
        }
        updateHeight(node);
        return rebalance(node);
    }

    @Override
    public Node<T> rebalance(Node<T> node) {
        // TODO Auto-generated method stub
        if(node==null){
            return node;
        }
        updateHeight(node);
        int balance=getBalanceFactor(node);
        if(balance>1&&getBalanceFactor(node.left)>=0){
            return rightRotate(node);
        }
        if(balance>1&&getBalanceFactor(node.left)<0){
            return doubleRotateLR(node);
        }
        if(balance<-1&&getBalanceFactor(node.right)<=0){
            return leftRotate(node);
        }
        if(balance<-1&&getBalanceFactor(node.left)>0){
            return doubleRotateRL(node);
        }
        // if(balance>1){
        //     if(getBalanceFactor(node.left)<0){
        //         node.left=leftRotate(node.left);
        //     }
        //     return rightRotate(node);
        // }

        // if(balance<-1){
        //     if(getBalanceFactor(node.right)>0){
        //         node.right=rightRotate(node.right);
        //     }
        //     return leftRotate(node);
        // }
        return node;
    }

    @Override
    public Node<T> leftRotate(Node<T> node) {
        // TODO Auto-generated method stub
        if(node==null|| node.right==null){
            return node;
        }

        Node<T> newRigth=node.right;
        node.right=newRigth.left;
        if(newRigth.left!=null){
            newRigth.left.parent=node;
        }
        newRigth.parent=node.parent;
        newRigth.left=node;
        node.parent=newRigth;

        updateHeight(node);
        updateHeight(newRigth);
        return newRigth;

    }

    @Override
    public Node<T> rightRotate(Node<T> node) {
        // TODO Auto-generated method stub
        Node<T> newLeft=node.left;
        node.left=newLeft.right;
        //newLeft.parent=node.parent;
        newLeft.right=node;
        //node.parent=newLeft;
        return newLeft;
    }

    private Node<T> find(T element){
        if(isEmpty()){
            return null;
        }
        return findRec(root, element);
    }

    private Node<T> findRec(Node<T> node, T element){
        if(node==null){
            return node;
        }
        if(element.compareTo(node.element)<0){
            return findRec(node.left, element);
        }
        if(element.compareTo(node.element)>0){
            return findRec(node.right, element);
        }

        return node;
    }

    @Override
    public Node<T> doubleRotateLR(Node<T> node) {
        // TODO Auto-generated method stub
       if(node==null|| node.left==null){
        return node;
       } 
       node.left=leftRotate(node.left);
       return  rightRotate(node);
    }

    @Override
    public Node<T> doubleRotateRL(Node<T> node) {
        // TODO Auto-generated method stub
        if(node==null|| node.left==null){
            return node;
        }
        node.left=rightRotate(node.left);
        return leftRotate(node);
    }


    public void leftrotate(T elemenT){
        if(contains(elemenT)){
            Node<T> node=find(elemenT);
            if(node==root){
                root=leftRotate(node);
            }
            else{
                if(elemenT.compareTo(node.parent.element)<0){
                    node.parent.left= leftRotate(node);
                }
                else{
                    node.parent.right=leftRotate(node);
                }
            }

        }
 
    }


    public void rightRotate(T elemenT){
        if(contains(elemenT)){
            Node<T> node=find(elemenT);
            if(node==root){
                root=rightRotate(node);
            }
            else{
                if(elemenT.compareTo(node.parent.element)<0){
                    node.parent.right= rightRotate(node);
                }
                else{
                    node.parent.left=rightRotate(node);
                }
            }

        }
 
    }
}