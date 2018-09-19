package sort.merge;

public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public void sort(T[] nums) {
        int N=nums.length;
        aux= (T[]) new Comparable[N];

        for (int i=1;i<N;i+=i){
            for (int j=0;j<N-i;j+=i+i){
                merge(nums,j,j+i-1,Math.min(j+i+i-1,N-1));
            }

        }


    }
}
