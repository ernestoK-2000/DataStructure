package linealStructures.lists;

import iteratorPattern.MyIterator;

//It is an arrayList that has no repeated elements
public class SetByArray<E> extends MyArrayList<E> {

    @Override
    public void add(E data) {
        if(notRepeated(data))
            super.add(data);
    }

    @Override
    public void insert(int idx, E data) {
        if(notRepeated(data))
            super.insert(idx, data);
    }

    //if data is repeated in the set, the element at the specified index will remain the same
    @Override
    public void set(int idx, E data) {
        if(notRepeated(data))
            super.set(idx, data);
    }

    //complexity n(lineal)
    private boolean notRepeated(E data){
        boolean notRepeated = true;
        MyIterator<E> iterator = getIterator();
        while(iterator.hasNext() && notRepeated) {
            if(iterator.next().equals(data))
                notRepeated = false;
        }
        return notRepeated;
    }
}
