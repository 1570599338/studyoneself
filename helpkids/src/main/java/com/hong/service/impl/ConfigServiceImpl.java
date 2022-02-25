package com.hong.service.impl;

import com.hong.common.UserConstants;
import com.hong.common.shiro.ShiroUtils;
import com.hong.common.text.Convert;
import com.hong.common.utils.StringUtils;
import com.hong.domain.Config;
import com.hong.mapper.ConfigMapper;
import com.hong.service.IConfigService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 参数配置表(Config)表服务实现类
 *
 * @author hong
 * @since 2022-02-08 23:56:39
 */
@Service
public class ConfigServiceImpl implements IConfigService {


    @Resource
    private ConfigMapper configMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Config queryById(Integer id) {
        return this.configMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param config      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Config> queryByPage(Config config, PageRequest pageRequest) {
        long total = this.configMapper.count(config);
        return new PageImpl<>(this.configMapper.queryAllByLimit(config, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config insert(Config config) {
        this.configMapper.insert(config);
        return config;
    }

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config insertSelective(Config config) {
        this.configMapper.insertSelective(config);
        return config;
    }


    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config update(Config config) {
        this.configMapper.update(config);
        return this.queryById(config.getId());
    }

    /**
     * 查询参数配置信息
     *
     * @param configId 参数配置ID
     * @return 参数配置信息
     */
    @Override
    public Config selectConfigById(Long configId) {
        Config config = new Config();
        config.setId(configId.intValue());
        return configMapper.selectConfig(config);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.configMapper.deleteById(id) > 0;
    }


    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数名称
     * @return 参数键值
     */
    @Override
    public String selectConfigByKey(String configKey) {
        Config config = new Config();
        config.setConfigKey(configKey);
        Config retConfig = configMapper.selectConfig(config);
        return retConfig != null ? retConfig.getConfigValue() : "";
    }

    /**
     * 查询参数配置列表
     *
     * @param config 参数配置信息
     * @return 参数配置集合
     */
    @Override
    public List<Config> selectConfigList(Config config) {
        return configMapper.selectConfigList(config);
    }


    /**
     * 新增参数配置
     *
     * @param config 参数配置信息
     * @return 结果
     */
    @Override
    public int insertConfig(Config config) {
        config.setCreateBy(ShiroUtils.getLoginName());
        config.setCreateTime(new Date());
        return configMapper.insertSelective(config);
    }


    /**
     * 修改参数配置
     *
     * @param config 参数配置信息
     * @return 结果
     */
    @Override
    public int updateConfig(Config config) {
        config.setUpdateBy(ShiroUtils.getLoginName());
        config.setUpdateTime(new Date());
        return configMapper.update(config);
    }

    /**
     * 批量删除参数配置对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteConfigByIds(String ids) {
        return configMapper.deleteConfigByIds(Convert.toStrArray(ids));
    }


    /**
     * 校验参数键名是否唯一
     *
     * @param config 参数配置信息
     * @return 结果
     */
    @Override
    public String checkConfigKeyUnique(Config config) {
        Long configId = StringUtils.isNull(config.getId()) ? -1L : config.getId();
        Config info = configMapper.checkConfigKeyUnique(config.getConfigKey());
        if (StringUtils.isNotNull(info) && info.getId().longValue() != configId.longValue()) {
            return UserConstants.CONFIG_KEY_NOT_UNIQUE;
        }
        return UserConstants.CONFIG_KEY_UNIQUE;
    }

}
