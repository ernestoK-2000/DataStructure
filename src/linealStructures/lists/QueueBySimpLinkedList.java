package linealStructures.lists;

import linealStructures.linealInterfaces.MyQueue;
import nodes.MySimNode;

public class QueueBySimpLinkedList<E> implements MyQueue<E> {
    private MySimNode<E> first;
    private MySimNode<E> last;


    @Override
    public void enqueue(E data) {
        MySimNode<E> node = new MySimNode<>(data);
        if (first == null) {
            first = node;
        }else {
            MySimNode<E> current = first;
            while (current.next != null)
                current = current.next;
            current.next = node;
        }
    }

    @Override
    public E dequeue() {
        MySimNode<E> toReturn = first;
        first = first.next;
        return toReturn.data;
    }

    @Override
    public E head() {
        return first.data;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
