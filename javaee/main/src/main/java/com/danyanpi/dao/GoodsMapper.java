package com.danyanpi.dao;

import com.danyanpi.bean.Goods;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface GoodsMapper extends Mapper<Goods>{
    //获取全部的用户
    @Select("select * from smartshop.goods")
    List<Goods> getAllGoods();

    @Update("update smartshop.goods set name = (#{name}),categoryid = (#{categoryid}),bar=(#{bar}),delprice=(#{delprice}),content=(#{content}),stock=(#{stock}),isdelete=(#{isdelete}) where id = (#{id})")
    int updateGoodsById(Goods goods);

    @Insert("insert smartshop.goods(name,categoryid,bar,delprice,content,stock,isdelete,tradeprice,goodunit) VALUES (#{name},#{categoryid},#{bar},#{delprice},#{content},#{stock},#{isdelete},#{tradeprice},#{goodunit})")
    int insertGoods(Goods goods);

    @Delete("delete from smartshop.goods where id = (#{id})")
    int deleteGoods(@Param("id") int id);
}
