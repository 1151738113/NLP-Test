package com.nlp.learn.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * @author Wei.Wang
 * @data 2019/5/26 11:23
 */
public class ZipUtils {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();

        File fil = new File("E:\\bwca\\省局三月份数据\\3月份购销存统计数据\\批量导出结果-合肥.zip");
        Charset gbk = Charset.forName("gbk");
        ZipInputStream zipIn = null;
        try {
            zipIn = new ZipInputStream(new FileInputStream(fil),gbk);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ZipEntry zipEn = null;

        /**
         * 需要读取zip文件项的内容时，需要ZipFile类的对象的getInputStream方法取得该项的内容，
         * 然后传递给InputStreamReader的构造方法创建InputStreamReader对象，
         * 最后使用此InputStreamReader对象创建BufferedReader实例
         * 至此已把zip文件项的内容读出到缓存中，可以遍历其内容
         */
        ZipFile zfil = null;
        try {
            zfil = new ZipFile("E:\\bwca\\省局三月份数据\\3月份购销存统计数据\\批量导出结果-合肥.zip",gbk);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            while ((zipEn = zipIn.getNextEntry()) != null) {
                if (!zipEn.isDirectory()) { // 判断此zip项是否为目录
//                    System.out.println(zipEn.getName() + ":\t");
                    if(zipEn.getName().equals("商品粮油收支平衡月报表.xls")){
                        long size = zipEn.getSize();
                        if(size == -1){
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            while (true) {
                                int bytes = zipIn.read();
                                if (bytes == -1) break;
                                baos.write(bytes);
                            }
                            baos.close();
                        }
                        Workbook book = new HSSFWorkbook(zfil.getInputStream(zipEn));
                        //获取表的数量
                        int sheets = book.getNumberOfSheets();
                        int num = 0;
                        for(int i=0;i<sheets;i++){
                            Sheet sheet = book.getSheetAt(i);
                            String sheetName = sheet.getSheetName();
                            String lastName = sheetName.substring(sheetName.length()-1,sheetName.length());
                            if("市".equals(lastName) || "县".equals(lastName) || "区".equals(lastName)){
                                System.out.println("筛选表为===================="+sheetName);
                            }
                            int rowNum = sheet.getLastRowNum();
                            int titleNum = 0;
                            double sum = 0;
                            for(int j = 0; j <= rowNum ;j++){
                                Row row = sheet.getRow(j);
                                Cell cell = row.getCell(0);
                                String name = cell.getStringCellValue().trim();
                                if("粮食品种".equals(name)){
                                    titleNum = j;
                                    break;
                                }
                            }
                            if(titleNum == 5){

                            }
                            num++;
                        }
                        System.out.println(num);

                    }
                }
                zipIn.closeEntry();// 关闭当前打开的项
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                zfil.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
