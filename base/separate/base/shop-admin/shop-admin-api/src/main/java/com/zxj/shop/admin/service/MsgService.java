package com.zxj.shop.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxj.shop.admin.entity.MsgRecord;

public interface MsgService extends IService<MsgRecord> {

    IPage<MsgRecord> page(Page<MsgRecord> objectPage, MsgRecord msgRecord);
}
