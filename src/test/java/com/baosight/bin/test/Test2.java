package com.baosight.bin.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author zyb
 * @Date Create in 2020/8/3 14:44
 * @Description 实现sortStringByLength()方法对List<String>列表数据按照字符串长度从小到大排序
 * 预期输出:b aa ccc
 **/
public class Test2 {

    public static void sortStringByLength(List<String> input) {
        input.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int temp = o1.length() - o2.length();
                return temp == 0 ? o1.compareTo(o2) : temp;
            }
        });
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("aa", "b", "ccc");
        sortStringByLength(input);
        input.forEach(System.out::println);
    }
}
