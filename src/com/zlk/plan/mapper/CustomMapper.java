package com.zlk.plan.mapper;

import com.zlk.plan.entity.Custom;
import com.zlk.plan.entity.Pagination;

import java.util.List;

/**
 * @ClassName： CustomMapper
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/17 13:58
 */

public interface CustomMapper {
    /**
     * 查询客户
     */

    List<Custom> findUserList(Pagination pagination);

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
