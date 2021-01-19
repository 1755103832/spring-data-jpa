package com.baosight.jpa.algorithm;

/**
 * @author ZYB
 */
public class HashMapAlgorithm {

    /**
     * HashMap的扰动函数-->解决哈希碰撞问题
     * 计算Key的Hash值
     *
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        Object key = 66;
        System.out.println(HashMapAlgorithm.hash(key));
    }
}
