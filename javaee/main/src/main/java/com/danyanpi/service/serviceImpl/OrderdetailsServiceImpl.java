package com.danyanpi.service.serviceImpl;

import com.danyanpi.bean.OrderDetails;
import com.danyanpi.dao.OrderdetailsMapper;
import com.danyanpi.service.OrderdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderdetailsServiceImpl")
public class OrderdetailsServiceImpl implements OrderdetailsService {

    @Autowired
    private OrderdetailsMapper orderdetailsMapper;
    @Override
    public int InsertOrderdetails(List<OrderDetails> orderdetails) {
        return orderdetailsMapper.insertList(orderdetails);
    }
}
