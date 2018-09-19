package sort;

/**
 * 插入排序
 *
 * @param <T>
 */
public class Insert<T extends Comparable<T>> extends Sort<T> {


    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i=1;i<N;i++){
            for (int j=i;j>0;j--){
                if (!less(nums[j-1],nums[j])){
                    swap(nums,j-1,j);
                }
            }

        }

    }
}
