package sort.quickSort;

import sort.Sort;

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
        int j=partition(nums,l,h);
        sort(nums,l,j-1);
        sort(nums,j+1,h);
    }

    private int partition(T[] nums,int l,int h){
        int i=l+1,j=h;
        T piovt=nums[l];
        while (true){
            while (less(nums[i],piovt)&&i!=h)
                i++;
            while (!less(nums[j],piovt)&&j!=l)
                j--;
            if (i>=j)
                break;
            swap(nums,i,j);

        }
        swap(nums,l,j);
        return j;

    }
}
