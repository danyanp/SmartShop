package com.danyanpi.controller;

import com.danyanpi.bean.BaseResponse;
import com.danyanpi.bean.Goods;
import com.danyanpi.bean.PageMap;
import com.danyanpi.service.serviceImpl.GoodsServiceImpl;
import com.danyanpi.bean.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "Goods相关接口")
@Controller
@ResponseBody
public class GoodsController {
    private static Integer success[] = {0,1};

    @Autowired
    private GoodsServiceImpl goodsService;


    //所有商品
    @ApiOperation("获取所有商品")
    @GetMapping(value = "/api/good/allgoods")
    public BaseResponse<List<Goods>> allgoods(){
        List<Goods> allGoodcategory = goodsService.getAllGoods();
        return new BaseResponse<>(1, "查询数据成功",allGoodcategory);
    }
    //商品修改
    @ApiOperation("商品修改")
    @RequestMapping(value = "/api/good/editgood",method= {RequestMethod.POST} )
    public BaseResponse<String> editgood(@RequestBody Goods goods){
        int i = goodsService.editGood(goods);
        String msg[] = {"修改数据失败","修改数据成功"};
        return new BaseResponse<>(success[i], msg[i],i+"");

    }
    //商品分页查询
    @ApiOperation("商品分页查询")
    @RequestMapping(value = "/api/good/goodlist",method= {RequestMethod.POST})
    public PageList<Goods> getGoodlist(@RequestBody PageMap params){
        return goodsService.findAllGoodsByPageF(params);
    }
    //新增商品
    @ApiOperation("新增商品")
    @PostMapping(value = "/api/good/addgood")
    public BaseResponse<String> addGood(@RequestBody Goods goods){
        int i = goodsService.insertGoods(goods);
        String msg[] = {"新增商品失败","新增商品成功"};
        return new BaseResponse<>(success[i], msg[i],i+"");
    }
    //删除商品
    @ApiOperation("删除商品")
    @RequestMapping(value = "/api/good/delgood",method= {RequestMethod.POST})
    public BaseResponse<String> delgood(@RequestBody Goods goods){
        int i = goodsService.deleteGoods(Math.toIntExact(goods.getId()));
        String msg[] = {"删除商品失败","删除商品成功"};
        return new BaseResponse<>((success[i]), msg[i],i+"");
    }
    //查询商品
    @ApiOperation("查询商品")
    @RequestMapping(value = "/api/good/findgood",method= {RequestMethod.POST})
    public BaseResponse<List<Goods>> findgood(){
        List<Goods> allGoodcategory = goodsService.getAllGoods();
        return new BaseResponse<>(1, "查询数据成功",allGoodcategory);
    }

}
