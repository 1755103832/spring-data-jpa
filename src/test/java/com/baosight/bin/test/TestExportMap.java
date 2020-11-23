package com.baosight.bin.test;

import com.baosight.bin.jpa.mapper.BookMapper;
import com.baosight.bin.jpa.model.Book;
import com.baosight.bin.jpa.utils.ExcelUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TestExportMap {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void exportXls() throws IOException {
//        List<Map<String, Object>> list = new ArrayList<>();
//        Map<String, Object> map = new LinkedHashMap<>();
//        map.put("name", "");
//        map.put("age", "");
//        map.put("birthday", "");
//        map.put("sex", "");
//        Map<String, Object> map2 = new LinkedHashMap<String, Object>();
//        map2.put("name", "测试是否是中文长度不能自动宽度.测试是否是中文长度不能自动宽度.");
//        map2.put("age", null);
//        map2.put("sex", null);
//        map.put("birthday", null);
//        Map<String, Object> map3 = new LinkedHashMap<String, Object>();
//        map3.put("name", "张三");
//        map3.put("age", 12);
//        map3.put("sex", "男");
//        map3.put("birthday", new Date());
//        list.add(map);
//        list.add(map2);
//        list.add(map3);
//        Map<String, String> map1 = new LinkedHashMap<>();
//        map1.put("name", "姓名");
//        map1.put("age", "年龄");
//        map1.put("birthday", "出生日期");
//        map1.put("sex", "性别");
        Map<String, String> map = new ConcurrentHashMap<>();
        map.putIfAbsent("id", "图书编号");
        map.putIfAbsent("bookName", "图书名称");
        map.putIfAbsent("bookPrice", "图书价格");
        Collection<Object> dataset = new ArrayList<>();
        List<Book> list;
        list = bookMapper.findAll();
        dataset.add(list);
        File f = new File("E:\\BaiduNetdiskDownload\\test.xls");
        OutputStream out = new FileOutputStream(f);
        ExcelUtil.exportExcel(map, dataset, out);
        out.close();
    }
}
