package nodes;

import linealStructures.linealInterfaces.MyList;
import linealStructures.lists.MyArrayList;
import linealStructures.lists.SetByArray;

//An instance of this class has no directly relations with others node instances
public class MyDicNode<K,V> {
    private K key;
    private V value;

    MyList<K> keys = new SetByArray<>();
    MyList<V> values = new MyArrayList<>();


    //getters
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
