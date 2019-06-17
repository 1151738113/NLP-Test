package com.nlp.learn.function;

import java.util.Arrays;
import java.util.List;

public class search {

    /**
     * 计算tf   =  词频/doc词项长度
     * @param doc 分过词后的文档
     * @param term  需要计算的词
     * @return
     */
    public double tf(List<String> doc,String term){
        double termFrequency = 0;
        for(String word : doc){
            //统计词频
            if(word.equalsIgnoreCase(term)){
                termFrequency++;
            }
        }
        return termFrequency/doc.size();
    }


    /**
     * 计算文档频率，既在所有文档中出现该词的文档数；
     * @param docs
     * @param term
     * @return
     */
    public int df(List<List<String>> docs, String term){
        int n = 0;
        if(term != null && term != ""){
            for(List<String> doc : docs){
                for(String word : doc){
                    if(term.equalsIgnoreCase(word)){
                        n++;
                        break;
                    }
                }

            }

        }
        return n;
    }

    /**
     * 计算idf = log(文档集的文档数/(df+1))
     * @param docs
     * @param term
     * @return
     */
    public double idf(List<List<String>> docs,String term){
        return Math.log(docs.size()/((double)df(docs,term)+1));
    }

    /**
     * 计算tf-idf  = tf * idf
     * @param doc
     * @param docs
     * @param term
     * @return
     */
    public double tdIdf(List<String>  doc, List<List<String>> docs,String term){
        return tf(doc,term) * idf(docs,term);
    }

    public static void main(String[] args){
        List<String> doc1 = Arrays.asList("人工","智能","成为","互联网","大会","焦点");
        List<String> doc2 = Arrays.asList("谷歌","推出","开源","人工","智能","系统","工具");
        List<String> doc3 = Arrays.asList("互联网","的","未来","在","人工","智能","吗");
        List<String> doc4 = Arrays.asList("谷歌","开源","机器","学习","工具");
        List<List<String>> documents = Arrays.asList(doc1,doc2,doc3,doc4);
        search search = new search();
        System.out.println(search.tf(doc2,"谷歌"));
        System.out.println(search.df(documents,"谷歌"));
        double tfidf = search.tdIdf(doc2,documents,"谷歌");
        System.out.println("TF-IDF(谷歌) = "+tfidf);
    }
}
