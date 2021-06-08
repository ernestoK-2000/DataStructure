package trees;

import nodes.MyNode;

public class GeneralTree<E extends Comparable<E>> extends MyTree<E> {
    public GeneralTree(){}
    public GeneralTree(MyNode<E> root){
        super(root);
    }
}
