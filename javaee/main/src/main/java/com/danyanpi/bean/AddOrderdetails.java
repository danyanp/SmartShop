package com.danyanpi.bean;

import lombok.Data;

import java.util.List;

@Data
public class AddOrderdetails {
    //总价
    private Double totalprice;
    //店面
    private Integer shopid;
    //订单时间
    private String time;
    private List<OrderDetails> orderdetails;
}
