package linealStructures.lists;

import linealStructures.linealInterfaces.MyQueue;

import java.util.Arrays;

public class QueueByArray<E> implements MyQueue<E> {

    private E[] array = (E[]) new Object[16];
    private int phiSize = 16;
    private int logSize = 0;

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

    private void moveSubArrayF(int idx){    //ARRAYCOPY PENDENT TO VERIFY
        for (int i = logSize; i > idx; i--) {
            array[i] = array[i - 1];
        }
    }

    @Override
    public void enqueue(E data) {

            if (logSize < phiSize) {
                moveSubArrayF(0);
                array[0] = data;
                logSize++;
            } else if (duplicateSize()) {
                moveSubArrayF(0);
                array[0] = data;
                logSize++;
            }
    }

    @Override
    public E dequeue() {
        E data = array[--logSize];
        array[logSize] = null;
        return data;
    }

    @Override
    public E head() {
        return array[logSize - 1];
    }

    @Override
    public boolean isEmpty() {
        return logSize < 1;
    }
}
