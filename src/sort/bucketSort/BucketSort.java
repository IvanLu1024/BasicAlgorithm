package sort.bucketSort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {

    public double[] bucketSort(double[] array) {

        //1.得到数列中的最大最小值，并算出差值
        double max = array[0];
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];

        }
        double d = max - min;

        //2.初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<LinkedList<Double>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }

        //3.遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < array.length; i++) {
            //定位元素属于第几个桶，是按照比例来定位：
            int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        //4.对每个桶内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        //5.输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (double ele : list) {
                sortedArray[index] = ele;
                index++;
            }
        }
        return sortedArray;

    }

    @Test
    public void test() {

        double[] array = new double[] {4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        double[] sort = bucketSort(array);
        for (double d:sort){
            System.out.print(d+" ");
        }


    }
}
