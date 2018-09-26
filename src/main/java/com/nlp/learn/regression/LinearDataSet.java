package com.nlp.learn.regression;

/**
 * Created by wei.wang on 2018/9/26 0026.
 * 线性回归模型
 */
public class LinearDataSet {

    private double x;

    private double y;

    public LinearDataSet(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getXY(){
        return this.x * this.y;
    }
}
