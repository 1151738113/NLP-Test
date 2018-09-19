package com.nlp.learn.decision.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wei.wang on 2018/9/13 0013.
 */
public class FileReadUtils {
    public static List<String> readLines(String filePath){
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(new File(filePath)), "utf-8"));
            String tmp = "";
            while ((tmp = br.readLine()) != null)
                list.add(tmp);
            br.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
