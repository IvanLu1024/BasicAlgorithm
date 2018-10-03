package symbolTable;

public interface UnorderedST<key,value> {
    int size();

    value get(key key);

    void put(key key,value value);

    void delete(key key);
}
