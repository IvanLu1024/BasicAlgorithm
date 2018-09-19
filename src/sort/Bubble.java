package sort;

/**
 * 冒泡排序
 *
 */
public class Bubble<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int N=nums.length-1;
        for (int i=0;i<N;i++){
            for (int j=0;j<N-i;j++){
                if (!less(nums[j],nums[j+1]))
                    swap(nums,j,j+1);

            }

        }

    }
}
