package linealStructures.lists;

import linealStructures.linealInterfaces.MyStack;
import nodes.MySimNode;

public class StackBySimpLinkedList<E> implements MyStack<E> {
    private MySimNode<E> first;
    private int size;

    @SuppressWarnings("Duplicates")
    @Override
    public E pop() {
        MySimNode<E> toReturn = first;
        first = first.next;
        return toReturn.data;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public E head() {
        return first.data;
    }

    @Override
    public void push(E e) {
        MySimNode<E> newFirst = new MySimNode<>(e);
        newFirst.next = first;              //DUDA: esta apuntando a first o apunta al mismo objeto que apunta first
        first = newFirst;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
