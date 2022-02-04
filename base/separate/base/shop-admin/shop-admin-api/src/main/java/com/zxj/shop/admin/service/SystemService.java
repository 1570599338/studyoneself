package com.zxj.shop.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxj.shop.admin.entity.dto.Init;
import com.zxj.shop.admin.entity.SysLog;

public interface SystemService extends IService<SysLog> {

    IPage<SysLog> page(Page<SysLog> objectPage);

    public Init init(String token);
}
