package iteratorPattern;

import java.util.Iterator;

public interface MyIterator<E> {
    boolean hasNext();
    E next();

}
