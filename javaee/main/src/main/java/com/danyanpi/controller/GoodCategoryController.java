package com.danyanpi.controller;

import com.danyanpi.bean.BaseResponse;
import com.danyanpi.bean.Goodcategory;
import com.danyanpi.bean.PageMap;
import com.danyanpi.service.serviceImpl.CategoryServiceImpl;
import com.danyanpi.bean.PageList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "GoodCategory相关接口")
@Controller
@ResponseBody
public class GoodCategoryController {

    private static Integer success[] = {0,1};

    @Autowired
    private CategoryServiceImpl categoryService;

    //所有商品分类
    @ApiOperation("所有商品分类")
    @RequestMapping(value = "/api/good/allcategory",method= {RequestMethod.GET})
    public BaseResponse<List<Goodcategory>> allCategory(){
        List<Goodcategory> allGoodcategory = categoryService.getAllGoodcategory();
        return new BaseResponse<>(1, "查询数据成功",allGoodcategory);
    }


    //商品分类查询
    @ApiOperation("商品分类查询")
    @PostMapping(value = "/api/good/categorylist")
    public PageList<Goodcategory> getCategoryList(@RequestBody PageMap pageMap){
        return categoryService.findAllGoodsByPageF(pageMap.getPageNo(),pageMap.getPageSize());
    }

    //商品分类修改
    @ApiOperation("商品分类修改")
    @RequestMapping(value = "/api/good/editcategory",method= {RequestMethod.POST})
    public BaseResponse<String> editCategory(@RequestBody Goodcategory goodcategory){
        int i = categoryService.updateGoodcategory(goodcategory);
        String msg[] = {"修改数据失败","修改数据成功"};
        return new BaseResponse<>((success[i]), msg[i],i+"");
    }

    //新增商品分类
    @ApiOperation("新增商品分类")
    @RequestMapping(value = "/api/good/addcategory",method= {RequestMethod.POST})
    public BaseResponse<String> addCategory(@RequestBody Goodcategory goodcategory){
        int i = categoryService.InsertGoodcategory(goodcategory);
        String msg[] = {"新增商品分类失败","新增商品分类成功"};
        return new BaseResponse<>((success[i]), msg[i],i+"");
    }
}
