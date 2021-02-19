package com.smartshop.danyanpi.smartshop.activities.stock;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.smartshop.danyanpi.smartshop.R;
import com.smartshop.danyanpi.smartshop.activities.addgood.Addcategory;
import com.smartshop.danyanpi.smartshop.activities.addgood.Addgoods;
import com.smartshop.danyanpi.smartshop.activities.infomanage.Categorymanage;
import com.smartshop.danyanpi.smartshop.activities.infomanage.Goodsmanage;
import com.smartshop.danyanpi.smartshop.dao.CategoryDao;
import com.smartshop.danyanpi.smartshop.dao.GoodsDao;


public class StockActivity extends AppCompatActivity implements View.OnClickListener{
    private GoodsDao goodsDao;
    private CategoryDao categoryDao;
    private FloatingActionMenu menuRed;
    private ExpandableListView expandableListView;
    private FloatingActionButton fab1,fab2,fab3,fab4;
    private PopupWindow mPopupWindow;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab4 = (FloatingActionButton) findViewById(R.id.fab4);
        fab1.setOnClickListener(clickListener);
        fab2.setOnClickListener(clickListener);
        fab3.setOnClickListener(clickListener);
        fab4.setOnClickListener(clickListener);
        DBHelp db = new DBHelp(this);
        Cursor cursor = db.selectCategory();
        while(cursor.getCount()>0&&cursor.moveToNext()){
            System.out.println(cursor.getString(cursor.getColumnIndex("categoryname")));
        }
        expandableListView = findViewById(R.id.categorylist);
        final DBAdapter dbAdapter = new DBAdapter(cursor,this);
        expandableListView.setAdapter(dbAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(StockActivity.this,"这是"+i+" "+i1,Toast.LENGTH_LONG).show();
                Cursor cursor = dbAdapter.getChild(i, i1);
                while(cursor.getCount()>0&&cursor.moveToNext()){
                    cursor.getString(cursor.getColumnIndex("_id"));
                }
                System.out.println(dbAdapter.getChild(i, i1).getString(dbAdapter.getChild(i, i1).getColumnIndex("goodsname")));
                return false;
            }
        });

  }
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (v.getId()) {
                case R.id.fab1:
                    intent.setClass(StockActivity.this, Addgoods.class);
                    startActivity(intent);
                    break;
                case R.id.fab2:
                    intent.setClass(StockActivity.this, Addcategory.class);
                    startActivity(intent);
                    break;
                case R.id.fab3:
                    intent.setClass(StockActivity.this, Categorymanage.class);
                    startActivity(intent);
                    break;
                case R.id.fab4:
                    intent.setClass(StockActivity.this, Goodsmanage.class);
                    startActivity(intent);
                    break;
            }
        }
    };


    @Override
    public void onClick(View view) {

    }
}
