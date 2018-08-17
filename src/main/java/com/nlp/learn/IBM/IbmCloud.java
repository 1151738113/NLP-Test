package com.nlp.learn.IBM;

import com.ibm.watson.developer_cloud.discovery.v1.Discovery;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifyOptions;
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

        IamOptions options = new IamOptions.Builder()
                .apiKey(api_key)
                .url(url) // optional - the default value is https://iam.bluemix.net/identity/token
                .build();
        Discovery service = new Discovery("2018-08-07", options);
        service.setUsernameAndPassword(name,passwd);

//        NaturalLanguageClassifier service = new NaturalLanguageClassifier();
//        service.setUsernameAndPassword(name, passwd);
//
//        ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
//                .classifierId("<classifierId>")
//                .text("Is it sunny?")
//                .build();
//        Classification classification = service.classify(classifyOptions).execute();
//
//        System.out.println(classification);


    }

}
