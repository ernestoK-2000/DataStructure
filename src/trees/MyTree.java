package trees;

import iteratorPattern.MyIterator;
import linealStructures.linealInterfaces.MyList;
import nodes.MyBinNode;
import nodes.MyNode;

import java.util.List;

public abstract class MyTree<E extends Comparable<E>> {
    protected MyNode<E> root;

    public MyTree(MyNode<E> root){
        this.root = root;
    }

    public MyTree(){}

    public MyNode<E> getRoot() {
        return root;
    }

    public MyBinNode<E> getBinRoot(){
        if (root instanceof MyBinNode || root == null) {
            return (MyBinNode<E>) root;
        }
        return null;
    }

    //correspond with preorder sequence
    public boolean dfs(E data){
        return dfs(data, this);
    }

    private boolean dfs(E data, MyTree<E> tree){
        if(data != null){
            if(tree.root != null){
                if(tree.root.data.equals(data)){
                    return true;
                }else {
                    MyList<MyNode<E>> children = tree.root.getChildren();
                    boolean found = false;
                    int length = children.size();
                    for (int i = 0; i < length && !found; i++) {
                        found = dfs(data, new GeneralTree<>(children.get(i)));      //should not rely on subclasses. NEEDS FIXING
                    }
                    return found;
                }
            }
        }
        return false;
    }

    //IMPLEMENTING
    public boolean bfs(E data){
        throw new UnsupportedOperationException();
        //return bfs(data, this);
    }

   /* private boolean bfs(E data, MyTree<E> tree){
        boolean found = false;
        if(data != null){
            if(tree.root != null){
                if(tree.root.data.equals(data)){
                    return true;
                }else {

                    }
                }
            }
        }
    }*/

    protected void procedure(E data){
        System.out.println(data);
    }
}
