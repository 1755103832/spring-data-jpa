package com.baosight.bin.test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author zyb
 * @Date 2020/7/1
 * @Description
 **/
public class StreamTest {

    public static void main(String[] args) {
        List<String> lists = new CopyOnWriteArrayList<>();
        lists.add("张无忌");
        lists.add("周芷若");
        lists.add("张三丰");
        lists.add("李俊");
        lists.add("张三");
        lists.add("李斯特");

        //对集合进行第一次过滤，如果性张就通过
        List<String> listsA = new CopyOnWriteArrayList<>();
        for (String list : lists) {
            if (list.startsWith("张")) {
                listsA.add(list);
            }
        }

        //对集合进行第二次过滤，如果长度为3，就通过
        List<String> listsB = new CopyOnWriteArrayList<>();
        for (String s : listsA) {
            if (s.length() == 3) {
                listsB.add(s);
            }
        }

        //最后对过滤两次之后的结果进行循环遍历
        for (String b : listsB) {
            System.out.println(b);
        }

        //使用stream流的形式简化以上代码
        lists.stream()
                .filter(name1 -> name1.startsWith("张"))
                .filter(name2 -> name2.length() == 3)
                .forEach(name3 -> System.out.println(name3));
    }

}
