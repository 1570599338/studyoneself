package com.lquan.mapper;

import com.lquan.domain.Menu;
import java.util.List;

/**
 * menuMapper接口
 * 
 * @author lquan
 * @date 2022-01-25 18:19:09
 */
public interface MenuMapper{
    /**
     * 查询Menu
     * 
     * @param id
     * @return menu
     */
    public Menu selectMenuById(Long id);

    /**
     * 查询Menu列表
     * 
     * @param menu
     * @return menu集合
     */
    public List<Menu> selectMenuList(Menu menu);

    /**
     * 新增Menu
     * 
     * @param menu
     * @return 结果
     */
    public int insertMenu(Menu menu);

    /**
     * 修改Menu
     * 
     * @param menu
     * @return 结果
     */
    public int updateMenu(Menu menu);

    /**
     * 删除Menu
     * 
     * @param id
     * @return 结果
     */
    public int deleteMenuById(Long id);

    /**
     * 批量删除Menu
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMenuByIds(String[] ids);
}

