package com.baosight.jpa.algorithm;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZYB
 */
public class MTRandomTest {

    @Test
    public void testCode() {
        // MT19937的Java实现
        MersenneTwister mtRandom = new MersenneTwister();
        Map<Integer, Integer> map = new HashMap<>();
        //循环次数
        int times = 1000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            //使用Map去重
            map.put(mtRandom.next(32), 0);
        }
        //打印循环次数
        System.out.println("times:" + times);
        //打印Map的个数
        System.out.println("num:" + map.size());
        //打印非重复比率
        System.out.println("proportion:" + map.size() / (double) times);
        //花费的时间(单位为毫秒)
        System.out.println("time:" + (System.currentTimeMillis() - startTime));
    }

}
