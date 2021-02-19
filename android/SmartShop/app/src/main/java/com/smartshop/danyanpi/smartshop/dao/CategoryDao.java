package com.smartshop.danyanpi.smartshop.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.smartshop.danyanpi.smartshop.db.DatabaseHelper;
//增add，删del，改upd，查quy，
public class CategoryDao {
    private SQLiteDatabase db;
    public CategoryDao(Context context){
        super();
        db = new DatabaseHelper(context).getWritableDatabase();
    }
    //add
    public long add(String categoryname){
        ContentValues values = new ContentValues();
        values.put("categoryname",categoryname);
        return db.insert("category",null,values);
    }
    //quy
    public Cursor quy(){
        String[] res = {"_id","categoryname"};
        return db.query("category",res,null,null,null,null,null);
    }
    public void close(){
        db.close();
    }
}
