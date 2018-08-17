package com.nlp.learn.data;

import java.io.*;

/**
 * Created by wei.wang on 2018/8/2 0002.
 * 将词典字符拆分
 */
public class DictionaryAnalysis {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("data/train.txt");
        InputStream in = DictionaryAnalysis.class.getClassLoader().getResourceAsStream("train/train.txt");
        InputStreamReader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            i++;
            String[] line_word = line.split("\t");
//            if (line_word.length < 2) {
//                continue;
//            }
            String second = line_word[1];
            if (second.contains("-")) {
                second = second.split("-")[0] + "-" + "GOODS";
            }
            String line_new = line_word[0] + "\t" + second;
            writer.write(line_new + "\n");
        }
        in.close();
        reader.close();
        br.close();
        writer.close();
        System.out.println("写入数据次数======   "+i);
    }

}
