package sort.merge;

import sort.Sort;

/**
 * 归并排序
 *
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;

    protected void merge(T[] nums,int l,int m,int h){
        int i=l,j=m+1;

        //将数据复制到辅助数组当中
        for (int k=l;k<=h;k++){
            aux[k]=nums[k];
        }

        for (int k=l;k<=h;k++){
            if (i>m){
                nums[k]=aux[j++];
            }else if (j>h){
                nums[k]=aux[i++];
            }
            //选择小的放入已经排序好的数组
            else if (less(aux[i],aux[j])){
                nums[k]=aux[i++];
            }else {
                nums[k]=aux[j++];
            }


        }


    }




}
