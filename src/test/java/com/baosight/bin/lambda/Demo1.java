package com.baosight.bin.lambda;

/**
 * @Author zyb
 * @Date Create in 2020/7/8 8:36
 * @Description
 **/
public class Demo1 {
    interface Printer {
        void print(String value);
    }

    public void doSomething(String something,Printer printer){
        printer.print(something);
    }

    /**
     * @Author zyb
     * @Description static main method
     * @Date 2020/7/8 8:39
     * @Param [args]
     * @Return void
     **/
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        String some = "test";
        Printer printer = System.out::println;
        demo1.doSomething(some, printer);
    }
}
