package com.smartshop.danyanpi.smartshop.activities.infomanage;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.smartshop.danyanpi.smartshop.R;
import com.smartshop.danyanpi.smartshop.dao.CategoryDao;

public class Categorymanage extends AppCompatActivity{
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_manage);
        listView = findViewById(R.id.catelist);
        CategoryDao categoryDao = new CategoryDao(this);
        //listView.setAdapter();        GoodsDao goodsDao = new GoodsDao(this);
        Cursor cursor = categoryDao.quy();
        if(cursor!=null&&cursor.getCount()>=0){
            ListAdapter adapter = new SimpleCursorAdapter(Categorymanage.this,
                    R.layout.item_goods,cursor,new String[] {"_id","categoryname"},
                    new int[]{R.id.item_name,R.id.item_stock},
                    CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
            listView.setAdapter(adapter);
        }

    }
}
