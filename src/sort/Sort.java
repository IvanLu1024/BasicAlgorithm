package sort;

/**
 * 排序的抽象类
 *
 * 其中包含了排序、比较以及交换相关方法
 */
public abstract class Sort<T extends Comparable<T>> {
    /**
     * 排序
     * @param nums 待排序数组
     */
    public abstract void sort(T[] nums);

    /**
     * 比较大小
     * @param a 前者
     * @param b 后者
     * @return 前者是否小于后者
     */
    public boolean less(T a,T b){
        return a.compareTo(b)<0;
    }

    public void swap(T[] nums,int i,int j){
        T t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;

    }



}
