package com.edu.ahu.classroom.utils;

import com.edu.ahu.classroom.common.ResponsePojo;
import com.edu.ahu.classroom.exception.ApplicationException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * http 请求工具类(访问其他http协议接口)
 * Created by Administrator on 2017/3/21.
 */
public class HttpRequest {
    /**
     * 使用JSON格式Post数据 并接收Post响应
     * @param url               接口地址
     * @param body              JSON数据
     * @return                  回应数据
     */
    public static String httpPostJson(String url,String body){
        OutputStreamWriter  outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        StringBuilder result = new StringBuilder();
        try {
            //打开和URL之间的连接
            URLConnection urlConnection = new URL(url).openConnection();
            //设置连接通用属性
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("content-type","application/json");
            //发送数据写入缓存
            outputStreamWriter = new OutputStreamWriter(urlConnection.getOutputStream(),"UTF-8");
            outputStreamWriter.write(body);
            outputStreamWriter.flush();
            //接受响应读入数据
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                result.append(lines);
            }
            return result.toString();
        }catch (IOException e){
            e.printStackTrace();
            throw new ApplicationException("Http Post Json 异常");
        }finally {
            try {
                if (outputStreamWriter!=null) outputStreamWriter.close();
                if (bufferedReader!=null) bufferedReader.close();
            }catch (IOException e) {
                //警告
            }
        }
    }

    public static <T> ResponsePojo httpPostJsonThree(String ip,Integer port,String route,T body){
        String url = "http://"+ip+":"+port+"/"+route;
        Integer countPostTime = 0;
        do {
            try {
                String objectString = JSONObject.toJSONString(body);
                String result = httpPostJson(url,objectString);
                return JSON.parseObject(result,ResponsePojo.class);
            }catch (ApplicationException e){
                countPostTime++;
            }
        }while (countPostTime<3);
        return new ResponsePojo().failure("通信异常");
    }
}