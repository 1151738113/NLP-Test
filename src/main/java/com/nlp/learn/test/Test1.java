package com.nlp.learn.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class Test1 {

    private static List<String> paths = new ArrayList<>();

    private static Map<String,Short> map = new HashMap<>();

    static {
        String path = "C:\\Users\\ww\\Desktop\\00粮食储备处统计数据模块\\数据表-按机构";		//要遍历的路径
        File file = new File(path);		//获取其file对象
        File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
        for(File f:fs){					//遍历File[]数组
            if(!f.isDirectory()){
                paths.add(f.toString());
            }
        }
    }



    public static void main(String[] args) {

        Workbook workbook = readExcel(paths.get(0));
        Sheet sheet = workbook.getSheetAt(0);
        Row row1 = sheet.getRow(3);
        short num = row1.getLastCellNum();
        for(short i=0; i< num;i++){
            System.out.println(row1.getCell(i).getStringCellValue());
        }
        System.out.println("====================================********=========================================");
        Row row2 = sheet.getRow(4);
        for(short i=0; i< num;i++){
            System.out.println(row2.getCell(i).getStringCellValue());
        }


//        for(String path : paths){
//            //读取Excel
//            Workbook workbook = readExcel(path);
//
//            //获取第一个sheet
//            Sheet sheet = workbook.getSheetAt(0);
//
//            Sheet sheet1 = workbook.getSheet("");
//            short num = sheet.getRow(4).getLastCellNum();
//            map.put(path,num);
//        }
//        List<Map.Entry<String, Short>> list = new ArrayList<Map.Entry<String, Short>>(map.entrySet());
//
//        Collections.sort(list, new Comparator<Map.Entry<String, Short>>() {
//            @Override
//            public int compare(Map.Entry<String, Short> o1, Map.Entry<String, Short> o2) {
//                if(o1.getValue()>o2.getValue()){
//                    return 1;
//                }
//                if(o1.getValue()<o2.getValue()){
//                    return -1;
//                }
//                return 0;
//            }
//        });
//
//        for(Map.Entry<String, Short> m : list){
//            System.out.println("文件路径为---"+m.getKey()+"            文件长度为："+m.getValue());
//        }
    }

    //读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }




}
