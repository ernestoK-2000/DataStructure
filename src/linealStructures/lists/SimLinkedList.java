package linealStructures.lists;

import iteratorPattern.MyIterable;
import iteratorPattern.MyIterator;
import linealStructures.linealInterfaces.MyList;
import nodes.MySimNode;

import java.util.LinkedList;

/*methods
1-add()
2-get(idx)
3-remove(int idx)
4-insert(int idx)
5-size()
6-clear()
 */
public class SimLinkedList<E> implements MyList<E>{

    private MySimNode<E> first;
    private MySimNode<E> last;
    private int size;

    private MySimNode<E> recorrerLista(int idx){      //recorre la lista hasta el elemento anterior a idx
        MySimNode<E> current = first;
        for (int i = 0; i < idx - 1; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void add(E data){
        MySimNode<E> node = new MySimNode<>(data);
        if (first == null) {
            first = node;
            last = node;
        }else{
            last.next = node;
        }
        size++;
    }

    @Override
    public void clear(){
        first = null;
        size = 0;
    }


    @Override
    public void remove(int idx){
        MySimNode<E> current;
        if(idx < 0 || idx >= size)
            return;
        else if(idx == 0){
           first = first.next;
        } else {
            current = recorrerLista(idx);
            current.next = current.next.next;
        }
        size--;
    }

    @Override
    public void insert(int idx, E data){
        MySimNode<E> node = new MySimNode<>(data);
        MySimNode<E> current;
        if(idx < 0 || idx >= size)
            return;
        else if(idx == 0){
            node.next = first;
            first = node;
        }else {
            current = first;
            for (int i = 0; i < idx - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
        size++;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public E get(int idx){
        MySimNode<E> current;
        if(idx < 0 || idx >= size)
            return null;
        else{
            current = first;
            for (int i = 0; i < idx; i++) {
                current = current.next;
            }
        }
        return current.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("The size of Linked List is: " + this.size + "\n" +
                "Their elements are:\n");
        String string;
        MySimNode<E> current = first;
        int i = 0;
        while (current != null) {
            string = i + ". " + current.toString() + "\n";
            sb.append(string);
            current = current.next;
            i++;
        }
        return sb.toString();
    }

    @Override
    public boolean isEmpty(){return size == 0;}

    @Override
    public int indexOf(E e) {
        if (e == null) {
            return -1;
        }
        MySimNode<E> current = first;
        int i = 0;
        while (current.next != null) {
            if (current.data.equals(e))
                return i;
            i++;
        }
        return -1;
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public void set(int idx, E data){
        MySimNode<E> node = new MySimNode<>(data);
        MySimNode<E> current;
        if(idx < 0 || idx >= size)
            return;
        else if(idx == 0){
            node.next = first.next;
            first = node;
        }else {
            current = recorrerLista(idx);
            node.next = current.next.next;
            current.next = node;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] array = (E[]) new Object[size];
        int i = 0;
        for (MySimNode<E> current = first; current.next != null; current = current.next) {
            array[i++] = current.data;
        }
        return array;
    }

    //ITERATOR PATTERN
    @Override
    public MyIterator<E> getIterator() {
        return new Iterator<>();
    }

    private class Iterator<T> implements MyIterator<T>{

        private MySimNode current;

        private Iterator(){
            current = first;
        }

        @Override
        public boolean hasNext() { return current != null; }

        @Override
        public T next() {
            MySimNode toReturn = current;
            current = current.next;
            return (T) toReturn;
        }
    }


}
