package com.smartshop.danyanpi.smartshop.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int mVersion = 1;
    private static final String nSrtDbName = "SmartShop.db";
    public DatabaseHelper(Context context)
    {
        super(context, nSrtDbName,null, mVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO 创建数据库后，对数据库的操作
        db.execSQL("CREATE TABLE category (_id integer primary key autoIncrement,categoryname TEXT(10) NOT NULL);");
        db.execSQL("CREATE TABLE goods (_id integer primary key autoIncrement,goodsname TEXT(255) NOT NULL,categoryid INTEGER(11) NOT NULL,bar INTEGER(20),stock INTEGER(11) NOT NULL,purprice INTEGER(11,2) NOT NULL,delprice INTEGER(11,2) NOT NULL,remarks TEXT(255));");
        db.execSQL("CREATE TABLE user (_id integer primary key autoIncrement,username TEXT(10) NOT NULL,password TEXT(32) NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO 更改数据库版本的操作
        db.execSQL("DROP TABLE IF EXISTS category");
        db.execSQL("DROP TABLE IF EXISTS goods");
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        // TODO 每次成功打开数据库后首先被执行
    }
}