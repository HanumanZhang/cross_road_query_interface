package com_mapbar_cross_road_query.com_mapbar_cross_road_query.common;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class BaseAction {
    /**
     * 返回json字符串
     * @param response
     * @param strJson
     * @throws IOException
     */
    public void sendJson(HttpServletResponse response, String strJson) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        out.append(strJson);
        out.flush();
        out.close();
    }
    /**
     * 对象转json返回
     * @param response
     * @param resultBean
     * @throws IOException
     */
    public void sendJson(HttpServletResponse response, ResultBean resultBean) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        out.append(JSONObject.fromObject(resultBean).toString());
        out.flush();
        out.close();
    }

    /**
     * 传输二进制
     * @param response
     * @param bytes
     * @throws IOException
     */
    public void sendBytes(HttpServletResponse response,byte[] bytes) throws IOException{
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("pragma", "no-cache");
        response.setHeader("Content-Type","image/*");
        response.setHeader("Access-Control-Allow-Origin", "*");

        OutputStream out = response.getOutputStream();
        out.write(bytes);
        out.flush();
        out.close();
    }
}
