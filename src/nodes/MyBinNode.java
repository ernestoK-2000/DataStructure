package nodes;

public class MyBinNode<E> extends MyNode<E>{
    //public MyBinNode<E> left;
    //public MyBinNode<E> right;

    public MyBinNode(E data){
        super(data);
        children.add(null);
        children.add(null);
    }
    public MyBinNode(){}
    public MyBinNode(E data, MyBinNode<E> left, MyBinNode<E> right){
        super(data);
        children.add(left);
        children.add(right);
    }


    //unchecked cast
    public MyBinNode<E> getLeft() {
        return (MyBinNode<E>) children.get(0);
    }

    public void setLeft(MyBinNode<E> left) {
        children.set(0, left);
    }

    public MyBinNode<E> getRight() {
        return (MyBinNode<E>) children.get(1);
    }

    public void setRight(MyBinNode<E> right) {
        children.set(1, right);
    }


}
