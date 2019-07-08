package sort.quickSort;

import org.junit.Test;
import sort.Sort;
import sort.merge.Up2DownMergeSort;
import utils.SortTestHelper;

public class QuickSort<T extends Comparable<T>>  extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int l=0;
        int h=nums.length-1;
        sort(nums,l,h);

    }

    private void sort(T[] nums,int l,int h){
        if (h<=l)
            return;
        int j=partition1(nums,l,h);
        sort(nums,l,j-1);
        sort(nums,j+1,h);
    }

    private int partition(T[] nums,int l,int h){
        int i=l+1,j=h;
        T piovt=nums[l];
        while (true){
            //从左向右寻找大于或者等于piovt的元素
            while (less(nums[i],piovt)&&i<h)
                i++;
            //从右向左寻找小于piovt的元素
            while (!less(nums[j],piovt)&&j>l)
                j--;
            if (i>=j)
                break;
            //交换这两个元素的位置
            swap(nums,i,j);
        }
        //最后将piovt放置到它应该在的位置
        swap(nums,l,j);
        return j;

    }

    //另一种方式partition的方法
    private int partition1(T[] nums,int l,int h){
        int piovt=l;
        int index=piovt+1;
        for (int i = index; i <= h; i++) {
            if (less(nums[i],nums[piovt])){
                swap(nums,i,index);
                index++;
            }
        }
        swap(nums,piovt,index-1);
        return index-1;
    }

    /**
     * 寻找数组中第k小的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public T select(T[] nums,int k){
        k--;//下标需要减一
        int l=0,h=nums.length-1;
        while (h>l){
            int i = partition(nums, l, h);
            if (i==k){
                return nums[i];
            }else if (i<k){
                l=i+1;
            }else {
                h=i-1;
            }
        }
        return nums[k];
    }

    @Test
    public void test(){
        Integer[] nums = SortTestHelper.generateRandomArray(10, 0, 1000);
        SortTestHelper.printArray(nums);
        QuickSort<Integer> sort = new QuickSort<>();
        Integer i = sort.select(nums, 3);
        sort.sort(nums);
        System.out.println(i);
        SortTestHelper.printArray(nums);
    }
}
