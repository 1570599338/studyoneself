package com.zxj.shop.admin;

import com.alibaba.fastjson.JSONObject;
import com.zxj.shop.admin.utils.HttpUtils;
import com.zxj.shop.admin.utils.ObjectUtil;
import com.zxj.shop.admin.entity.ProductCate;
import com.zxj.shop.admin.mapper.ProductCateMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductCateTests {

    @Autowired
    ProductCateMapper productCateMapper;

    @Test
    void contextLoads() {
        productCate();
    }

    private void productCate() {
        JSONObject obj = HttpUtils.requestGet("https://daojia.jd.com/client?_jdrandom=1610680092663&platCode=H5&appName=paidaojia&channel=&appVersion=8.5.5&jdDevice=&functionId=store%2FstoreDetailV220&body=%7B%22refPageSource%22:%22%22,%22storeId%22:%2211824815%22,%22skuId%22:%22%22,%22activityId%22:%22%22,%22promotionType%22:%22%22,%22longitude%22:116.44319,%22latitude%22:39.921425,%22missionId%22:%22%22,%22sourcePage%22:%22%22,%22keyWord%22:%22%22,%22source%22:%22%22,%22cateName%22:%22%22,%22channelId%22:%224058%22,%22channelBusiness%22:%2211%22,%22pageSource%22:%22store%22,%22ref%22:%22%22,%22ctp%22:%22storeinfo%22%7D&lng=116.44319&lat=39.921425&city_id=1&poi=%E5%8C%97%E4%BA%AC%E5%B8%82&jda=122270672.16091342801321327670035.1609134280.1609134285.1610678414.3&traceId=H5_DEV_98C23223-FE32-4A3B-A3A7-0BBB45D0D37B1610680092662&deviceId=H5_DEV_98C23223-FE32-4A3B-A3A7-0BBB45D0D37B&globalPlat=2&signKeyV1=d6926943d035a483b69de27b5c7345ee74ea93b8e47b141a031970d4541bbf3b");
        obj.getJSONObject("result").getJSONArray("cateList").stream().forEach((e)->{
            JSONObject m = (JSONObject) e;
            productCateMapper.insert(ObjectUtil.initObject(new ProductCate())
                    .init(v -> v.setCatName(m.getString("title")))
                    .init(v -> v.setSort(m.getInteger("sort")))
                    .getObject());
        });
    }


}
