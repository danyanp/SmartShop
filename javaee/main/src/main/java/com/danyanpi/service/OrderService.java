package com.danyanpi.service;

import com.danyanpi.bean.Order;
import com.danyanpi.bean.PageList;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder();
    PageList<Order> findAllOrderByPageF(int pageNo, int pageSize);
    int insertOrder(Order order);
}