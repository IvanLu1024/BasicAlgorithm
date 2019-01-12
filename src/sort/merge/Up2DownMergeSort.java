package sort.merge;

import org.junit.Test;
import utils.SortTestHelper;

public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {


    @Override
    public void sort(T[] nums) {
        aux= (T[]) new Comparable[nums.length];
        sort(nums,0,nums.length-1);

    }

    private void sort(T[] nums,int l,int h){
        if (h<=l){
            return;
        }
        int mid=l+(h-l)/2;
        sort(nums,l,mid);
        sort(nums,mid+1,h);
        //当数组无序的时候才进行归并
        //nums[mid]<=nums[mid+1]表明当前数组已经是有序的
        if (nums[mid].compareTo(nums[mid+1])>0){
            merge(nums,l,mid,h);
        }

    }
    @Test
    public void test(){
        Integer[] nums = SortTestHelper.generateRandomArray(10, 0, 10);
        Up2DownMergeSort<Integer> sort = new Up2DownMergeSort<>();
        sort.sort(nums);
        SortTestHelper.printArray(nums);
    }
}
