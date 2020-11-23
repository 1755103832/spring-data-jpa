package com.baosight.bin.test;

import com.alibaba.excel.EasyExcel;
import com.baosight.bin.jpa.mapper.BookMapper;
import com.baosight.bin.jpa.model.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zyb
 * @Date Create in 2020/10/13 17:21
 * @Description
 **/
@Service
@SuppressWarnings("all")
public class EasyExcelTest {

    @Autowired
    private BookMapper bookMapper;

    private List<Book> data() {
        List<Book> list = bookMapper.findAll();
        for (int i = 0; i < list.size(); i++) {
            Book data = new Book();
            data.getId();
            data.getBookName();
            data.getBookPrice();
            list.add(data);
        }
        return list;
    }

    // 根据list 写入 Excel

    /**
     * 最简单的写
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 直接写即可
     */
    @Test
    public void simpleWrite() {
        String PATH = "E:\\BaiduNetdiskDownload\\";
        String fileName = PATH + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, Book.class).sheet("Sheet1").doWrite(data());

    }
}
