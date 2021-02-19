package com.smartshop.danyanpi.smartshop.activities.infomanage;


import android.accounts.Account;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.app.AlertDialog.Builder;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.smartshop.danyanpi.smartshop.R;
import com.smartshop.danyanpi.smartshop.bean.Goods;
import com.smartshop.danyanpi.smartshop.dao.GoodsDao;

import java.util.ArrayList;
import java.util.List;

public class Goodsmanage extends AppCompatActivity{
    private ListView listView;
    private MyAdapter adapter;
    private List<Goods> list;
    private GoodsDao goodsDao;
    private EditText findgood;
    private Button findbut;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_manage);
        list = new ArrayList<>();
        goodsDao = new GoodsDao(this);
        listView = findViewById(R.id.goodslist);
        findgood = findViewById(R.id.findgood);
        findbut = findViewById(R.id.findbut);


        findbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = goodsDao.quyGood(findgood.getText().toString());
                if(cursor!=null&&cursor.getCount()>=0){
                    while(cursor.moveToNext()){
                        //可以根据列名获取索引
                        int id=cursor.getInt(cursor.getColumnIndex("_id"));
                        String goodsname=cursor.getString(1);
                        int categoryid=cursor.getInt(2);
                        int bar=cursor.getInt(3);
                        int stock=cursor.getInt(4);
                        double purprice = cursor.getDouble(5);
                        double delprice =cursor.getDouble(6);
                        String remarks =cursor.getString(7);
                        Toast.makeText(Goodsmanage.this,"id为："+id,Toast.LENGTH_LONG).show();
                    }
                    cursor.close();
                }

            }
        });

        Cursor cursor = goodsDao.quy();
        if(cursor!=null&&cursor.getCount()>=0){
            while(cursor.moveToNext()){
                //可以根据列名获取索引
                int id=cursor.getInt(cursor.getColumnIndex("_id"));
                String goodsname=cursor.getString(1);
                int categoryid=cursor.getInt(2);
                int bar=cursor.getInt(3);
                int stock=cursor.getInt(4);
                double purprice = cursor.getDouble(5);
                double delprice =cursor.getDouble(6);
                String remarks =cursor.getString(7);
                list.add(new Goods(id,goodsname,categoryid,bar,stock,purprice,delprice,remarks));
            }
            cursor.close();
        }
        adapter = new MyAdapter();
        listView.setAdapter(adapter);// 给ListView添加适配器(自动把数据生成条目)
    }

    // 自定义一个适配器(把数据装到ListView的工具)
    private class MyAdapter extends BaseAdapter {
        public int getCount() {                   // 获取条目总数
            return list.size();
        }

        public Object getItem(int position) { // 根据位置获取对象
            return list.get(position);
        }

        public long getItemId(int position) { // 根据位置获取id
            return position;
        }

        // 获取一个条目视图
        public View getView(int position, View convertView, ViewGroup parent) {
            // 重用convertView
            View item = convertView != null ? convertView : View.inflate(
                    getApplicationContext(), R.layout.item_goods, null);
            // 获取该视图中的TextViewR.id.goodsid,R.id.goodsname,R.id.stock,R.id.purprice,R.id.delprice
            TextView goodsid = (TextView) item.findViewById(R.id.goodsid);
            TextView goodsname = (TextView) item.findViewById(R.id.goodsname);
            TextView stock = (TextView) item.findViewById(R.id.stock);
            TextView purprice = (TextView) item.findViewById(R.id.purprice);
            TextView delprice = (TextView) item.findViewById(R.id.delprice);
            // 根据当前位置获取Account对象
            final Goods goods = list.get(position);
            // 把Account对象中的数据放到TextView中
            goodsid.setText(goods.getGoodsid() + "");
            goodsname.setText(goods.getGoodsname());
            stock.setText(goods.getStock() + "");
            purprice.setText(goods.getPurprice() + "");
            delprice.setText(goods.getDelprice() + "");

            ImageView deleteIV = (ImageView) item.findViewById(R.id.deleteIV);

            //删除图片的点击事件触发的方法
            deleteIV.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //删除数据之前首先弹出一个对话框
                    android.content.DialogInterface.OnClickListener listener =
                            new android.content.DialogInterface.
                                    OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    list.remove(goods);          // 从集合中删除
                                    goodsDao.delete(goods.getGoodsid()); // 从数据库中删除
                                    notifyDataSetChanged();// 刷新界面
                                }
                            };
                    Builder builder = new Builder(Goodsmanage.this); // 创建对话框
                    builder.setTitle("确定要删除吗?");                    // 设置标题
                    // 设置确定按钮的文本以及监听器
                    builder.setPositiveButton("确定", listener);
                    builder.setNegativeButton("取消", null);         // 设置取消按钮
                    builder.show(); // 显示对话框
                }
            });
            return item;
        }
    }
    //ListView的Item点击事件
    private class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // 获取点击位置上的数据
            Goods a = (Goods) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), a.toString(),
                    Toast.LENGTH_SHORT).show();
        }
    }


}
