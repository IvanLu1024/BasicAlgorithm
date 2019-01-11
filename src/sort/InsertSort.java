package sort;

import org.junit.Test;
import utils.SortTestHelper;

/**
 * 插入排序
 *
 * @param <T>
 */
public class InsertSort<T extends Comparable<T>> extends Sort<T> {

    /**
     * 对于一个基本有序的数组进行排序的时候，效率会很高
     *
     * 效率甚至比O(nlogn)的算法效率更高
     *
     * 改进的插入排序
     * @param nums 待排序数组
     */
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        //nums[0]默认是已经排序好的
        for (int i=1;i<n;i++){
            //寻找nums[i]合适的插入位置
            T e=nums[i];
            //j:保存元素e应该的插入位置
            int j;
            for (j=i;j>0&&nums[j-1].compareTo(e)>0;j--){
                nums[j]=nums[j-1];
            }
            nums[j]=e;

        }
    }

    @Test
    public void test(){
        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 10000);
        SortTestHelper.printArray(arr);
        InsertSort<Integer> sort = new InsertSort<>();
        sort.sort(arr);
        SortTestHelper.printArray(arr);
        SortTestHelper.testSort(sort,arr);
    }
}
