package sort.heap;

import org.junit.Test;
import sort.Sort;
import utils.SortTestHelper;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {


    @Override
    public void sort(T[] arr) {
        int N=arr.length;
        //因为叶子结点不需要下沉，所以从第一个非叶子结点开始进行下沉操作
        for(int i=N/2;i>=0;i--){
            shiftDown(arr,i,N);
        }

        while (N>1){
            //将最大值放入最后一个位置上
            swap(arr,0,N-1);
            N--;
            //与第一个元素交换后，最大元素就是arr[N-1]
            shiftDown(arr,0,N);
        }
    }

    //下沉操作
    private void shiftDown(T[] arr, int k, int N){
        while(leftChild(k)<=N-1){
            int j=leftChild(k);
            if(j+1<=N-1 && less(arr[j],arr[j+1])){
                j=rightChild(k);
            }
            if(!less(arr[k],arr[j])){
                break;
            }
            swap(arr,k,j);
            k=j;
        }
    }

    private int leftChild(int k){
        return 2*k+1;
    }

    private int rightChild(int k){
        return 2*k+2;
    }

    @Test
    public void test(){
        Integer[] nums = SortTestHelper.generateRandomArray(10, 0, 100);
        HeapSort<Integer> heapSort=new HeapSort<>();
        heapSort.sort(nums);
        SortTestHelper.printArray(nums);
    }
}
