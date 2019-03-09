package avlTree;

import java.util.ArrayList;
import java.util.List;

public class AVLTree<K extends Comparable<K>,V> {
    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left=null;
            this.right=null;
            this.height=1;
        }
    }

    private Node root;
    private int size;

    public void add(K key,V value){
        root=add(root,key,value);
    }

    public boolean isBST(){
        List<K> keys=new ArrayList<>();
        inOrder(keys,root);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i-1).compareTo(keys.get(i))>0){
                return false;
            }
        }
        return true;
    }

    public boolean isBalancedTree(){
        return isBalancedTree(root);
    }
    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2

    public Node rightRotate(Node y){
        Node x = y.left;
        Node t3 = x.right;

        x.right=y;
        y.left=t3;

        //维护树高
        y.height=1+Math.max(getNodeHeight(y.left),getNodeHeight(y.right));
        x.height=1+Math.max(getNodeHeight(x.left),getNodeHeight(x.right));

        return x;
    }

    private boolean isBalancedTree(Node node){
        if (node==null){
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor)>1){
            return false;
        }
        return isBalancedTree(node.left)&&isBalancedTree(node.right);
    }


    private void inOrder(List<K> keys,Node node){
        if (node==null){
            return;
        }
        inOrder(keys,node.left);
        keys.add(node.key);
        inOrder(keys,node.right);
    }

    private Node add(Node node, K key,V value){
        if (node==null){
            size++;
            return new Node(key,value);
        }
        if (key.compareTo(node.key)<0){
            node.left=add(node.left,key,value);
        }else if (key.compareTo(node.key)>0){
            node.right=add(node.right,key,value);
        }else {
            node.value=value;
        }

        node.height=Math.max(getNodeHeight(node.left),getNodeHeight(node.right));

        int balanceFactor=getBalanceFactor(node);

        if (Math.abs(balanceFactor)>1){
            //....
        }
        return node;
    }

    private int getNodeHeight(Node node){
        if (node==null){
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(Node node){
        if (node==null){
            return 0;
        }
        return getNodeHeight(node.left)-getNodeHeight(node.right);
    }

}
