package find.bst;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 如果待删除的节点只有一个子树，
     * 那么只需要让指向待删除节点的链接指向唯一的子树即可；
     * 否则，让右子树的最小节点替换该节点。
     * @param key
     */
    public void delete(Key key){
        root=delete(root,key);
    }

    private Node delete(Node x, Key key) {
        if (x==null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp<0)
            x.left=delete(x.left,key);
        else if (cmp>0)
            x.right=delete(x.right,key);
        else {
            if (x.right==null)
                return x.left;
            if (x.left==null)
                return x.right;
            Node t=x;
            x=min(t.right);
            x.right=deleteMin(t.right);
            x.left=t.left;
        }
        recalculateSize(x);
        return x;

    }

    /**
     * 利用二叉查找树中序遍历的结果为递增的特点
     * @param l
     * @param h
     * @return
     */
    public List<Key> keys(Key l,Key h){
        return keys(root,l,h);
    }

    private List<Key> keys(Node x, Key l, Key h) {
        List<Key> list=new ArrayList<>();
        if (x==null)
            return list;
        int cmpL = l.compareTo(x.key);
        int cmpH = h.compareTo(x.key);
        if (cmpL<0)
            list.addAll(keys(x.left,l,h));
        if (cmpL<=0&&cmpH>=0)
            list.add(x.key);
        if (cmpH>0)
            list.addAll(keys(x.right,l,h));
        return list;

    }


}



