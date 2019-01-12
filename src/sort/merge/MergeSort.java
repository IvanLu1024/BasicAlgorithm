package sort.merge;

import sort.Sort;

/**
 * 归并排序
 *
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;

    //将nums[l,m]和nums[m+1,h]两个部分进行归并
    protected void merge(T[] nums,int l,int m,int h){

        //将数据复制到辅助数组当中
        for (int k=l;k<=h;k++){
            aux[k]=nums[k];
        }
        int i=l,j=m+1;

        for (int k=l;k<=h;k++){
            //当前半部分遍历结束，直接将后半部分放入数组中
            if (i>m){
                nums[k]=aux[j++];
            }
            //当后半部分遍历结束，直接将前半部分放入数组中
            else if (j>h){
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
