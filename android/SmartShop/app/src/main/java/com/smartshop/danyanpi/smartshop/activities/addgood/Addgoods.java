package com.smartshop.danyanpi.smartshop.activities.addgood;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.smartshop.danyanpi.smartshop.R;
import com.smartshop.danyanpi.smartshop.dao.CategoryDao;
import com.smartshop.danyanpi.smartshop.dao.GoodsDao;

import java.util.ArrayList;
import java.util.List;


public class Addgoods extends AppCompatActivity {
    private Button btnadd;
    private EditText goodname,category,bar,stock,purprice,delprice,remarks;
    private GoodsDao goodsDao;
    private Spinner catespinner;
    private Integer spinnercategory=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_goods);
        btnadd = findViewById(R.id.addbutton);
        goodname = findViewById(R.id.goodname);
//        category = findViewById(R.id.category);

        bar = findViewById(R.id.bar);
        stock = findViewById(R.id.stock);
        purprice = findViewById(R.id.purprice);
        delprice = findViewById(R.id.delprice);
        remarks = findViewById(R.id.remarks);
        goodsDao = new GoodsDao(this);
        btnadd.setOnClickListener(listener);

        CategoryDao categoryDao = new CategoryDao(this);
        Cursor cursor = categoryDao.quy();
        List<String> arrayStrings = new ArrayList<>();
        while(cursor.getCount()>0&&cursor.moveToNext()){
            arrayStrings.add(cursor.getString(cursor.getColumnIndex("categoryname")));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,arrayStrings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        catespinner = findViewById(R.id.catespinner);
        catespinner.setAdapter(adapter);
        //添加事件Spinner事件监听
        catespinner.setOnItemSelectedListener(new SpinnerSelectedListener());

    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.addbutton:
                    add();
                    break;
                default:
                    break;
            }
        }
    };
    void sqliteToast(String str){
        Toast.makeText(Addgoods.this,str,Toast.LENGTH_LONG).show();
    }
    void add(){
        if(-1==goodsDao.add(goodname.getText().toString(),spinnercategory+1,Integer.parseInt(bar.getText().toString()),Integer.parseInt(stock.getText().toString()),Double.parseDouble(purprice.getText().toString()),Double.parseDouble(delprice.getText().toString()),remarks.getText().toString())){
            sqliteToast("添加失败！！！");
            return;
        }
        sqliteToast("添加成功！！！");
    }

    private class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            spinnercategory = i;
            Toast.makeText(Addgoods.this,"你选择了"+i, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}
