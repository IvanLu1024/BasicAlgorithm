package sort.merge;

/**
 * 可以对链表进行归并排序
 *
 * @param <T>
 */
public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public void sort(T[] nums) {
        int n=nums.length;
        aux= (T[]) new Comparable[n];


        for (int sz=1;sz<n;sz+=sz){
            for (int i=0;i<n-sz;i+=sz+sz){
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(nums,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
            }

        }


    }
}
