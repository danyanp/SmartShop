package com.smartshop.danyanpi.smartshop.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.smartshop.danyanpi.smartshop.db.DatabaseHelper;

public class GoodsDao {
    private SQLiteDatabase db;
    public GoodsDao(Context context){
        super();
        db = new DatabaseHelper(context).getWritableDatabase();
    }
    //add
    public long add(String goodsname, int categoryid, int bar, int stock, double purprice, double delprice, String remarks){
        ContentValues values = new ContentValues();
        values.put("goodsname",goodsname);
        values.put("categoryid",categoryid);
        values.put("bar",bar);
        values.put("stock",stock);
        values.put("purprice",purprice);
        values.put("delprice",delprice);
        values.put("remarks",remarks);
        return db.insert("goods",null,values);
    }
    //quy
    public Cursor quy(){
        String[] res = {"_id","goodsname","categoryid","bar","stock","purprice","delprice","remarks"};
        return db.query("goods",res,null,null,null,null,null);
    }
    public int delete(int _id){
        //按条件删除指定表中的数据，返回受影响的行数
        return db.delete("goods","_id=?",new String[]{_id+""});
    }
    public Cursor quyGood(String goodname){
        String[] res = {"_id","goodsname","categoryid","bar","stock","purprice","delprice","remarks"};
        return db.query("goods",res,"goodsname=?",new String[]{goodname},null,null,null);
    }
    public void close(){
        db.close();
    }
}
