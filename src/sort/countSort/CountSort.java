package sort.countSort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 增强型计数排序
 *      1.计数数组长度利用数组中的最大差值
 *      2.按输入顺序输出相同大小的元素
 *      稳定排序算法
 *
 *      时间复杂度为O(N+M),N:原始数组的规模，M：最大最小值差值
 */
public class CountSort {

    public int[] countSort(int[] array){
        //1.得到数组中最大值和最小值，并计算出差值
        int max=array[0];
        int min=array[0];
        for (int i=1;i<array.length;i++){
            if (array[i]>max)
                max=array[i];
            if (array[i]<min)
                min=array[i];
        }
        int d = max - min;

        //2.创建统计数组并统计对应元素个数
        int[] countArray = new int[d + 1];
        for (int i=0;i<array.length;i++){
            countArray[array[i]-min]++;
        }

        //3.将统计数组做变形，后面的元素等于前面元素之和
        int sum=0;
        for (int i=0;i<countArray.length;i++){
            sum+=countArray[i];
            countArray[i]=sum;
        }

        //4.倒序遍历原始数组，从统计数组找到正确位置，输出到结果数组中
        int[] sortedArray = new int[array.length];
        for (int i=array.length-1;i>=0;i--){
            sortedArray[countArray[array[i]-min]-1]=array[i];
            countArray[array[i]-min]--;
        }
        return sortedArray;


    }

    @Test
    public void test(){
        int[] arr = {200, 8, 1, 2, 6, 7, 9};
        int[] ints = countSort(arr);
        System.out.println(Arrays.toString(ints));
    }

}
