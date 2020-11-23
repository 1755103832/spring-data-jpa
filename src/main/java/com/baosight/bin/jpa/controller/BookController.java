package com.baosight.bin.jpa.controller;

import com.alibaba.excel.EasyExcel;
import com.baosight.bin.jpa.model.Book;
import com.baosight.bin.jpa.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/**
 * @Author zyb
 * @Date 2020/7/2
 * @Description
 **/
@RestController
@Api(tags = "Book接口")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/count")
    @ApiOperation(value = "返回表的条数")
    public Long count() {
        return bookService.bookCount();
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 10:34
     * @Param []
     * @Return java.util.List<com.aaa.bin.jpa.model.Book>
     **/
    @GetMapping("/all")
    @ApiOperation(value = "查询Book信息")
    public List<Book> queryBooks() {
        return bookService.queryBooks();
    }

    /**
     * @Author zyb
     * @Description
     * @Date 15:02
     * @Param [id]
     * @Return java.util.Optional<com.aaa.bin.jpa.model.Book>
     **/
    @GetMapping("/byId")
    public Optional<Book> queryById(Long id) {
        return bookService.queryBooksById(id);
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 15:22
     * @Param []
     * @Return com.aaa.bin.jpa.model.Book
     **/
    @GetMapping("/save")
    public Book addOneBookInfo() {
        return bookService.saveBook();
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 16:04
     * @Param []
     * @Return com.aaa.bin.jpa.model.Book
     **/
    @GetMapping("/modify")
    public Book modifyBook() {
        return bookService.modifyBookInfo();
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 16:15
     * @Param [id]
     * @Return java.lang.Integer
     **/
    @GetMapping("/delById")
    public Integer delBook(Long id) {
        bookService.delBookById(id);
        return 1;
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 16:23
     * @Param [book]
     * @Return com.aaa.bin.jpa.model.Book
     **/
    @GetMapping("/add")
    public Book currentAddBook(Book book) {
        return bookService.currentAdd(book);
    }

    /**
     * @Author zyb
     * @Description
     * @Date 2020/7/2 16:51
     * @Param [bookName]
     * @Return java.util.List<com.aaa.bin.jpa.model.Book>
     **/
    @GetMapping("/fuzzyQuery")
    public List<Book> fuzzyQuery(String bookName) {
        return bookService.fuzzyQueryBook(bookName);
    }

//    @RequestMapping("/getTrainExcel")
//    public void search_archives(@RequestParam("activity_guid") String  activity_guid,
//                                HttpServletRequest request, HttpServletResponse response) throws IOException {
//
////list就是我读出的数据，Cys_activity_detail是我的一个实体类 只有姓名和电话号码两个属性，你可以用你自己的
//        List<Cys_activity_detail> list = trainActivityService.getOneActivityAll(activity_guid);
//
//        HSSFWorkbook wb = new  HSSFWorkbook();
//        HSSFSheet sheet = wb.createSheet("测试表");  //表的名字  一个sheet
//        HSSFRow row1=sheet.createRow(0);
//        HSSFCell cell=row1.createCell(0);
//        cell.setCellValue("活动报名表");        //设置单元格内容
//        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
//        HSSFRow row2=sheet.createRow(1);
//        row2.createCell(0).setCellValue("姓名");
//        row2.createCell(1).setCellValue("电话号码");
//
//        for(int i = 0;i < list.size();i++) {
//            HSSFRow row3=sheet.createRow(i+2);
//            row3.createCell(0).setCellValue(list.get(i).getEnrolment_name());
//            row3.createCell(1).setCellValue(list.get(i).getTEL());
//
//        }
//
//        //shuchu excel
//        OutputStream output=response.getOutputStream();
//        response.reset();
//        response.setHeader("Content-disposition", "attachment; filename=Student.xls");
//        response.setContentType("application/msexcel");
//        wb.write(output);
//        output.close();
//    }

    /**
     * @Author zyb
     * @Description 图书信息导出excel
     * @Datetime 2020/10/13 11:01
     * @Param [request, response]
     * @Return void
     **/
    @ApiOperation(value = "图书信息导出excel")
    @GetMapping("/book2excel")
    public void book2excel(HttpServletResponse response) {
        List<Book> books = bookService.queryBooks();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("图书信息表");
        // 表头样式
        CellStyle headerStyle = workbook.createCellStyle();
        // 水平居中
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        // 垂直居中
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 设置边框
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerStyle.setFont(headerFont);
        // 单元格样式
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置边框
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        //设置自动换行
        cellStyle.setWrapText(true);
        String[] data = new String[books.size()];
        //设置自动列宽
        for (int i = 0; i < data.length; i++) {
            sheet.autoSizeColumn(i);
            sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 17 / 10);
        }

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("图书信息表");
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
        Row row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("图书编号");
        row2.createCell(1).setCellValue("图书名称");
        row2.createCell(2).setCellValue("图书价格");
        for (int i = 0; i < books.size(); i++) {
            Row row3 = sheet.createRow(i + 2);
            row3.createCell(0).setCellValue(books.get(i).getId());
            row3.createCell(1).setCellValue(books.get(i).getBookName());
            row3.createCell(2).setCellValue(books.get(i).getBookPrice());
        }
        try {
            OutputStream outputStream = response.getOutputStream();
            response.reset();//清楚buffer缓存
            response.setHeader("Content-disposition", "attachment;filename="
                    + URLEncoder.encode("Books.xlsx", String.valueOf(StandardCharsets.UTF_8)));
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            outputStream.flush();
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    private List<Book> data() {
//        List<Book> list = bookService.queryBooks();
//        for (int i = 0; i < list.size(); i++) {
//            Book data = new Book();
//            data.getId();
//            data.getBookName();
//            data.getBookPrice();
//            list.add(data);
//        }
//        return list;
//    }

    // 根据list 写入 Excel

    /**
     * 最简单的写
     * <p>1. 创建excel对应的实体对象 参照{@link Book}
     * <p>2. 直接写即可
     */
    @ApiOperation(value = "easyExcel")
    @GetMapping("/easyExcel")
    public void simpleWrite() {
        List<Book> books = bookService.queryBooks();
        String path = "E:\\BaiduNetdiskDownload\\";
        String fileName = path + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Book.class).sheet("Sheet1").doWrite(books);

    }

}
