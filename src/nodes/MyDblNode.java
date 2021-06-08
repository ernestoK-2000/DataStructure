package nodes;

public class MyDblNode<E> extends MyNode<E>{
    public MyDblNode<E> next;
    public MyDblNode<E> prev;

    public MyDblNode(E data){
        super(data);
    }
    //public MyDblNode(){}
}
