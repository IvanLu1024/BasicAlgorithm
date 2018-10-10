package find.bst;

/**
 * 二叉查找树
 */
public class BST<Key extends Comparable<Key>,Value> {

    private Node root;

    private class Node{
        private Key key;
        private Value value;
        private Node left,right;
        private int N;      //以该结点为根的子树中的结点总数
        // 红黑树中使用
        boolean color;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public int size(){
        return size(root);

    }
    private int size(Node x){
        if (x==null) return 0;
        else return x.N;
    }
    protected void recalculateSize(Node x){
        x.N=size(x.left)+size(x.right)+1;
    }


    /**
     * 查找
     * @param key
     * @return
     */
    public Value get(Key key){
        return get(root,key);

    }
    private Value get(Node x,Key key){
        if (x==null)
            return null;
        int cmp = key.compareTo(x.key);
        //若比根结点小，则在左子树中查找
        if (cmp<0)
            return get(x.left,key);
        //若比根结点大，则在右子树中查找
        else if (cmp>0)
            return get(x.right,key);
        //恰好找到
        else return x.value;

    }

    /**
     * 添加
     * @param key
     * @param value
     */
    public void put(Key key,Value value){
        put(root,key,value);
    }

    private Node put(Node x,Key key,Value value){
        if (x==null) return new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        if (cmp==0)
            x.value=value;
        else if (cmp<0)
            x.left=put(x.left,key,value);
        else x.right=put(x.right,key,value);
        recalculateSize(x);
        return x;
    }

    /**
     * 小于等于键的最大键
     * @param key
     * @return
     */
    public Key floor(Key key){
        Node x = floor(root, key);
        if (x==null)
            return null;
        return x.key;

    }
    private Node floor(Node x,Key key){
        if (x==null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp==0)
            return x;
        if (cmp<0)
            return floor(x.left,key);
        else{
            Node t = floor(x.right, key);
            return t!=null?t:x;
        }


    }

    /**
     * key的排名
     * @param key
     * @return
     */
    public int rank(Key key){
        return rank(key,root);
    }

    private int rank(Key key, Node x) {
        if (x==null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp==0)
            return size(x.left);
        else if (cmp<0)
            return rank(key,x.left);
        else
            return 1+size(x.left)+rank(key,x.right);


    }

    /**
     * 最小值的键
     * @return
     */
    public Key min(){
        return min(root).key;
    }

    private Node min(Node x) {
        if (x==null)
            return null;
        if (x.left==null)
            return x;
        return min(x.left);

    }

    /**
     * 令指向最小节点的链接指向最小节点的右子树
     */
    public void deleteMin(){
        root=deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left==null)
            return x.right;
        x.left= deleteMin(x.left);
        recalculateSize(x);
        return x;


    }


}



