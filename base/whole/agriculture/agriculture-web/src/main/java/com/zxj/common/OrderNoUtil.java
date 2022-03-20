package com.zxj.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * @program: agriculture
 * @description: 生成订单号
 * @author: lquan
 * @create: 2022-03-19 22:01
 **/
public class OrderNoUtil {

   final static String AB= "abcdefghijklmnopqrstuvwxyz0123456789";
    /**
     * 针对微信支付生成商户订单号，为了避免微信商户订单号重复（下单单位支付），
     *
     * @return
     */
    public static String generateOrderSN() {
        StringBuffer orderSNBuffer = new StringBuffer();
        orderSNBuffer.append(System.currentTimeMillis());
        orderSNBuffer.append(getRandomString(7));
        return orderSNBuffer.toString();
    }

    /**
     * 获取随机字符串
     * @param len
     * @return
     */
    public static String getRandomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(new Random().nextInt(AB.length())));
        return sb.toString();
    }


    public static String getOrderNo() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());

        Random ne=new Random();//实例化一个random的对象ne
        int x = ne.nextInt(999-100+1)+100;//为变量赋随机值100-999
        String random_order = String.valueOf(x);
        String order_id = dateName+random_order;
        System.out.println(order_id);
        return order_id;
    }


}
