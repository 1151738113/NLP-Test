package com.nlp.learn.IBM;

import com.ibm.watson.developer_cloud.discovery.v1.Discovery;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifyOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.*;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

/**
 * Created by wei.wang on 2018/8/7 0007.
 */
public class IbmCloud {

    public static void main(String[] args){

        String url = "https://gateway.watsonplatform.net/natural-language-understanding/api";
        String name = "2cbb20d3-074e-4e2b-945c-15319b93a7fb";
        String passwd = "RTXpkiz0vtpF";
        String api_key = "Auto-generated service credentials";

        NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding("2018-09-27",name,passwd);

        String text = "小明在北京大学";


        EntitiesOptions entitiesOptions = new EntitiesOptions.Builder()
                .emotion(true)
                .sentiment(true)
                .limit(10)
                .build();

        KeywordsOptions keywordsOptions = new KeywordsOptions.Builder()
                .emotion(true)
                .sentiment(true)
                .limit(10)
                .build();

        Features features = new Features.Builder()
                .entities(entitiesOptions)
                .keywords(keywordsOptions)
                .build();

        AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                .text(text)
                .features(features)
                .build();

        AnalysisResults response = service
                .analyze(parameters)
                .execute();
        System.out.println(response);
    }

}
