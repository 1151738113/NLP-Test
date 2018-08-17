package com.nlp.learn.demo;

import com.nlp.learn.function.Viterbi;

import static com.nlp.learn.demo.ViterbiExample.Activity.clean;
import static com.nlp.learn.demo.ViterbiExample.Activity.shop;
import static com.nlp.learn.demo.ViterbiExample.Activity.walk;
import static com.nlp.learn.demo.ViterbiExample.Weather.Rainy;
import static com.nlp.learn.demo.ViterbiExample.Weather.Sunny;

/**
 * Created by wei.wang on 2018/8/6 0006.
 * 维特比算法的demo
 */
public class ViterbiExample {

    enum Weather {
        Rainy,
        Sunny,
    }

    enum Activity {
        walk,
        shop,
        clean,
    }

    static int[] states = new int[]{Rainy.ordinal(), Sunny.ordinal()};
    static int[] observations = new int[]{walk.ordinal(), shop.ordinal(), clean.ordinal()};
    static double[] start_probability = new double[]{0.6, 0.4};
    static double[][] transititon_probability = new double[][]{
            {0.7, 0.3},
            {0.4, 0.6},
    };
    static double[][] emission_probability = new double[][]{
            {0.1, 0.4, 0.5},
            {0.6, 0.3, 0.1},
    };

    public static void main(String[] args) {
        int[] result = Viterbi.compute(observations, states, start_probability, transititon_probability, emission_probability);
        for (int r : result) {
            System.out.print(Weather.values()[r] + " ");
        }
        System.out.println();
    }

}
