package com.nlp.learn.tool;


import java.util.concurrent.TimeUnit;


/**
 * TimeUtil用于
 */
public class TimeTool {

    public static void main(String[] args) {
        long diffMin = TimeUnit.HOURS.convert(1, TimeUnit.DAYS);
        System.out.println(diffMin);
    }

}
