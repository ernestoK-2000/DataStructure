package trees;

import nodes.MyBinNode;

public class MyBinTree<E extends Comparable<E>> extends MyTree<E>{

    public MyBinTree(){}

    public MyBinTree(MyBinNode<E> root){
        super(root);
    }

    public void inorder(){
        inorder(this);
    }

    private void inorder(MyBinTree<E> tree){
        if (tree != null && tree.root != null) {
            inorder(new MyBinTree<>(tree.getBinRoot().getLeft()));
            procedure(tree.root.data);
            inorder(new MyBinTree<>(tree.getBinRoot().getRight()));
        }
    }

    public void preorder(){
        preorder(this);
    }

    private void preorder(MyBinTree<E> tree){
        if(tree != null && tree.root != null){
            MyBinNode<E> treeRoot = null;
            procedure(tree.root.data);
            preorder(new MyBinTree<>(tree.getBinRoot().getLeft()));
            preorder(new MyBinTree<>(tree.getBinRoot().getRight()));
        }
    }
    public void postorder(){
        postorder(this);
    }

    private void postorder(MyBinTree<E> tree){
        if(tree != null && tree.root != null){
            postorder(new MyBinTree<>(tree.getBinRoot().getLeft()));
            postorder(new MyBinTree<>(tree.getBinRoot().getRight()));
            procedure(tree.root.data);
        }
    }


}
