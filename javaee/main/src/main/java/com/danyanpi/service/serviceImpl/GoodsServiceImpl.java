package com.danyanpi.service.serviceImpl;

import com.danyanpi.bean.Goods;
import com.danyanpi.bean.PageMap;
import com.danyanpi.dao.GoodsMapper;
import com.danyanpi.service.GoodsService;
import com.danyanpi.bean.PageList;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GoodsServiceImpl")
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int editGood(Goods goods) {
        return goodsMapper.updateGoodsById(goods);
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    @Override
    public PageList<Goods> findAllGoodsByPageF(PageMap params) {
        // TODO Auto-generated method stub
        if (params.getPageNo()<=0&&params.getPageSize()<=0){
            params.setPageNo(1);
            params.setPageSize(10);
        }
        PageHelper.startPage(params.getPageNo(), params.getPageSize());
        List<Goods> lists = goodsMapper.getAllGoods();
        PageList<Goods> orderPageList = new PageList<>(lists);
        return orderPageList;
    }

    @Override
    public int insertGoods(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }

    @Override
    public int deleteGoods(int id) {
        return goodsMapper.deleteGoods(id);
    }

}
