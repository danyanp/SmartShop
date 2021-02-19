package com.danyanpi.dao;

import com.danyanpi.bean.Goodcategory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Goodcategory> {
    //获取全部的用户
    @Select("select * from smartshop.goodcategory")
    List<Goodcategory> getAllGoodcategory();

    @Update("update smartshop.goodcategory set name = (#{name}),parentid = (#{parentid}) where id = (#{id})")
    int updateById(Goodcategory goodcategory);

    @Insert("INSERT smartshop.goodcategory(name,parentid) VALUES (#{name},#{parentid})")
    int insertCategory(Goodcategory goodcategory);

}
