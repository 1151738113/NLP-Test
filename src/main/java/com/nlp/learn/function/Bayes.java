package com.nlp.learn.function;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;
import com.nlp.learn.tool.DecimalCalculate;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wei.wang on 2018/8/17 0017.
 */
public class Bayes {

    private int normalSum = 0;

    private int spanSum = 0;

    private static List<String> stop = Lists.newArrayList();

    private Map<String, Integer> normalMap = Maps.newHashMap();

    private Map<String, Integer> spanMap = Maps.newHashMap();

    private Map<String, Double> normalScore = Maps.newHashMap();

    private Map<String, Double> spanScore = Maps.newHashMap();

    private Map<String, Double> retmap = Maps.newHashMap();

    private static Segment nShortSegment;  //分词器

    private static Segment segment = SpeedTokenizer.SEGMENT.enableCustomDictionary(true).enablePlaceRecognize(true).enableOrganizationRecognize(true);

    static {
//        InputStream in = Bayes.class.getClassLoader().getResourceAsStream("F:\\ww\\nlp-realize\\data\\dict.txt"); //dictionary/
        try {
//            InputStreamReader reader = new InputStreamReader(in, "UTF-8");
//            BufferedReader br = new BufferedReader(reader);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(new File("F:\\ww\\nlp-realize\\data\\dict.txt")), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                if ("".equals(line)) {
                    continue;
                }
                String[] strs = line.split(" ");
                CustomDictionary.insert(strs[0]);
            }
//            in.close();
//            reader.close();
            br.close();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        nShortSegment = new NShortSegment().enableCustomDictionary(true).enablePlaceRecognize(true).enableOrganizationRecognize(true);

        //读取停用词
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(new File("F:\\ww\\nlp-realize\\data\\stop.txt")), "gbk"));
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                stop.add(tmp);
            }
            br.close();
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }


    //词典来源。jieba分词词典
//    public static final String DICT_PATH = BASE_PATH + "\\dict.txt";//分词用的词典


    /**
     * 获取字段及词频
     */
    private void readFile(String filePath, int type) {
        List<String> list = Lists.newArrayList();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(new File(filePath)), "gbk"));
            String line = "";
            while ((line = br.readLine()) != null) {
                if ("".equals(line)) {
                    continue;
                }
                list.addAll(filter(segment.seg(line)));
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        //获取总的数量
        if (type == 1) {
            normalSum += list.size();
            for (String str : list) {
                normalMap.put(str, normalMap.containsKey(str) ? normalMap.get(str) + 1 : 1);
            }
        } else if (type == 2) {
            spanSum += list.size();
            for (String str : list) {
                spanMap.put(str, spanMap.containsKey(str) ? spanMap.get(str) + 1 : 1);
            }
        }
    }

    //过滤掉无用字符
    private List<String> filter(List<Term> terms) {
        List<String> list = Lists.newArrayList();
        Pattern word = Pattern.compile("[\\u4e00-\\u9fa5]");
        for (Term term : terms) {
            Matcher matcher = word.matcher(term.word);
            if (matcher.find() && !stop.contains(term.word)) {
                list.add(term.word);
            }
        }
        return list;
    }


    /**
     * d
     *
     * @return
     */
    private void setNormalScore() {
        for (int i = 201; i <= 1000; i++) {
            String path = "F:\\ww\\nlp-realize\\data\\normal\\" + String.valueOf(i);
            readFile(path, 1);
        }
        //获得总长度
        int max = normalSum;
        double rate = 0.0;
        for (String s : normalMap.keySet()) {
            rate = DecimalCalculate.div(normalMap.get(s), max, 15);
            normalScore.put(s, rate);
        }
    }


    private void setSpanScore() {
        for (int i = 1; i <= 7800; i++) {
            String path = "F:\\ww\\nlp-realize\\data\\spam\\" + String.valueOf(i);
            readFile(path, 2);
        }
        //获得总长度
        int max = spanSum;
        double rate = 0.0;
        for (String s : spanMap.keySet()) {
            rate = DecimalCalculate.div(spanMap.get(s), max, 15);
            spanScore.put(s, rate);
        }
    }


    /**
     * 邮件中出现垃圾邮件中词汇时，该邮件为垃圾邮件的概率
     * p(A)/P(AB)
     */
    private void createSpamProbabilityMap() {

        for (String key : spanMap.keySet()) {
            double rate = spanScore.get(key);
            double allRate = rate;
            if (normalScore.containsKey(key)) {
                allRate += normalScore.get(key);
            }
            double ss = DecimalCalculate.div(rate, allRate, 20);
            if (ss == 1.0) {
                continue;
            }
            retmap.put(key, ss);
        }
    }


    private List<String> getTestData(String filePath) {
        List<String> list = Lists.newArrayList();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(new File(filePath)), "gbk"));
            String line = "";
            while ((line = br.readLine()) != null) {
                if ("".equals(line)) {
                    continue;
                }
                list.addAll(filter(segment.seg(line)));
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获得邮件得分
     *
     * @return
     */
    private double judgeMail(List<String> words) {
        double rate = 1.0;
        double tempRate = 1.0;
        for (String word : words) {
            if (retmap.containsKey(word)) {
                rate *= retmap.get(word);
                tempRate *= (1 - retmap.get(word));
            }
        }
        return get(rate,tempRate,15);
    }


    private double get(double rate,double tempRate,int scala)
    {
        double ss = DecimalCalculate.div(rate, rate + tempRate, scala);
        if(ss == 0.0){
            scala+=5;
            get(rate,tempRate,scala);
        }
        return ss;
    }


    private void writeToFile() throws Exception {
        FileWriter write1 = new FileWriter("F:\\ww\\nlp-realize\\src\\main\\resources\\data\\normal.txt");
        for (Map.Entry<String, Integer> entry : normalMap.entrySet()) {
            write1.write(entry.getKey() + "\t" + entry.getValue() + "\n");
        }
        write1.close();

        FileWriter write2 = new FileWriter("F:\\ww\\nlp-realize\\src\\main\\resources\\data\\spam.txt");
        for (Map.Entry<String, Integer> entry : spanMap.entrySet()) {
            write2.write(entry.getKey() + "\t" + entry.getValue() + "\n");
        }
        write2.close();

        FileWriter write3 = new FileWriter("F:\\ww\\nlp-realize\\src\\main\\resources\\data\\normal_score.txt");
        for (Map.Entry<String, Double> entry : normalScore.entrySet()) {
            write3.write(entry.getKey() + "\t" + entry.getValue() + "\n");
        }
        write3.close();

        FileWriter write4 = new FileWriter("F:\\ww\\nlp-realize\\src\\main\\resources\\data\\spam_score.txt");
        for (Map.Entry<String, Double> entry : spanScore.entrySet()) {
            write4.write(entry.getKey() + "\t" + entry.getValue() + "\n");
        }
        write4.close();

        FileWriter write5 = new FileWriter("F:\\ww\\nlp-realize\\src\\main\\resources\\data\\retmap.txt");
        for (Map.Entry<String, Double> entry : retmap.entrySet()) {
            write5.write(entry.getKey() + "\t" + entry.getValue() + "\n");
        }
        write5.close();
    }


    public static void main(String[] args) throws Exception {
        Bayes bayes = new Bayes();
        bayes.setNormalScore();
        bayes.setSpanScore();
        bayes.createSpamProbabilityMap();
        bayes.writeToFile();
        for (int i = 1; i <= 8000; i++) {
            String path = "F:\\ww\\nlp-realize\\data\\test\\" + String.valueOf(i);
            List<String> list = bayes.getTestData(path);
            System.out.println(bayes.judgeMail(list));
        }
    }


}
