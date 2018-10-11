package sort.countSort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 简单计数排序
 *
 */
public class SimpleCountSort {

    public int[] countSort(int[] array){
        //1.获得数组的最大数值
        int max = array[0];
        for (int i=1;i<array.length;i++){
            if (array[i]>max)
                max=array[i];
        }

        //2.根据数组最大值确定统计数组的长度
        int[] countArray = new int[max + 1];

        //3.遍历数组，填充统计数组
        for (int i=0;i<array.length;i++){
            countArray[array[i]]++;
        }

        //4.遍历统计数组，输出结果
        int index=0;
        int[] sortedArray = new int[array.length];
        for (int i=0;i<countArray.length;i++){
            for (int j=0;j<countArray[i];j++){
                sortedArray[index++]=i;
            }
        }
        return sortedArray;
    }
    @Test
    public void test(){
        int[] arr = {2, 8, 1, 2, 6, 7, 9};
        int[] ints = countSort(arr);
        System.out.println(Arrays.toString(ints));
    }
}
