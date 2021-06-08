package linealStructures.lists;


import linealStructures.linealInterfaces.MyStack;

import java.util.Arrays;

public class StackByArray<E> implements MyStack<E> {

    private E[] array;
    private int logSize;
    private int phiSize;

    public StackByArray(){
        phiSize = 16;
        array = (E[])new Object[16];
    }

    @SuppressWarnings("Duplicates")
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

    @Override
    public E pop() {
        E data = array[--logSize];
        array[logSize] = null;
        return data;
    }

    @Override
    public E head() {
        return array[logSize - 1];
    }

    @Override
    public void push(E data) {
        if(logSize < phiSize)
            array[logSize++] = data;
        else if (duplicateSize())
            array[logSize++] = data;
    }

    @Override
    public boolean isEmpty() {
        return logSize < 1;
    }
}
