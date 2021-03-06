package com.zxj.shop.admin;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserData {
    public static void main(String[] args) {
        Connection connection =  getConn();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from t_scrm_user_import  LIMIT 1500,500");
           // preparedStatement.setString(1,"486");
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
                 ScrmUserInfoAddRequest scrmUserInfoAddRequest = new ScrmUserInfoAddRequest();
                 scrmUserInfoAddRequest.setArea("");
                 scrmUserInfoAddRequest.setCity("");
                 scrmUserInfoAddRequest.setUserAvatar("");
                 scrmUserInfoAddRequest.setUserSex(0);
                 //scrmUserInfoAddRequest.setUserBirthday("");
                 scrmUserInfoAddRequest.setSource(0);
                 scrmUserInfoAddRequest.setProvince("");
                 scrmUserInfoAddRequest.setCountry("");
                 scrmUserInfoAddRequest.setUserName(resultSet.getString("name"));
                 scrmUserInfoAddRequest.setUserMobile(resultSet.getString("mobile"));
                 scrmUserInfoAddRequest.setThirdUserId(resultSet.getString("third_user_id"));
                 doPostTestTwo(scrmUserInfoAddRequest);

                // connection.prepareStatement("update t_scrm_user_import")
             }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public static Connection getConn() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://172.28.25.49:3306/scrm_marketing_db?useUnicode=true&useSSL=false&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Focus@123");

        return dsc.getConn();
    }



    public static void doPostTestTwo(ScrmUserInfoAddRequest scrmUserInfoAddRequest ) {

        // ??????Http?????????(???????????????:???????????????????????????;??????:?????????HttpClient???????????????????????????)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // ??????Post??????
        HttpPost httpPost = new HttpPost("");

        // (????????????com.alibaba.fastjson.JSON???)
        String jsonString = JSON.toJSONString(scrmUserInfoAddRequest);

        StringEntity entity = new StringEntity(jsonString, "UTF-8");

        // post???????????????????????????????????????????????????;?????????entity??????post????????????
        httpPost.setEntity(entity);

        httpPost.setHeader("Content-Type", "application/json;charset=utf8");

        // ????????????
        CloseableHttpResponse response = null;
        try {
            // ??????????????????(??????)Post??????
            response = httpClient.execute(httpPost);
            // ????????????????????????????????????
            HttpEntity responseEntity = response.getEntity();

            if (responseEntity != null) {
                System.out.println("???????????????:" + EntityUtils.toString(responseEntity));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // ????????????
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
