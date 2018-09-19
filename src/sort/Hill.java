package sort;

/**
 * 希尔排序
 */
public class Hill<T extends Comparable<T>> extends Sort<T> {



    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h=1;

        while (h<N/3){
            h=3*h+1;
        }

        while (h>=1){
            for (int i=h;i<N;i++){
                for (int j=i;j>=h;j-=h){
                    if (!less(nums[j-h],nums[j])){
                        swap(nums,j-h,j);
                    }
                }

            }
            h=h/3;

        }


    }
}
