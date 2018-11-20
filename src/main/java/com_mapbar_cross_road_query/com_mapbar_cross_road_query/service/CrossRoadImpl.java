package com_mapbar_cross_road_query.com_mapbar_cross_road_query.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.*;

public class CrossRoadImpl implements CrossRoad{

    @Override
    public JSONArray getDatadiffByRoadId(int roadOne, int roadTwo) {
        JSONArray jsonArray = null;
        try {
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
            String url = MyUtils.getProperties("URL");
            String sql = "select ROADIDONE, ROADIDTWO, DAYHOUR, \"ROADPRICE\".\"TIME\" as ROADPRICETIME from \"CROSSROADPRICE\" where ROADIDONE="+roadOne+"and ROADIDTWO="+roadTwo;

            Connection conn = DriverManager.getConnection(url);

            PreparedStatement pstm = conn.prepareStatement(sql);

            ResultSet resultSet = pstm.executeQuery();
            resultSet.last();
            int row = resultSet.getRow();
            jsonArray = new JSONArray();
            if (row>=0){
                resultSet.beforeFirst();
                while (resultSet.next()){
                    int roadIdOne = resultSet.getInt("ROADIDONE");
                    int roadIdTwo = resultSet.getInt("ROADIDTWO");
                    int date = resultSet.getInt("DAYHOUR");
                    double time = resultSet.getDouble("ROADPRICETIME");
                    String data = "";
                    JSONObject json= JSONObject.fromObject(data);
                    jsonArray.add(json);
                }
            }else{
                String data = "{\"status\":\"未查到\"}";
                JSONObject json= JSONObject.fromObject(data);
                jsonArray.add(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
