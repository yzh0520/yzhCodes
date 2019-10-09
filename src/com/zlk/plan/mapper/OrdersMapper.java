package com.zlk.plan.mapper;

import com.zlk.plan.entity.Orders;
import com.zlk.plan.entity.Pagination;

import java.util.List;

public interface OrdersMapper {
    /**
     * 查询客户
     */

    List<Orders> findOrdersList(Pagination pagination);

    /**
     * @param pagination
     */
    Integer findOrdersCount(Pagination pagination);
    /**
     * 通过ID删除订单
     */
    Integer deleteOrdersById(Integer oid);
    /**
     * 新增订单
     */
    Integer addOrders(Orders orders);
    /**
     * 修改订单
     */
    Integer editOrdersById(Orders orders);
}
