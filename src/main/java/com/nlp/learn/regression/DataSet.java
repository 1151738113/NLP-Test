package com.nlp.learn.regression;

import com.google.common.collect.Lists;
import com.nlp.learn.data.DictionaryAnalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wei.wang on 2018/9/26 0026.
 * 数据格式化
 */
public class DataSet {

    static List<RegressionModel> readDataSet(String fileName) throws Exception {
        List<RegressionModel> list = Lists.newArrayList();
        InputStream in = DictionaryAnalysis.class.getClassLoader().getResourceAsStream(fileName);
        InputStreamReader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            if (line.startsWith("#")) {
                continue;
            }
            String[] colums = line.split(",");
            int i = 0;
            double[] data = new double[colums.length - 1];
            for (i = 0; i < colums.length - 2; i++) {
                data[i] = Double.parseDouble(colums[i]);
            }
            int label = Integer.parseInt(colums[colums.length - 1]);
            RegressionModel instance = new RegressionModel(label, data);
            list.add(instance);
        }
        return list;
    }

}
