package com.danyanpi.service;

import com.danyanpi.bean.Goodcategory;
import com.danyanpi.bean.PageList;

import java.util.List;

public interface CategoryService {
    //查询所有分类
    List<Goodcategory> getAllGoodcategory();
    //分页查询分类
    PageList<Goodcategory> findAllGoodsByPageF(int pageNo, int pageSize);
    //更新一个分类
    int updateGoodcategory(Goodcategory goodcategory);
    //新增一个分类
    int InsertGoodcategory(Goodcategory goodcategory);
}
