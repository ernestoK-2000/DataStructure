package trees;

import nodes.MyBinNode;

public class MyBST<E extends Comparable<E>> extends MyBinTree<E>{

    public MyBST(){}
    public MyBST(MyBinNode<E> root) {
        super.root = root;
    }

    public void add(E data){
        add(data, this);
    }

    //original
    //if data equals null then nothing happens
    private MyBinNode<E> add(E data, MyBST<E> tree){
        if (data != null) {
            if(tree.root == null)
                tree.root = new MyBinNode<>(data);
            else if(data.compareTo(tree.root.data) < 0)
                tree.getBinRoot().setLeft(add(data, new MyBST<>(tree.getBinRoot().getLeft())));
            else if(data.compareTo(tree.root.data) > 0)
                tree.getBinRoot().setRight(add(data, new MyBST<>(tree.getBinRoot().getRight())));
            //if data equals root.data do nothing; BST can't have repeating elements
            return tree.getBinRoot();
        }
        return null;
    }

    //copy
    /*private MyBinNode<E> add(E data, MyBinNode<E> root){
        if (data != null) {
            if(root == null)
                root = new MyBinNode<>(data);
            else if(data.compareTo(root.data) < 0)
                root.setLeft(add(data, root.getLeft()));
            else if(data.compareTo(root.data) > 0)
                root.setRight(add(data, root.getRight()));
            //if data equals root.data do nothing; BST can't have repeating elements
            return root;
        }
        return null;
    }*/

    public boolean find(E e){
        return find(e, this);
    }

    private boolean find(E e, MyBST<E> tree){
        if(e != null && tree != null && tree.root != null) {
            int num = e.compareTo(tree.root.data);
            if(num == 0)
                return true;
            else if(num < 0)
                return find(e, new MyBST<>(tree.getBinRoot().getLeft()));
            else
                return find(e, new MyBST<>(tree.getBinRoot().getRight()));
        }
        return false;
    }



}
