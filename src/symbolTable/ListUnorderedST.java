package symbolTable;

/**
 * 链表实现的无排序的符号表
 * @param <Key>
 * @param <Value>
 */
public class ListUnorderedST<Key,Value> implements UnorderedST<Key,Value> {

    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public int size() {
        int count=0;
        Node cur=first;
        while (cur!=null){
            count++;
            cur=cur.next;
        }

        return count;
    }

    @Override
    public Value get(Key key) {
        Node cur=first;
        while (cur!=null){
            if (cur.key.equals(key))
                return cur.value;
            cur=cur.next;
        }
        return null;


    }

    @Override
    public void put(Key key, Value value) {
        Node cur=first;
        while (cur!=null){
            if (cur.key.equals(key)) {
                cur.value = value;
                return;
            }
            cur=cur.next;
        }
        //否则使用头插法插入一个新的节点
        first=new Node(key,value,first);


    }

    @Override
    public void delete(Key key) {
        if (key==null)
            return;
        if (first.key.equals(key))
            first=first.next;
        Node pre=first,cur=first.next;
        while (cur!=null){
            if (key.equals(cur.key)){
                pre.next=cur.next;
                return;
            }
            pre=pre.next;
            cur=cur.next;

        }



    }
}
