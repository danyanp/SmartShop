package com.danyanpi.dao;

import com.danyanpi.bean.OrderDetails;
import org.apache.ibatis.annotations.Insert;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface OrderdetailsMapper extends Mapper<OrderDetails> , InsertListMapper<OrderDetails> {
    @Insert("Insert smartshop.orderdetails(goodid,orderid,goodspecnum,goodspecprice,goodprice) VALUES (#{goodid},#{orderid},#{goodspecnum},#{goodid},#{v},#{goodprice})")
    int InsertOrderdetails(OrderDetails orderdetails);
}
