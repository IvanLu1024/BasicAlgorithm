package sort;


import org.junit.Test;
import utils.SortTestHelper;

/**
 * 选择排序
 *
 */
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {


    @Override
    public  void sort(T[] nums) {
        int N=nums.length;
        for (int i=0;i<N;i++){
            //寻找nums[i,n]中最小元素的下标
            int minIndex=i;
            for(int j=i+1;j<N ;j++){
                if (less(nums[j],nums[minIndex]))
                    minIndex=j;
            }
            swap(nums,i,minIndex);
        }

    }


    @Test
    public  void test(){
        Integer[] arr = SortTestHelper.generateRandomArray(10000, 0, 100);
        SortTestHelper.printArray(arr);
        SelectionSort<Integer> selectionSort =new SelectionSort<>();
        selectionSort.sort(arr);
        SortTestHelper.printArray(arr);
        SortTestHelper.testSort(selectionSort,arr);
    }



}
