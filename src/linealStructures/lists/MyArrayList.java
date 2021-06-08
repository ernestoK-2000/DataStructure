package linealStructures.lists;

import iteratorPattern.*;
import linealStructures.linealInterfaces.MyList;
import java.util.Arrays;

public class MyArrayList<E> implements MyList<E>{
    private Object[] array;
    private int logSize;
    private int phiSize;
    //private ArrayEnlarger enlarger; //aumentador de espacio sin utilizar


    public MyArrayList(){
        array = new Object[16];
        phiSize = 16;
        logSize = 0;
    }

    @Override
    public void add(E data) {
        if(logSize < phiSize)
            array[logSize++] = data;
        else if (duplicateSize())
            array[logSize++] = data;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int idx) {
        if (checkIndex(idx)) {
            return (E) array[idx];
        }else
            return null;
    }

    @Override
    public void remove(int idx) {
        if(checkIndex(idx)){
            moveSubArrayB(idx);
            logSize--;
        }
    }

    @Override
    public void insert(int idx, E data) {
        if(checkIndex(idx)) {
            if (logSize < phiSize) {
                moveSubArrayF(idx);
                array[idx] = data;
                logSize++;
            } else if (duplicateSize()) {
                moveSubArrayF(idx);
                array[idx] = data;
                logSize++;
            }
        }
    }

    @Override
    public int size() {
        return logSize;
    }

    @Override
    public void clear() {
        array = new Object[16];
        logSize = 0;
    }

    @Override
    public boolean isEmpty() { return array[0] == null; }

    @Override
    public void set(int idx, E data) {
        if(checkIndex(idx)){
            array[idx] = data;
        }
    }

    @Override
    public int indexOf(E e){
        if (e == null) {
            for (int i = 0; i < size(); i++) {
                if(array[i] == (null))
                    return i;
            }
        }else{
            for (int i = 0; i < size(); i++) {
                if(e.equals(array[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E e){
        return indexOf(e) >= 0;
    }


    @Override
    public MyIterator<E> getIterator() {
        return new Iterator<>();
    }
    //arraylist iterator
    private class Iterator<T> implements MyIterator<T>{

        private int idx;

        @Override
        public boolean hasNext() {
            return array[idx] != null;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            return (T) array[idx++];
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        return (E[]) Arrays.copyOf(array, logSize);
    }

    //Private methods
    private boolean duplicateSize(){     // duplica el tamano del arreglo y en caso de ser posible retorna true
        boolean duplicate = true;
        try {
            array = Arrays.copyOf(array,phiSize * 2);
            phiSize *= 2;
        }catch (OutOfMemoryError e){
            duplicate = false;
            e.printStackTrace();
        }
        return duplicate;
    }

    //array size has to be verified outside the method
    //logSize increased outside
    private void moveSubArrayF(int idx){    //ARRAYCOPY PENDENT TO VERIFY
        System.arraycopy(array, idx, array, idx + 1, logSize - idx);
    }

    //array size has to be verified outside the method
    //logSize increased outside
    private void moveSubArrayB(int idx){        //ARRAYCOPY PENDENT TO VERIFY
        System.arraycopy(array, idx, array, idx - 1, logSize - idx);
    }

    private boolean checkIndex(int idx){
        if(idx < 0 || idx >= logSize){
            new IndexOutOfBoundsException().printStackTrace();
            return false;
        }else
            return true;
    }
}
