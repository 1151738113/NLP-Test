package com.nlp.learn.sort;

/**
 * Created by wei.wang on 2018/9/29 0029.
 * 快速排序思路： 挖坑填数+分治法
 * 1、先从数列中取出一个数作为基准数
 *
 * 2、分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边
 *
 * 3、再对左右区间重复第二步，直到各区间只有一个数
 */
public class FastSort {

    public static void main(String[] args){

        int[] a = {12,20,5,16,15,1,30,45,23,9};
        int start = 0;
        int end = a.length-1;
//        _quickSort(a,start,end);
        quick(a);
        for(int i = 0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }


    private static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && list[high] > tmp) {
                high--;
            }
            list[low] = list[high];   //比中轴小的记录移到低端
            while (low < high && list[low] < tmp) {
                low++;
            }
            list[high] = list[low];   //比中轴大的记录移到高端
        }
        list[low] = tmp;              //中轴记录到尾
        return low;                   //返回中轴的位置
    }

    private static void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二
            _quickSort(list, low, middle - 1);        //对低字表进行递归排序
            _quickSort(list, middle + 1, high);       //对高字表进行递归排序
        }
    }

    private static void quick(int[] str) {
        if (str.length > 0) {    //查看数组是否为空
            _quickSort(str, 0, str.length - 1);
        }
    }

}
