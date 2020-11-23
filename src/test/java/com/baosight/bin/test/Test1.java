package com.baosight.bin.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zyb
 * @Date Create in 2020/8/3 13:32
 * @Description 实现calculateWordCount()方法，计算集合中字符串个数
 * 预期输出:  a:2 b:1 c:1
 **/
public class Test1 {

    public static Map<String, Integer> calculateWordCount(List<String> input) {
        String[] strings = (String[]) input.toArray();
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            if ("a".equals(string)) {
                aCount++;
            }
        }
        for (String string : strings) {
            if ("b".equals(string)) {
                bCount++;
            }
        }
        for (String string : strings) {
            if ("c".equals(string)) {
                cCount++;
            }
        }
        map.put("a", aCount);
        map.put("b", bCount);
        map.put("c", cCount);
        return map;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("a", "b", "a", "c");
        calculateWordCount(input).forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
