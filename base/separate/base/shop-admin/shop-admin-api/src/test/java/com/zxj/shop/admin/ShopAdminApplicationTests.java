package com.zxj.shop.admin;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxj.shop.admin.utils.HttpUtils;
import com.zxj.shop.admin.utils.ObjectUtil;
import com.zxj.shop.admin.entity.Product;
import com.zxj.shop.admin.entity.ProductCate;
import com.zxj.shop.admin.mapper.ProductCateMapper;
import com.zxj.shop.admin.mapper.ProductMapper;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ShopAdminApplicationTests {

    Logger logger = LoggerFactory.getLogger(ShopAdminApplicationTests.class);

    @Autowired
    ProductCateMapper productCateMapper;
    @Autowired
    ProductMapper productMapper;

    @Test
    void contextLoads() {
        List<File> files = getFileList("E:\\shop-admin\\src\\test\\java\\com\\zxj\\shop\\admin");
        files.stream().forEach((e) ->{
            InputStream inputStream = null;
            try {
                inputStream = new FileInputStream(e);
                String text = IOUtils.toString(inputStream,"utf8");
                JSONObject result = JSON.parseObject(text);
                JSONObject searchResultVOList = result.getJSONObject("result");
                QueryWrapper wrapper = new QueryWrapper();
                wrapper.eq("cat_name", e.getName().substring(0,e.getName().lastIndexOf(".")));
                ProductCate productCate = productCateMapper.selectOne(wrapper);
                ((JSONObject)searchResultVOList.getJSONArray("searchCatResultVOList").get(0))
                        .getJSONArray("searchResultVOList").forEach((v) ->{
                    JSONObject prod = (JSONObject) v;

                    if(productCate !=null) {
                        try {
                            String uuid = UUID.randomUUID().toString();
                            HttpUtils.download(prod.getString("imgUrl"),uuid);

                            JSONObject skuPrice = prod.getJSONObject("skuPrice");

                            Double realTimePrice = null;
                            if(null != skuPrice.getDouble("realTimePrice")) {
                                realTimePrice = skuPrice.getDouble("realTimePrice");
                            }
                            Double basicPrice = null;
                            if(null != skuPrice.getDouble("basicPrice")) {
                                basicPrice = skuPrice.getDouble("basicPrice");
                            }
                            Double finalRealTimePrice = realTimePrice;
                            Double finalBasicPrice = basicPrice;
                            productMapper.insert(ObjectUtil.initObject(new Product())
                                    .init(p -> p.setProductCateId(productCate.getId()))
                                    .init(p -> p.setProductName(prod.getString("skuName")))
                                    .init(p -> p.setImgUrl("/" + uuid + ".jpg"))
                                    .init(p -> p.setSales(prod.getInteger("monthSales")))
                                    .init(p -> p.setStock(prod.getInteger("stockCount")))
                                    .init(p -> p.setSku(prod.getString("skuId")))
                                    .init(p -> p.setMallMobilePrice(finalRealTimePrice))
                                    .init(p -> p.setOriginalPrice(finalBasicPrice))
                                    .getObject());
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }

                    }
                });
            } catch (FileNotFoundException fileNotFoundException) {
                logger.error(fileNotFoundException.getMessage());
            } catch (IOException ioException) {
                logger.error(ioException.getMessage());
            } finally {
                    if(inputStream !=null) {
                        try {
                            inputStream.close();
                        } catch (IOException ioException) {
                            logger.error(ioException.getMessage());
                        }
                    }
            }
        });
    }

    public List<File> getFileList(String strPath) {
        List<File> filelist = new ArrayList<>();
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) {
                    getFileList(files[i].getAbsolutePath()); //遍历子文件夹里面的东西
                } else if (fileName.endsWith(".json")) { // 以***结尾的文件
                    String strFileName = files[i].getAbsolutePath();
                    filelist.add(files[i]);
                }
            }
        }
        return filelist;
    }

}
