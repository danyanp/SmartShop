package com.danyanpi.service.serviceImpl;

import com.danyanpi.bean.Order;
import com.danyanpi.dao.OrderMapper;
import com.danyanpi.service.OrderService;
import com.danyanpi.bean.PageList;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderServiceImpl")
public class OrderServiceImpl implements OrderService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getAllOrder() {
        List<Order> allOrder = orderMapper.getAllOrder();
        return allOrder;
    }

    @Override
    public PageList<Order> findAllOrderByPageF(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Order> lists = orderMapper.getAllOrder();
        PageList<Order> orderPageList = new PageList<>(lists);
        return orderPageList;
    }

    @Override
    public int insertOrder(Order order) {
        int insert = orderMapper.insertOrder(order);
        if(insert==0){
            return insert;
        }
        return order.getId();
    }
}
