package linealStructures.linealInterfaces;

import iteratorPattern.MyIterable;

public interface MyList<E> extends MyIterable {
    /*methods
1-add()
2-get(idx)
3-remove(int idx)
4-insert(int idx)
5-size()
6-clear()

7-indexOf(E e)
8-contains(E e)
9-toArray()
 */

    void add(E e);
    E get(int idx);
    void remove(int idx);
    void insert(int idx, E e);
    void set(int idx, E e);
    int size();
    void clear();
    boolean isEmpty();
    int indexOf(E e);
    boolean contains(E e);
    E[] toArray();
}
