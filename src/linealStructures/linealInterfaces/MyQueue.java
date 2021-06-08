package linealStructures.linealInterfaces;

public interface MyQueue<E> {
    void enqueue(E data);
    E dequeue();
    E head();
    boolean isEmpty();
}
