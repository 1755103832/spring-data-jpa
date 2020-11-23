package com.baosight.bin.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author zyb
 * @Date Create in 2020/10/13 10:04
 * @Description
 **/
@SuppressWarnings("all")
public class MysqlData2Excel {
    public final static String outputFile = "E:\\BaiduNetdiskDownload\\book.xlsx";

    public final static String url = "jdbc:mysql://localhost:3306/database01?useSSL=false";

    public final static String user = "root";

    public final static String password = "123456";

    /**
     * 创建excel返回文件流
     *
     * @param listresult
     * @return
     */
    private static XSSFWorkbook createUserListExcel(List<Map> list) {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Sheet1");
        XSSFRow row = sheet.createRow(0);
        Map map = list.get(0);
        Set<String> set = map.keySet();
        int index = 0;
        String[] title = new String[set.size()];
        //固定表头
        sheet.createFreezePane(title.length, 1);
        for (String str : set) {
            if (index == 0) {
                row.createCell(0).setCellValue("序号");
            }
            row.setHeightInPoints(30);
            title[index] = str;
            row.createCell(++index).setCellValue(str);
        }
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(i + 1);
            for (int j = 0; j < title.length; j++) {
                row.createCell(j + 1).setCellValue(list.get(i).get(title[j]) + "");
            }
        }
        /**
         * 上面的操作已经是生成一个完整的文件了，只需要将生成的流转换成文件即可
         * 下面的设置宽度可有可无，对整体影响不大
         */
        // 设置单元格宽度
        int curColWidth = 0;
        for (int i = 0; i <= title.length; i++) {
            // 列自适应宽度，对于中文半角不友好，如果列内包含中文需要对包含中文的重新设置。
            sheet.autoSizeColumn(i, true);
            // 为每一列设置一个最小值，方便中文显示
            curColWidth = sheet.getColumnWidth(i);
            if (curColWidth < 2500) {
                sheet.setColumnWidth(i, 2500);
            }
        }
        return wb;
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection(url, user, password);
            Statement stat = (Statement) conn.createStatement();
            ResultSet resultSet = stat.executeQuery("select * from book");
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet1");
            sheet.setColumnWidth(0, 800);
            sheet.setColumnWidth(1, 8000);
            sheet.setColumnWidth(2, 2500);
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell = null;
            cell = row.createCell(0);
            cell.setCellValue("id");
            cell = row.createCell(1);
            cell.setCellValue("bookName");
            cell = row.createCell(2);
            cell.setCellValue("bookPrice");
            int i = 1;
            while (resultSet.next()) {
                row = sheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(resultSet.getString("id"));
                cell = row.createCell(1);
                cell.setCellValue(resultSet.getString("book_name"));
                cell = row.createCell(2);
                cell.setCellValue(resultSet.getString("book_price"));
                i++;
            }
            FileOutputStream FOut = new FileOutputStream(outputFile);
            workbook.write(FOut);
            FOut.flush();
            FOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
