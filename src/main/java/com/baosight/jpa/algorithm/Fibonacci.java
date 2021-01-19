package com.baosight.jpa.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZYB
 * 用HashMap优化斐波那契数列 java算法
 */
public class Fibonacci {
    private static int times = 0;

    /**
     * 斐波那契是第一项为0，第二项为1，以后每一项是前面两项的和的数列。
     * 求第三十项的时候。调用了函数2692539次，效率及其低
     *
     * @param args
     */
    public static void main(String[] args) {
        int nums = fibonacci(30);
        System.out.println("结果：" + nums);
        System.out.println("次数：" + times);
    }

    static int fibonacci(int n) {
        times++;
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 第二种的优化算法是
     * <p>
     * 利用hashmap记录下每次运算的值，动态规划地输出每次的结果。
     * <p>
     * 第三十项仅仅调用59次。
     */
    public static class HashMapFibonacci {
        private static int times = 0;

        public static int fibonacci(int x, Map<Object, Object> map) {
            times++;
            if (map.containsKey(x)) {
                return (Integer) map.get(x);
            } else if (x == 0 || x == 1) {
                return 1;
            }
            int temp = fibonacci(x - 1, map) + fibonacci(x - 2, map);
            map.put(x, temp);
            return temp;
        }

        public static void main(String[] args) {
            Map<Object, Object> map = new HashMap<>(16);
            int res = fibonacci(30, map);
            System.out.println("结果：" + res);
            System.out.println("次数：" + times);
        }
    }
}
