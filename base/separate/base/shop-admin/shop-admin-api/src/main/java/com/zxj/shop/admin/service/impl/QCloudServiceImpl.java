package com.zxj.shop.admin.service.impl;

import cn.hutool.core.date.DateUtil;
import com.zxj.shop.admin.service.QCloudService;
import com.zxj.shop.admin.utils.CosUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class QCloudServiceImpl implements QCloudService {

    private final CosUtil cosUtil;

    public List<String> upload(MultipartFile file) {
        List<String> urls = new ArrayList<>();
        if (file != null) {
            try {
                String format = DateUtil.format(new Date(), "yyyyMMddHHmmss");
                // 获取源文件名称
                String originalFilename = file.getOriginalFilename();

                String fileType = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
                String fileName = "/user/" + format + "." + fileType;

                //cos已不使用
                //cosUtil.putObject(file.getBytes(), fileName);
                urls.add(fileName);

                File fileDest = new File("/usr/local/nginx/image_upload/" + fileName);

                // 判断文件父目录是否存在
                if (!fileDest.getParentFile().exists()) {
                    fileDest.getParentFile().mkdir();
                }
                file.transferTo(fileDest);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return urls;
    }
}
