package com.baosight.bin.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyb
 * @Date 2020/7/1
 * @Description
 **/
public class StreamTest2 {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.putIfAbsent("1", "I");
        map.putIfAbsent("2", "am");
        map.putIfAbsent("3", "your");
        map.putIfAbsent("4", "father");
        //替代传统的for循环
        map.values().stream().forEach(map1 -> System.out.print(map1));
//        //这个是idea提示的最简化方式，但是不知道双冒号是啥情况
//        map.values().forEach(System.out::print);
//        Integer[] arr = {1, 2, 3, 4, 5, 6};
//        Stream<Integer> arr1 = Stream.of(arr);
        //第一种遍历
//        arr1.forEach((Integer arr3) -> {
//            System.out.print(arr3);
//        });
        //第二种遍历
//        arr1.forEach(arr2 -> System.out.print(arr2));
        //系统第三种遍历
//        arr1.forEach(System.out::print);
//        String[] string = {"张无忌", "周芷若", "张三丰", "张三"};
//        Stream.of(string)
//                .filter(name -> name.startsWith("张"))
//                .filter(name -> name.length() == 3)
//                .forEach(name -> System.out.print(name));
//        Stream.of(string)
//                .filter(name -> name.startsWith("张"))
//                .filter(name -> name.length() == 3)
//                .forEach(System.out::print);
        //使用map把字符串类型的值转换为Integer类型的值
//        String[] arr = {"1", "2", "3", "4", "5"};
//        Stream.of(arr)
//                .map(string -> Integer.parseInt(string))
//                .forEach(integer -> System.out.print(integer));
//        System.out.println();
//        Stream.of(arr)
//                .map(Integer::parseInt)
//                .forEach(System.out::print);
        //利用count返回数组的元素个数
//        long count = Stream.of(arr).count();
//        System.out.println(count);
        //使用limit方法取值
//        Stream.of(arr).limit(3).forEach(num -> System.out.print(num));
//        System.out.println();
//        Stream.of(arr).limit(3).forEach(System.out::print);
        //使用skip跳过元素
//        Stream.of(arr).skip(3).forEach(v -> System.out.println(v));
        //concat
//        Stream<String> stream1 = Stream.of(string);
//        Stream<String> stream2 = Stream.of(arr);
//        Stream.concat(stream1, stream2).forEach(v -> System.out.println(v));
    }
}
