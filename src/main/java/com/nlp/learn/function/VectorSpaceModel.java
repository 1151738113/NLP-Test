package com.nlp.learn.function;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VectorSpaceModel {

    public static double calCosSim(Map<String,Double> v1, Map<String,Double> v2){
        double sclar = 0.0,norm1 = 0.0,norm2 = 0.0,similarity = 0.0;
        Set<String> v1Key = v1.keySet();
        Set<String> v2Key = v2.keySet();
        Set<String> both = new HashSet<>();
        both.addAll(v1Key);
        //both中留下v1和v2的交集
        both.retainAll(v2Key);
        //计算出交集部分的词的向量的点乘
        for(String str1 : both){
            sclar += v1.get(str1) * v2.get(str1);
        }
        //分别计算v1、v2的每个词的向量平方和
        for(String str : v1.keySet()){
            norm1 += Math.pow(v1.get(str),2);
        }

        for(String str : v2.keySet()){
            norm2 += Math.pow(v2.get(str),2);
        }
        similarity = sclar/Math.sqrt(norm1*norm2);
        System.out.println("sclar:"+sclar);
        System.out.println("norm1:"+norm1);
        System.out.println("norm2:"+norm2);
        System.out.println("similarity:"+similarity);
        return similarity;
    }

    public static void main(String[] args){
        Map<String,Double> m1 = new HashMap<>();
        m1.put("Hellow",1.0);
        m1.put("java",2.0);
        m1.put("Lucene",3.0);

        Map<String,Double> m2 = new HashMap<>();
        m2.put("Hellow",1.0);
        m2.put("java",2.0);
        m2.put("World",2.0);
        m2.put("Hadoop",3.0);
        m2.put("html",1.0);
        m2.put("css",2.0);
        calCosSim(m1,m2);
    }
}
