package com.baosight.bin.test;

import com.baosight.bin.jpa.weather.ArrayOfString;
import com.baosight.bin.jpa.weather.WeatherWebService;
import com.baosight.bin.jpa.weather.WeatherWebServiceSoap;

public class TestWeather {
    public static void main(String[] args) {
        //也可以使用new WeatherWebService(url)此方法可重新设置请求的地址
        // URL url=new URL("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl")
        WeatherWebService factory = new WeatherWebService();
        //WeatherWebServiceSoap为调用的实现类
        WeatherWebServiceSoap weatherWebServiceSoap = factory.getWeatherWebServiceSoap();
        ArrayOfString strArray;
        strArray = weatherWebServiceSoap.getWeatherbyCityName("郑州");
        System.out.println(strArray.getString().get(10));
    }
}
