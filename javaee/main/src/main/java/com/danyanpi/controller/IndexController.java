package com.danyanpi.controller;

import com.danyanpi.bean.BaseResponse;
import com.danyanpi.bean.Goods;
import com.danyanpi.service.serviceImpl.GoodsServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "主页管理相关接口")
@Controller
@ResponseBody
public class IndexController {
    @Autowired
    private GoodsServiceImpl goodsService;

    //    http://localhost:8081/api/order?pageNo=1&pageSize=10
    @RequestMapping(value = "/api/goods",method= {RequestMethod.POST})
    public BaseResponse<List<Goods>> getallGoods(){
        List<Goods> allGoods = goodsService.getAllGoods();
        return new BaseResponse<List<Goods>>(1, "获取数据成功", allGoods);
    }


//    @RequestMapping(value = "/api/goods")
//    public PageInfo<Goods> index(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
//        PageInfo<Goods> queryResult = goodsService.findAllGoodsByPageF(1, 5);
//        return queryResult;
// @RequestParam(value = "pageNo",defaultValue = "1") int pageNo, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize
//    }


}
