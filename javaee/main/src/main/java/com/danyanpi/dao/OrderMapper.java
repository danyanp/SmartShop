package com.danyanpi.dao;

import com.danyanpi.bean.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.*;


import javax.persistence.GeneratedValue;
import java.util.List;

public interface OrderMapper extends Mapper<Order>, IdsMapper<Order>, InsertListMapper<Order> {
    //获取全部的订单
    @Select("select * from smartshop.order")
    List<Order> getAllOrder();

    @Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
    @Insert("insert smartshop.order(time,totalprice,shopid) VALUES (#{time},#{totalprice},#{shopid})")
    int insertOrder(Order order);
}
