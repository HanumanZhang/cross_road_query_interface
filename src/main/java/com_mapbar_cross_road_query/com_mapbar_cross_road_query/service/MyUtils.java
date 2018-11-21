package com_mapbar_cross_road_query.com_mapbar_cross_road_query.service;

import java.io.FileReader;
import java.util.Properties;

public class MyUtils {
    public static String getProperties(String str){
        Properties prop = null;
        try {
            prop = new Properties();

            FileReader fr = new FileReader("/data/road_interface_conf/cross_road_price_conf/application.properties");
            prop.load(fr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(str);
    }
}
