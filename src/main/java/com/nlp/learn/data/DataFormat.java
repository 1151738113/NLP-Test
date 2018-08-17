package com.nlp.learn.data;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by wei.wang on 2018/8/1 0001.
 * 将公告信息format处理
 */
public class DataFormat {

    private static List<String> notices = Lists.newArrayList();
    private static List<String> dic = Lists.newArrayList();
    private static Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true).enableOrganizationRecognize(true);
    private static List<String> link = Lists.newLinkedList();

    public static void main(String[] args) throws Exception {

        //N-short最短路径分词
        read("dictionary/goods.txt", dic);
        read("dictionary/notice.txt", notices);

        for (String notice : notices) {
            format(notice);
        }
        FileWriter writer = new FileWriter("src/main/resources/result.txt");
        if (link.size() > 0) {
            for (String s : link) {
                System.out.println(s);
//                if(s.endsWith("\\goods")){
//                    s = s.replaceAll("\\\\goods","");
                    if (s.length() == 1) {
                        writer.write(s + "\t" + "S" + "\n");
                    } else if (s.length() == 2) {
                        String start = s.substring(0, 1) + "\t" + "B";
                        writer.write(start + "\n");
                        String end = s.substring(1, 2) + "\t" + "E";
                        writer.write(end + "\n");
                    } else if (s.length() > 2) {
                        String start = s.substring(0, 1) + "\t" + "B";
                        writer.write(start + "\n");
                        for (int i = 1; i < s.length(); i++) {
                            String a = s.substring(i, i + 1) + "\t" + "M";
                            writer.write(a + "\n");
                        }
                        String end = s.substring(s.length() - 1, s.length())+ "\t" + "E";
                        writer.write(end + "\n");
                    }
//                }else{
//                    for(int i = 0; i< s.length(); i++){
//                        writer.write(s.substring(i,i+1)+"\t"+"S"+"\n");
//                    }
//                }
            }
        }
        writer.close();
    }

    /**
     * 读取数据
     */
    private static void read(String path, List<String> list) throws Exception {
        InputStream in = DataFormat.class.getClassLoader().getResourceAsStream(path);
        InputStreamReader reader = new InputStreamReader(in, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        in.close();
        reader.close();
        br.close();
    }


    /**
     * 解析结果
     */
    private static void format(String text) throws Exception {
        List<Term> results = removeChild(getTerm(text));
        if (results.size() > 0) {
            String str = "";
            for (Term term : results) {
                link.add(term.word);
                str += str + term + "|";
            }
            str = str.substring(0, str.length() - 1);
            String[] ss = text.split(str);
            for (String s : ss) {
                List<Term> t1 = nShortSegment.seg(s);
                for (Term term : t1) {
                    link.add(term.word);
                }
            }

        } else {
            List<Term> terms = nShortSegment.seg(text);
            for (Term term : terms) {
                link.add(term.word);
            }
        }
    }

    public static List<Term> removeChild(List<Term> terms) {
        if (terms.size() == 0) {
            return new ArrayList<>();
        }
        sort(terms);
        Set<Term> result = Sets.newHashSet();
        Set<Term> child = Sets.newHashSet();
        for (int i = 0; i < terms.size(); i++) {
            if (i == terms.size() - 1) {
                if (!child.contains(terms.get(i))) {
                    result.add(terms.get(i));
                }
            }
            for (int j = i + 1; j < terms.size(); j++) {
                if (terms.get(i).word.contains(terms.get(j).word)) {
                    child.add(terms.get(j));
                    if (!child.contains(terms.get(i))) {
                        result.add(terms.get(i));
                    }
                } else {
                    if (!child.contains(terms.get(i))) {
                        result.add(terms.get(i));
                    }
                }
            }
        }
        //如果长度为1,则将原始数据加入result
        if (terms.size() == 1) {
            result.addAll(terms);
        }
        return new ArrayList<Term>(result);
    }

    /**
     * 根据字符长度排序
     *
     * @param list
     */
    private static void sort(List<Term> list) {
        Collections.sort(list, new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                if (o1.word.length() > o2.word.length()) {
                    return -1;
                } else if (o1.word.length() == o2.word.length()) {
                    return 0;
                }
                return 1;
            }
        });
    }


    private static List<Term> getTerm(String text) {
        List<Term> words = Lists.newArrayList();
        for (String word : dic) {
            if (text.contains(word)) {
                words.add(new Term(word, Nature.n));
            }
        }
        return words;
    }

    /**
     * @param list
     * @param terms
     * @return
     */
    private static boolean isInclude(List<Term> list, List<Term> terms) {
        for (Term term : list) {
            for (Term term1 : terms) {
                if (term.word.equals(term1.word)) {
                    return true;
                }
            }
        }
        return false;
    }

}
