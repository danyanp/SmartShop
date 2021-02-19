package com.danyanpi.controller;

import com.danyanpi.bean.AddOrderdetails;
import com.danyanpi.bean.BaseResponse;
import com.danyanpi.bean.Order;
import com.danyanpi.bean.OrderDetails;
import com.danyanpi.service.OrderdetailsService;
import com.danyanpi.service.serviceImpl.OrderServiceImpl;
import com.danyanpi.bean.PageList;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

@Api(tags = "订单管理相关接口")
@Controller
@ResponseBody
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderdetailsService orderdetailsService;

    //新增订单
    @RequestMapping(value = "/api/order/addorder",method= {RequestMethod.POST})
    public BaseResponse<String> addOrder(@RequestBody AddOrderdetails addOrderdetails){
        Order order = new Order();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(date);
        order.setTime(dateStr);
        order.setTotalprice(addOrderdetails.getTotalprice());
        order.setShopid(1);
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String timeStr = df.format(time);
//        time = Timestamp.valueOf(timeStr);
//        System.out.println(time);//2017-05-06 15:54:21.0
        int i = orderService.insertOrder(order);
        List<OrderDetails> orderdetails = addOrderdetails.getOrderdetails();
        for (int j = 0; j < orderdetails.size(); j++) {
            orderdetails.get(j).setOrderid(i);
        }
        int a = orderdetailsService.InsertOrderdetails(orderdetails);
        if(a>0) a=1;
        Integer success[] = {0,1};
        String msg[] = {"新增订单失败","新增订单成功"};
        return new BaseResponse<String>((success[a]), msg[a],a+"");
    }
    //订单分页查询
    @RequestMapping(value = "/api/order/orderlist",method= {RequestMethod.POST})
    public PageList<Order> index(@RequestBody Map<String, String> params){
        System.out.println("pageNo:"+params.get("pageNo")+" pageSize:"+params.get("pageSize"));
        int pageNo = Integer.parseInt(params.get("pageNo"));
        int pageSize = Integer.parseInt(params.get("pageSize"));
        PageList<Order> queryResult = orderService.findAllOrderByPageF(pageNo,pageSize);
        return queryResult;
    }

}
