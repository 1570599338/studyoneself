package com.zxj.shop.admin.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxj.shop.admin.entity.MsgRecord;
import com.zxj.shop.admin.mapper.MsgMapper;
import com.zxj.shop.admin.service.MsgService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DS("master_2")
@Service
public class MsgServiceImpl extends ServiceImpl<MsgMapper, MsgRecord> implements MsgService {

    @Autowired
    MsgMapper msgMapper;

    @Override
    public IPage<MsgRecord> page(Page<MsgRecord> objectPage, MsgRecord msgRecord) {
        QueryWrapper<MsgRecord> queryWrapper  = new QueryWrapper<MsgRecord>();
        if(StringUtils.isNotBlank(msgRecord.getContent())) {
            queryWrapper.and(wrapper-> wrapper.like("content",msgRecord.getContent()).or().like("mobile",msgRecord.getContent()));
        }
        return msgMapper.selectPage(objectPage,queryWrapper);
    }
}
