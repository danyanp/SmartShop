package com.smartshop.danyanpi.smartshop.activities.stock;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.smartshop.danyanpi.smartshop.db.DatabaseHelper;

import static android.support.constraint.Constraints.TAG;

public class DBHelp {
    private DatabaseHelper databaseHelper;
    public DBHelp(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    //向组视图添加数据
    public void insertCategory(String categoryame) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("categoryame",categoryame);
        sqLiteDatabase.insert("category", null, values);
    }

    //向字条目添加数据
    public void insertgoods(String goodsname, int categoryid, int bar, int stock, double purprice, double delprice, String remarks) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("goodsname",goodsname);
        values.put("categoryid",categoryid);
        values.put("bar",bar);
        values.put("stock",stock);
        values.put("purprice",purprice);
        values.put("delprice",delprice);
        values.put("remarks",remarks);
        sqLiteDatabase.insert("goods",null,values);
    }

    //查询组数据
    public Cursor selectCategory() {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        return sqLiteDatabase.query("category", null, null,null , null, null, null);

    }

    //查询商品数据
    public Cursor selectGoods(String categoryid) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        return sqLiteDatabase.query("goods", null, "categoryid=?", new String[]{categoryid}, null, null, null);
    }
    //删除商品数据
    public int delGoods(String _id){
        String[] whereArgs = {_id};
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        return sqLiteDatabase.delete("good","_id=?",whereArgs);
    }
}
