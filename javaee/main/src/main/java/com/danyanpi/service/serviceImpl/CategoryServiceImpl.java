package com.danyanpi.service.serviceImpl;

import com.danyanpi.bean.Goodcategory;
import com.danyanpi.dao.CategoryMapper;
import com.danyanpi.service.CategoryService;
import com.danyanpi.bean.PageList;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Goodcategory> getAllGoodcategory() {
        return categoryMapper.getAllGoodcategory();
    }

    @Override
    public PageList<Goodcategory> findAllGoodsByPageF(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Goodcategory> lists = categoryMapper.getAllGoodcategory();
        PageList<Goodcategory> orderPageList = new PageList<>(lists);
        return orderPageList;
    }

    @Override
    public int updateGoodcategory(Goodcategory goodcategory) {
        return categoryMapper.updateById(goodcategory);
    }

    @Override
    public int InsertGoodcategory(Goodcategory goodcategory) {
        return categoryMapper.insertCategory(goodcategory);
    }
}
