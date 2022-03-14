package com.zxj.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.zxj.config.AlipayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: agriculture
 * @description: 支付、捐款
 * @author: lquan
 * @create: 2022-03-14 21:34
 **/
@Controller
public class AlipayController {



    /**
     * 对应官方例子   alipay.trade.page.pay.jsp
     * notify_url 和 return_url 需要外网可以访问，建议natapp 内网穿透
     */
    //  @PostMapping(value = "/alipay/goAlipay")
    @GetMapping(value = "/alipay/goAlipay/{orderId}")
    @ResponseBody
    public String goAlipay(@PathVariable String orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {

        //public String goAlipay(String orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("orderId = " + orderId);
        System.out.println("-------------");

//        ProductOrder productOrder = productOrderService.getOrderById(orderId);
//        Integer productOrder_id = productOrder.getProductOrder_id();
//        ProductOrderItem productOrderItem = productOrderItemService.getProductOrderItemById(productOrder_id);
//        Short productOrderItem_number = productOrderItem_numberm.getProductOrderItem_number();
        Short productOrderItem_number =1;

                //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new Date().getTime()+"lquan";
        //付款金额，必填
        String total_amount = "66";
        //订单名称，必填
        String subject = "助农惠农";
        //商品描述，可空
        String body = "用户订购商品个数：" + productOrderItem_number;

        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "10m";

        //例子去官方api找
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"timeout_express\":\"" + timeout_express + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println("==="+result);
        return result;
    }



    /**
     * @Title: 对应官方例子return_url.jsp    return_url必须放在公网上  回跳页面
     */
    @RequestMapping("/alipay/alipayReturnNotice")
    @ResponseBody
    public String alipayReturnNotice(HttpServletRequest request, HttpServletRequest response, Map map) throws Exception {
        System.out.println("request = [ 回调函数]");

        return  "回调函数";

//        LOGGER.info("支付成功, 进入同步通知接口...");
//
//        //获取支付宝GET过来反馈信息
//        Map<String, String> params = new HashMap<String, String>();
//        Map<String, String[]> requestParams = request.getParameterMap();
//        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
//            String name = (String) iter.next();
//            String[] values = (String[]) requestParams.get(name);
//            String valueStr = "";
//            for (int i = 0; i < values.length; i++) {
//                valueStr = (i == values.length - 1) ? valueStr + values[i]
//                        : valueStr + values[i] + ",";
//            }
//            //乱码解决，这段代码在出现乱码时使用
//            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//            params.put(name, valueStr);
//        }
//
//        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
//
//        //——请在这里编写您的程序（以下代码仅作参考）——
//        if (signVerified) {
//            //商户订单号
//            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
//
//            //支付宝交易号
//            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
//
//            //付款金额
//            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
//
//            // 修改叮当状态，改为 支付成功，已付款; 同时新增支付流水  这里放在 异步 业务 处理
//        //            ordersService.updateOrderStatus(out_trade_no, trade_no, total_amount);
//
//            //页面展示
//            System.out.println("out_trade_no = " + out_trade_no);
//            ProductOrder productOrder = productOrderService.getOrderById(out_trade_no);
//            Integer productOrder_id = productOrder.getProductOrder_id();
//            System.out.println("productOrder_id = " + productOrder_id);
//            ProductOrderItem productOrderItem = productOrderItemService.getProductOrderItemById(productOrder_id);
//            System.out.println("productOrderItem = " + productOrderItem.toString());
//            //String product_name = productOrderItem.getProductOrderItem_product().getProduct_name();
//            //System.out.println("product_name = " + product_name);
//            String product_name = "便宜购商城商品";
//
//
//            LOGGER.info("********************** 支付成功(支付宝同步通知) **********************");
//            LOGGER.info("* 订单号: {}", out_trade_no);
//            LOGGER.info("* 支付宝交易号: {}", trade_no);
//            LOGGER.info("* 实付金额: {}", total_amount);
//            LOGGER.info("* 购买产品: {}", product_name);
//            LOGGER.info("***************************************************************");
//
//            map.put("out_trade_no", out_trade_no);
//            map.put("trade_no", trade_no);
//            map.put("total_amount", total_amount);
//            map.put("productName", product_name);
//
//            //根据订单号更新订单状态改为1提醒发货
//            productOrderService.updateByOrderCode(out_trade_no);
//
//        } else {
//            LOGGER.info("支付, 验签失败...");
//        }

        //前后分离形式  直接返回页面 记得加上注解@Response  http://login.calidray.com你要返回的网址，再页面初始化时候让前端调用你其他接口，返回信息
//        String result = "<form action=\"http://login.calidray.com/?#/index/depreciation-scrap/depreciation\"  method=\"get\" name=\"form1\">\n" +
//                "</form>\n" +
//                "<script>document.forms[0].submit();</script>";
//
//        return result;
        //前后不分离的形式，直接返回jsp页面
//        return "fore/alipaySuccess";
    }
}
