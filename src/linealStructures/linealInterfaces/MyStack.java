package linealStructures.linealInterfaces;

public interface MyStack<E> {
    E pop();
    E head();
    void push(E e);
    boolean isEmpty();
}
