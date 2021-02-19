package com.smartshop.danyanpi.smartshop.activities.addgood;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smartshop.danyanpi.smartshop.R;
import com.smartshop.danyanpi.smartshop.dao.CategoryDao;
import com.smartshop.danyanpi.smartshop.dao.GoodsDao;

public class Addcategory extends AppCompatActivity {
    private Button btnadd;
    private EditText goodname;
    private CategoryDao categoryDao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_category);
        btnadd = findViewById(R.id.addcategory);
        goodname = findViewById(R.id.goodname);
        categoryDao = new CategoryDao(this);
        btnadd.setOnClickListener(listener);
    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.addcategory:
                    add();
                    break;
                default:
                    break;
            }
        }
    };
    void sqliteToast(String str){
        Toast.makeText(Addcategory.this,str,Toast.LENGTH_LONG).show();
    }
    void add(){
        if(-1==categoryDao.add(goodname.getText().toString())){
            sqliteToast("添加失败！！！");
            return;
        }
        sqliteToast("添加成功！！！");
    }
}
