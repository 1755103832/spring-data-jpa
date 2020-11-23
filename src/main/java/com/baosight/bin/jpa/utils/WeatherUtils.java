package com.baosight.bin.jpa.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * java调用中央气象局天气预报接口
 */
@SuppressWarnings("all")
public class WeatherUtils {

    /**
     * @Author zyb
     * @Description 获取实时天气情况(cityId - - > 城市天气编码)
     * @Datetime 2020/11/5 10:28
     * @Param [cityId]
     * @Return java.util.Map<java.lang.String, java.lang.Object>
     **/
    public static Map<String, Object> getTodayWeather(String cityId)
            throws IOException, NullPointerException {
        // 连接中央气象台的API
        URL url = new URL("http://www.weather.com.cn/data/cityinfo/" + cityId + ".html");
        URLConnection connectionData = url.openConnection();
        connectionData.setConnectTimeout(1000);
        Map<String, Object> map = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connectionData.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String datas = sb.toString();
            System.out.println(datas);
            JSONObject jsonData = JSONObject.parseObject(datas);
            JSONObject info = jsonData.getJSONObject("weatherinfo");
            map.put("city", info.getString("city").toString());// 城市
            map.put("temp1", info.getString("temp1").toString());// 最低温度
            map.put("temp2", info.getString("temp2").toString());// 最高温度
            map.put("weather", info.getString("weather").toString());// 天气
            map.put("ptime", info.getString("ptime").toString());// 发布时间
        } catch (SocketTimeoutException e) {
            System.out.println("连接超时");
        } catch (FileNotFoundException e) {
            System.out.println("加载文件出错");
        }
        return map;
    }

    public static void main(String[] args) {
        try {
            Map<String, Object> map2 = getTodayWeather("101020100");
            System.out.println(map2.get("city") + "\t" + map2.get("temp1")
                    + "\t" + map2.get("temp2") + "\t" + map2.get("weather")
                    + "\t" + map2.get("ptime"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
