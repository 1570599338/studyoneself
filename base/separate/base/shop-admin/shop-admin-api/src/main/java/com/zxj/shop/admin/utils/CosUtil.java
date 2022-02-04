package com.zxj.shop.admin.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Date;

@Component
public class CosUtil {

    @Value("${cos.accessKeyId}")
    private String accessKeyId;
    @Value("${cos.accessKeySecret}")
    private String accessKeySecret;
    @Value("${cos.bucketName}")
    private String bucketName;

    public void putObject(byte [] bytes, String fileName) {
        COSClient cosClient = null;
        try {
            COSCredentials cred = new BasicCOSCredentials(accessKeyId, accessKeySecret);
            Region region = new Region("ap-beijing");
            ClientConfig clientConfig = new ClientConfig(region);
            cosClient = new COSClient(cred, clientConfig);

            ObjectMetadata objectMetadata = new ObjectMetadata();
            cosClient.putObject(bucketName, fileName, new ByteArrayInputStream(bytes), objectMetadata);
        } finally {
            cosClient.shutdown();
        }
    }

    public String getObject(String fileName) {
        COSClient cosClient = null;
        try {
            COSCredentials cred = new BasicCOSCredentials(accessKeyId, accessKeySecret);
            Region region = new Region("ap-beijing");
            ClientConfig clientConfig = new ClientConfig(region);
            // 生成 cos 客户端。
            cosClient = new COSClient(cred, clientConfig);
            GeneratePresignedUrlRequest req =
                    new GeneratePresignedUrlRequest(bucketName, fileName, HttpMethodName.GET);
            // 设置签名过期时间(可选), 若未进行设置, 则默认使用 ClientConfig 中的签名过期时间(1小时)
            // 这里设置签名在半个小时后过期
            Date expirationDate = new Date(System.currentTimeMillis() + 30L * 60L * 1000L);
            req.setExpiration(expirationDate);
            URL url = cosClient.generatePresignedUrl(req);
            return url.toString();
        } finally {
            cosClient.shutdown();
        }
    }
}
