package com.zlk.plan.service;


import com.zlk.plan.entity.Custom;
import com.zlk.plan.entity.Pagination;

import java.util.List;

public interface CustomService{
    /**
     * 查询所有客户
     */
    List<Custom> findUserLimit(Pagination pagination);

    /**
     * @param pagination
     * @return
     */
    Integer findUserCount(Pagination pagination);
    /**
     * 通过ID删除用户
     */
    Integer deleteUserById(Integer cid);
    /**
     * 新增客户
     */
    Integer addCustom(Custom custom);
    /**
     * 客户信息修改
     */
    Integer editCustomById(Custom custom);
}