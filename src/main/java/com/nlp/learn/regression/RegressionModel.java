package com.nlp.learn.regression;

/**
 * Created by wei.wang on 2018/9/26 0026.
 */
public class RegressionModel {

    private int label;

    private double[] x;

    public RegressionModel(int label, double[] x) {
        this.label = label;
        this.x = x;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public double[] getX() {
        return x;
    }

    public void setX(double[] x) {
        this.x = x;
    }
}
