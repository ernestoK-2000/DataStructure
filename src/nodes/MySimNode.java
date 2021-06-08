package nodes;

public class MySimNode<E> extends MyNode<E>{
    public MySimNode<E> next;


    public MySimNode(E data){
        super(data);
    }
    public MySimNode() {}
}
