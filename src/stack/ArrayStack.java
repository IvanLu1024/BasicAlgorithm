package stack;

import java.util.Iterator;

public class ArrayStack<Item> implements  MyStack {

    //栈元素的数组，只能通过转型来创建泛型数组
    private Item[] a= (Item[]) new Object[1];

    //元素数量
    private int N=0;

    @Override
    public MyStack push(Object o) {
        return null;
    }

    @Override
    public Object pop() throws Exception {
        if (isEmpty()){
            throw new Exception("stack is empty!");
        }

        Item item = a[--N];

        check();

        //避免对象游离
        a[N]=null;

        return item;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return 0;
    }

    private void check(){
        if (N>=a.length){
            resize(2*a.length);
        }else if (N>0&&N<=a.length/4){
            resize(a.length/2);
        }
    }

    /**
     * 调整数组大小，是的栈具有伸缩性
     * @param size
     */
    private void resize(int size) {
        Item[] tmp= (Item[]) new Object[size];

        for (int i=0;i<N;i++){
            tmp[i]=a[i];
        }

        a=tmp;

    }


    @Override
    public Iterator iterator() {

        //返回逆序遍历的迭代器
        return new Iterator<Item>() {

            private int i=N;

            @Override
            public boolean hasNext() {
                return i>0;
            }

            @Override
            public void remove() {
                a[i]=null;
            }

            @Override
            public Item next() {
                return a[--i];
            }


        };
    }
}
