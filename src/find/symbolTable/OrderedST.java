package find.symbolTable;

import java.util.List;

public interface OrderedST<Key extends Comparable<Key>,Value> {

    int size();

    void put(Key key,Value value);

    Value get(Key key);

    Key max();

    Key min();

    int rank(Key key);



    List<Key> keys(Key l, Key h);


}
