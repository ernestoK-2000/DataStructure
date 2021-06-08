package nodes;

import linealStructures.linealInterfaces.MyList;
import linealStructures.lists.MyArrayList;

//superclass
public class MyNode<E>{
    public E data;


    public MyNode(E data){
        this();
        this.data = data;
    }
    public MyNode(){
        children = new MyArrayList<>();
    }







    //fermin tips
    protected MyList<MyNode<E>> children;

    public MyList<MyNode<E>> getChildren() {
        return children;
    }
}
