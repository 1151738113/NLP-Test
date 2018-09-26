package com.nlp.learn.regression;

import com.google.common.collect.Lists;
import com.nlp.learn.data.DictionaryAnalysis;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wei.wang on 2018/9/26 0026.
 */
public class LinearRegression {

    private List<LinearDataSet> list;

    private double alpha;

    private double beta;

    private double r;

    public LinearRegression(String path){
        this.list = Lists.newArrayList();
        init(path);
    }

    private void init(String fileName) {
        List<LinearDataSet> list = Lists.newArrayList();
        InputStream in = DictionaryAnalysis.class.getClassLoader().getResourceAsStream(fileName);
        try {
            InputStreamReader reader = new InputStreamReader(in, "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] strs = line.split(",");
                list.add(new LinearDataSet(Double.parseDouble(strs[0]), Double.parseDouble(strs[1])));
            }
            reader.close();
            br.close();
            in.close();
        } catch (Exception e) {
            System.out.println();
        }
        this.list.addAll(list);
    }

    public double getAlpha() {
        return alpha;
    }

    public double getBeta() {
        return beta;
    }

    public double getR() {
        return r;
    }

    public void getAB(){
        int n = list.size();
        double sumX = 0.0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;

        for(LinearDataSet linearDataSet : list){
            sumX += linearDataSet.getX();
            sumY += linearDataSet.getY();
            sumXY += linearDataSet.getXY();
            sumX2 += Math.pow(linearDataSet.getX(), 2);
        }
        this.alpha = (((sumY * sumX) / n) - sumXY) / (((sumX * sumX) / n) - sumX2);
        this.beta = (sumY - this.alpha * sumX) / n;
    }

    public void getR2(){
        double num = 0;
        double den = 0;
        double sumY = 0;

        for (LinearDataSet dataNode : list){
            sumY += dataNode.getY();
        }

        double avgY = sumY / list.size();

        for (LinearDataSet dataNode : list){
            num += Math.pow((dataNode.getY() - (dataNode.getX() * this.alpha + beta)), 2);
            den += Math.pow((dataNode.getY() - avgY), 2);
        }
        this.r = 1 - (num / den);
    }


    public static void main(String[] args){

        String path = "text.txt";
        LinearRegression linearRegression = new LinearRegression(path);
        linearRegression.getAB();
        linearRegression.getR2();
        System.out.println("alpha = " + linearRegression.getAlpha());
        System.out.println("beta = " + linearRegression.getBeta());
        System.out.println("R2 = " + linearRegression.getR());

    }




}
