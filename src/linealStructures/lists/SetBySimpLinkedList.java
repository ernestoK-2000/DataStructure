package linealStructures.lists;

import iteratorPattern.MyIterator;

public class SetBySimpLinkedList<E> extends SimLinkedList<E>{

    @Override
    public void add(E data) {
        
        super.add(data);
    }

    @Override
    public void remove(int idx) {
        super.remove(idx);
    }

    @Override
    public void insert(int idx, E data) {
        super.insert(idx, data);
    }

    @Override
    public void set(int idx, E data) {
        super.set(idx, data);
    }

    @SuppressWarnings("Duplicates")
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
