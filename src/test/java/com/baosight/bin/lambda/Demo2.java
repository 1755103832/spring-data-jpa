package com.baosight.bin.lambda;

/**
 * @Author zyb
 * @Date Create in 2020/7/8 10:37
 * @Description
 **/
public class Demo2 {

    interface Test {
        void getName(String name);
    }

    public static void main(String[] args) {
//        Test test = (x) -> {
//            System.out.println(x);
//        };

//        Test test = x -> System.out.println(x);

        Test test = System.out::println;
        test.getName("myName");
    }
}
