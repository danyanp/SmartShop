package com.danyanpi.service;

import com.danyanpi.bean.Goods;
import com.danyanpi.bean.PageList;
import com.danyanpi.bean.PageMap;

import java.util.List;

public interface GoodsService {
    int editGood(Goods goods);
    List<Goods> getAllGoods();
    PageList<Goods> findAllGoodsByPageF(PageMap pageMap);
    int insertGoods(Goods goods);
    int deleteGoods(int id);
}
