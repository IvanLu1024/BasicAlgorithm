package queue;

import java.util.Iterator;

public class ListQueue<Item> implements MyQueue<Item> {

    private Node first;
    private Node last;
    int N=0;

    private class Node{
        Item item;
        Node next;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public MyQueue<Item> add(Item item) {
        Node newNode = new Node();
        newNode.item=item;
        newNode.next=null;

        if (isEmpty()){
            last=newNode;
            first=newNode;

        }else {
            last.next=newNode;
            last=newNode;
        }

        N++;


        return this;
    }

    @Override
    public Item remove() throws Exception {
        if (isEmpty()){
            throw new Exception("queue is empty!");
        }

        Node node=first;
        first=first.next;
        N--;

        if (isEmpty()){
            last=null;
        }

        return node.item;

    }

    @Override
    public Iterator<Item> iterator() {

        return new Iterator<Item>() {

            Node currentNode=first;

            @Override
            public boolean hasNext() {
                return currentNode!=null;
            }

            @Override
            public Item next() {
                Item item=currentNode.item;
                currentNode=currentNode.next;
                return item;
            }

            @Override
            public void remove() {

            }
        };


    }
}
