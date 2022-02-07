package com.zxj.shop.admin;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zxj.shop.admin.entity.Product;
import com.zxj.shop.admin.entity.ProductImage;
import com.zxj.shop.admin.mapper.ProductCateMapper;
import com.zxj.shop.admin.mapper.ProductImageMapper;
import com.zxj.shop.admin.mapper.ProductMapper;
import com.zxj.shop.admin.utils.HttpUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class ProductDesc {


    @Autowired
    ProductCateMapper productCateMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductImageMapper productImageMapper;

    @Test
    void contextLoads() {
        List<File> files = getFileList("E:\\shop-admin\\src\\test\\java\\json6");
        files.stream().forEach((e) -> {
            try {
                InputStream inputStream = new FileInputStream(e);
                String text = IOUtils.toString(inputStream, "utf8");
                JSONObject result = JSON.parseObject(text);
                JSONObject searchResultVOList = result.getJSONObject("result");
                QueryWrapper wrapper = new QueryWrapper();
                wrapper.eq("sku", e.getName().substring(0, e.getName().lastIndexOf(".")));
                List<Product> products = productMapper.selectList(wrapper);
                for (Product p : products) {
                    if(StringUtils.isNotEmpty(searchResultVOList.getString("adword"))) {
                        p.setTitle(searchResultVOList.getString("adword"));
                    }
                    if(null != searchResultVOList.getJSONObject("detailInfo") && StringUtils.isNotEmpty(searchResultVOList.getJSONObject("detailInfo").getString("h5HtmlText"))) {
                        String description = searchResultVOList.getJSONObject("detailInfo").getString("h5HtmlText");
                        p.setDescription(getIMG(description));
                    }
                    p.setCreateTime(new Date());
                    productMapper.updateById(p);

                    for (int i = 0; i < searchResultVOList.getJSONArray("image").size(); i++) {

                        JSONObject jsonObject = (JSONObject) searchResultVOList.getJSONArray("image").get(i);

                        String uuid = UUID.randomUUID().toString();
                        if(null !=jsonObject) {
                            HttpUtils.download(jsonObject.getString("big"), uuid);

                            ProductImage productImage = new ProductImage();
                            productImage.setProductId(p.getId());
                            productImage.setImage("/images/" + uuid + ".jpg");
                            productImageMapper.insert(productImage);
                        }
                    }
                }
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
    private  String getIMG(String detail) {
        String regex = "src=\"(.*?)\"";;
        List<String> list = new ArrayList<>();

        Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
        Matcher ma = pa.matcher(detail);
        while (ma.find())
        {
            String src = ma.group();
            String regex1 = "https(.*?)(.jpg|.png|.jpeg)";
            Pattern pa1 = Pattern.compile(regex1, Pattern.DOTALL);
            Matcher ma1 = pa1.matcher(src);
            while (ma1.find())
            {
                list.add(ma1.group());
            }
        }
        return list.get(0);
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
