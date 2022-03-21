package com.zxj.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.zxj.common.OrderNoUtil;
import com.zxj.config.AlipayConfig;
import com.zxj.domain.Donate;
import com.zxj.service.IDonateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @program: agriculture
 * @description: 支付、捐款
 * @author: zxj
 * @create: 2022-03-14 21:34
 **/
@Slf4j
@Controller
public class AlipayController {
    @Autowired
    private IDonateService donateService;


    /**
     * 对应官方例子   alipay.trade.page.pay.jsp
     * notify_url 和 return_url 需要外网可以访问，建议natapp 内网穿透
     */
    //  @PostMapping(value = "/alipay/goAlipay")
  //  @PostMapping(value = "/alipay/goAlipay")
    @RequestMapping(value = "/alipay/goAlipay")
    @ResponseBody
    public String goAlipay(Donate donate, HttpServletRequest request, HttpServletResponse response) throws Exception {

        //public String goAlipay(String orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("donate = " + donate.toString());
        System.out.println("-------------");

        if(donate==null || donate.getType()==1 || donate.getPayAmount()==null){
            donateService.insertDonate(donate);
            String result = "<form name='punchout_form' method='post' action='/alipay/alipayReturnNoticeoff'>" +
                    "<input type='submit' value='立即支付' style='display:none' >" +
                    "</form>" +
                    "<script>document.forms[0].submit();</script>";
            return result;

        }



        Short productOrderItem_number =1;

                //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
//        String out_trade_no = UUID.randomUUID().toString();;
        String out_trade_no = OrderNoUtil.getOrderNo();
        donate.setOrderNo(out_trade_no);
        //付款金额，必填
        String total_amount =donate.getPayAmount();
        //订单名称，必填
        String subject = "助农惠农";
        //商品描述，可空
        String body = "用户订购商品个数：" + productOrderItem_number;

        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "10m";
        donateService.insertDonate(donate);
        //例子去官方api找
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"timeout_express\":\"" + timeout_express + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
log.info("********************",alipayRequest.getBizContent());
        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        System.out.println("==="+result);
        return result;
    }



    /**
     * @Title: 对应官方例子return_url.jsp    return_url必须放在公网上  回跳页面
     */
    @RequestMapping("/alipay/alipayReturnNotice")
    public String alipayReturnNotice(HttpServletRequest request, HttpServletRequest response, Map map, Model model) throws Exception {
        System.out.println("******************************************************request = [ 回调函数]");

      //  return  "回调函数";

        log.info("支付成功, 进入同步通知接口...");

        //获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            // 修改叮当状态，改为 支付成功，已付款; 同时新增支付流水  这里放在 异步 业务 处理
            Donate donate = new Donate();
            donate.setOrderNo(out_trade_no);
            List<Donate> list = donateService.selectDonateList(donate);


            Donate donateupdate = list.get(0);
            donateupdate.setTradeNo(trade_no);
            donateService.updateDonate(donateupdate);
            //页面展示
            String product_name = "扶助惠农";


            log.info("********************** 支付成功(支付宝同步通知) **********************");
            log.info("* 订单号: {}", out_trade_no);
            log.info("* 支付宝交易号: {}", trade_no);
            log.info("* 实付金额: {}", total_amount);
            log.info("* 购买产品: {}", product_name);
            log.info("***************************************************************");

            map.put("out_trade_no", out_trade_no);
            map.put("trade_no", trade_no);
            map.put("total_amount", total_amount);
            map.put("productName", product_name);

            //根据订单号更新订单状态改为1提醒发货
//            productOrderService.updateByOrderCode(out_trade_no);
            model.addAttribute("total_amount", total_amount);
        } else {
            log.info("支付, 验签失败...");
        }

        //前后分离形式  直接返回页面 记得加上注解@Response  http://login.calidray.com你要返回的网址，再页面初始化时候让前端调用你其他接口，返回信息
//        String result = "<form action=\"http://login.calidray.com/?#/index/depreciation-scrap/depreciation\"  method=\"get\" name=\"form1\">\n" +
//                "</form>\n" +
//                "<script>document.forms[0].submit();</script>";
//
//        return result;
        //前后不分离的形式，直接返回jsp页面
        return "reception/alipaySuccess";
    }



    @RequestMapping("/alipay/alipayReturnNoticeoff")
    public String alipayReturnNoticeoff(HttpServletRequest request, HttpServletRequest response, Map map, Model model) throws Exception {
        System.out.println("******************************************************request = [ 回调函数]");

       model.addAttribute("total_amount", null);
        //前后不分离的形式，直接返回jsp页面
        return "reception/alipaySuccess";
    }
}
