package sort.heap;

/**
 * 堆的基类
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> {

    private T[] heap;
    private int N=0;
    private int capacity;

    public MaxHeap(int maxN){
        this.heap= (T[]) new Comparable[maxN+1];
        this.capacity=maxN;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    private boolean less(int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }

    private void swap(int i,int j){
        T t=heap[i];
        heap[i]=heap[j];
        heap[j]=t;

    }

    // 像最大堆中插入一个新的元素 item
    public void insert(T item){

        assert N + 1 <= capacity;
        heap[N+1] = item;
        N ++;
        shiftUp(N);
    }

    /**
     * 上浮
     * @param k
     */
    private void shiftUp(int k){
        while (k>1&&less(k/2,k)){
            swap(k/2,k);
            k=k/2;
        }

    }

    /**
     * 下沉
     * @param k
     */
    private void shiftDown(int k){
        while (2*k<=N){
            //在左右孩子中寻找较大值进行交换
            int j=2*k;
            //如果右孩子较大的时候
            if (j<N&&less(j,j+1))
                j++;
            //若根节点不小于两个孩子结点的时候
            //表明此时已经满足了最大根的条件，下沉结束
            if (!less(k,j))
                break;
            swap(k,j);
            k=j;
        }
    }

    /**
     * 取出根节点
     *
     * @return
     */
    public T extractMax(){
        assert (N>0);
        T res = heap[1];
        swap(1,N);
        N--;
        shiftDown(1);
        return res;
    }

    // 测试 MaxHeap
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int n = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < n ; i ++ )
            maxHeap.insert( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[n];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < n ; i ++ ){
            Integer integer = maxHeap.extractMax();
            arr[i] =integer;
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < n ; i ++ )
            assert arr[i-1] >= arr[i];
    }

}
