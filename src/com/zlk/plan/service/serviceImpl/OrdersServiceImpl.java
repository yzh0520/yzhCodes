package com.zlk.plan.service.serviceImpl;

import com.zlk.plan.entity.Orders;
import com.zlk.plan.entity.Pagination;
import com.zlk.plan.mapper.OrdersMapper;
import com.zlk.plan.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName： OrdersServiceImpl
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/19 16:29
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Override
    public List<Orders> findOrdersList(Pagination pagination) {
        Integer page = pagination.getPage();
        Integer limit = pagination.getLimit();
        Integer startPage = (page-1)*limit;
        pagination.setStartPage(startPage);
        return ordersMapper.findOrdersList(pagination);
    }
    @Override
    public Integer findOrdersCount(Pagination pagination) {
        return ordersMapper.findOrdersCount(pagination);
    }
    @Override
    public Integer deleteOrdersById(Integer oid){

        return ordersMapper.deleteOrdersById(oid);
    }
    @Override
    public Integer addOrders(Orders orders){
        return ordersMapper.addOrders(orders);
    }
    @Override
    public Integer editOrdersById(Orders orders){
        return ordersMapper.editOrdersById(orders);
    }
}
