//package com.nlp.learn.test;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//
//public class Test2 {
//
//    private String path= "C:\\Users\\ww\\Desktop\\00粮食储备处统计数据模块\\数据表-按机构\\繁昌县.xls";
//
//    public static void main(String[] args) {
//        Test2 test2 = new Test2();
//        test2.begin();
//    }
//
//    /**
//     * 读取不同的sheet
//     */
//    public void begin(){
//        Workbook workbook = readExcel(path);
//        //读取（地方储备粮油合计_地方储备粮油合计）
//        Sheet sheet = getSheet(workbook,"地方储备粮油合计_地方储备粮油合计");
//        if(sheet == null){
//            return;
//        }
//        //获取行数
//        int length = sheet.getLastRowNum();
//        System.out.println("------------------------长度为："+length);
//        //从第五行开始
//        for(int i = 6; i<length-1;i++){
//            System.out.println("");
//            Row row = sheet.getRow(i);
//            //获取列数
//            int num = row.getLastCellNum();
//            for(int j = 0 ; j<num ; j++){
//                if(j==0){
//                    Cell cell = row.getCell(j);
//                    Object value = getVaue(cell);
//                    System.out.print(value+" ");
//                }
//                Cell cell = row.getCell(j);
//                Object value = getVaue(cell);
//                System.out.print(value+" ");
//            }
//        }
//    }
//
//    //获取值
//    private Object getVaue(Cell cell){
//        switch (cell.getCellTypeEnum()){
//            case NUMERIC:
//                return cell.getNumericCellValue();
//            case STRING:
//                return cell.getStringCellValue();
//            case BLANK:
//                return "";
//            default:
//                return "";
//        }
//    }
//
//    /**
//     * 读取不同名称的sheet
//     * @param workbook
//     * @param name
//     * @return
//     */
//    private Sheet getSheet(Workbook workbook,String name){
//        Sheet sheet = null;
//        sheet = workbook.getSheet(name);
//        return sheet;
//    }
//
//
//
//
//
//    //读取excel
//    public static Workbook readExcel(String filePath){
//        Workbook wb = null;
//        if(filePath==null){
//            return null;
//        }
//        String extString = filePath.substring(filePath.lastIndexOf("."));
//        InputStream is = null;
//        try {
//            is = new FileInputStream(filePath);
//            if(".xls".equals(extString)){
//                return wb = new HSSFWorkbook(is);
//            }else if(".xlsx".equals(extString)){
//                return wb = new XSSFWorkbook(is);
//            }else{
//                return wb = null;
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return wb;
//    }
//
//}
