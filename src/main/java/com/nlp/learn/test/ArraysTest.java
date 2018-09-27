package com.nlp.learn.test;

import java.util.Arrays;

/**
 * Created by wei.wang on 2018/9/27 0027.
 */
public class ArraysTest {


    public static void main(String[] args){

//        int[] iArray = new int[]{2, 3, 4, 6};
//
//        int missing = getMissingNumber(iArray, 6);
//
//        System.out.printf("Missing number in array %s is %d %n", Arrays.toString(iArray), missing);



    }


    /**
     * （首项+尾项）* 总项数{总数+预测数} / 2
     * @param numbers
     * @param totalCount
     * @return
     */
    private static int getMissingNumber(int[] numbers, int totalCount) {
        int expectedSum = 5 * (totalCount + 2) / 2;
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }





}


