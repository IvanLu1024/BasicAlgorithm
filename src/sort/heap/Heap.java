package sort.heap;

/**
 * 堆的基类
 * @param <T>
 */
public class Heap<T extends Comparable<T>> {

    private T[] heap;
    private int N=0;

    public Heap(int maxN){
        this.heap= (T[]) new Comparable[maxN+1];
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

    /**
     * 上浮
     * @param k
     */
    private void swim(int k){
        while (k>1&&less(k/2,k)){
            swap(k/2,k);
            k=k/2;
        }

    }

    /**
     * 下沉
     * @param k
     */
    private void sink(int k){
        while (2*k<=N){
            int j=2*k;
            if (j<N&&less(j,j+1))
                j++;
            if (!less(k,j))
                break;
            swap(k,j);
            k=j;

        }

    }

}
