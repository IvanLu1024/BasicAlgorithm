package sort.quickSort;

import org.junit.Test;

import java.util.Collections;

/**
 * 三向切分快排
 *
 * 在有大量重复元素的排序过程中效果很好
 *
 */
public class QuickSort3Way {

    public void sort(Comparable[] a,int l,int h){
        if (h<=l)
            return;
        int lt=l,i=l+1,gt=h;//分别标注小于中位数的，等于中位数的，大于中位数的下标
        Comparable v = a[l];
        while (i<=gt){
            int cmp = a[i].compareTo(v);
            if (cmp<0){
               swap(a,lt++,i++);
            }else if (cmp>0){
                swap(a,i,gt--);
            }else i++;
        }
        //现在a[l,lt-1]<v=a[lt,gt]<a[gt+1,h]
        sort(a,l,lt-1);
        sort(a,gt+1,h);

    }

    private void swap(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i]=a[j];
        a[j]=t;
    }
    @Test
    public void test(){
        Comparable[] ints ={2,1,1,1,5,7,4,3};
        sort(ints,0,ints.length-1);
        for (int i=0;i<ints.length;i++){
            System.out.print(ints[i]+" ");
        }

    }
}
