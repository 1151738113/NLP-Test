package com.nlp.learn.regression;

import com.google.common.collect.Lists;
import scala.tools.cmd.gen.AnyVals;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wei.wang on 2018/9/26 0026.
 * 逻辑回归算法实现
 */
public class LogisticRegression {

    //学习率
    private double rate;

    //权重
    private double[] weights;

    //迭代次数
    private int ITERATIONS = 1000;

    public LogisticRegression(int n){
        this.rate = 0.0001;
        weights = new double[n];
    }

    //训练
    private void train(List<RegressionModel> instances) {
        for (int n = 0; n < ITERATIONS; n++)
        {
            double lik = 0.0;
            for (RegressionModel instance : instances) {
                double[] x = instance.getX();
                double predicted = classify(x);
                int label = instance.getLabel();
                for (int j = 0; j < weights.length; j++) {
                    weights[j] = weights[j] - rate * (predicted - label) * x[j];
                }
                // not necessary for learning
                lik -= label * Math.log(classify(x)) + (1 - label) * Math.log(1 - classify(x));
            }
            System.out.println("iteration: " + n + " " + Arrays.toString(weights) + " mle: " + lik);
        }
    }

    private double classify(double[] x) {
        double logit = .0;
        for (int i=0; i<weights.length;i++)  {
            logit += weights[i] * x[i];
        }
        return sigmoid(logit);
    }

    //sigmoid函数
    private double sigmoid(double z){
        return 1.0 / (1.0 + Math.exp(-z));
    }

    public static void main(String[] args) throws Exception {

        List<RegressionModel> list = DataSet.readDataSet("F:\\ww\\nlp-realize\\src\\main\\resources\\iris.txt");

        LogisticRegression logisticRegression = new LogisticRegression(4);

        logisticRegression.train(list);

        double[] x = {5.0,3.3,1.4,0.2};

        System.out.println("prob(1|x) = " + logisticRegression.classify(x));

        if(logisticRegression.classify(x) < 0.5)
        {
            System.out.println("this kind  is " + "Setosa");
        }
        else
        {
            System.out.println("this kind  is " + "Versicolor");
        }

        double [] x2 = {5.7,2.8,4.1,1.3};
        System.out.println("prob(1|x2) = " + logisticRegression.classify(x2));
        if(logisticRegression.classify(x2) < 0.5)
        {
            System.out.println("this kind  is " + "Setosa");
        }
        else
        {
            System.out.println("this kind  is " + "Versicolor");
        }

   }

}
