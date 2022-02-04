package com.zxj.shop.admin.controller;

import com.zxj.shop.admin.service.QCloudService;
import com.zxj.shop.admin.entity.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Api(tags = "文件上传")
@RestController
@RequestMapping("/api/entry/file")
public class FileApiController {

    @Autowired
    private QCloudService qCloudService;

    @ApiImplicitParam(name = "file",value = "文件",required = true)
    @ApiOperation(value = "上传文件并返回对应url")
    @PostMapping("/upload")
    public ResultVO upload(@RequestParam("file") MultipartFile file) {
        return ResultVO.success(qCloudService.upload(file),"上传完成");
    }

}
