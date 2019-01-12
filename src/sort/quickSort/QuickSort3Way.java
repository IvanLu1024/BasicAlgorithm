package sort.quickSort;

import org.junit.Test;
import sort.Sort;
import utils.SortTestHelper;

import java.util.Collections;

/**
 * 三向切分快排
 *
 * 在有大量重复元素的排序过程中效果很好
 *
 */
public class QuickSort3Way<T extends Comparable<T>> extends Sort<T> {

    public void sort(T[] a,int l,int h){
        if (h<=l)
            return;
        int lt=l,i=l+1,gt=h;//分别标注小于中位数的，等于中位数的，大于中位数的下标
        //partition
        T v = a[l];
        while (i<=gt){
            int cmp = a[i].compareTo(v);
            if (cmp<0){
               swap(a,lt++,i++);
            }else if (cmp>0){
                //需要注意这里的i是未遍历的元素，所以不需要加1操作
                swap(a,i,gt--);
            }else i++;
        }
        //现在a[l,lt-1]<v=a[lt,gt]<a[gt+1,h]
        sort(a,l,lt-1);
        sort(a,gt+1,h);

    }
    @Override
    public void sort(T[] nums) {
        sort(nums,0,nums.length-1);
    }


    @Test
    public void test(){
        Integer[] nums = SortTestHelper.generateRandomArray(10, 0, 10);
        QuickSort3Way<Integer> sort = new QuickSort3Way<>();
        sort.sort(nums);
        SortTestHelper.printArray(nums);
    }


}
