package com.nlp.learn.DataMining_NaiveBayes;

public class Client {

    public static void main(String[] args) {

        String filePath = "train/input.txt";
        String testData = "Sunny Mild High Weak";
        NaiveBayesTool tool = new NaiveBayesTool(filePath);
        System.out.println(testData + " ?????????:" + tool.naiveBayesClassificate(testData));
    }

}
