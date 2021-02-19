package com.smartshop.danyanpi.smartshop.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.smartshop.danyanpi.smartshop.db.DatabaseHelper;


public class UserDao {
    private SQLiteDatabase db;
    public UserDao(Context context){
        super();
        db = new DatabaseHelper(context).getWritableDatabase();
    }
    //add
    public long add(String username,String password){
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        return db.insert("user",null,values);
    }
    //del
    public int del(String username){
        String[] whereArgs = {username};
        return db.delete("user","username=?",whereArgs);
    }
    //up
    public int upd(String username,String password){
        ContentValues values = new ContentValues();
        values.put("username",username);
        values.put("password",password);
        String[] whereArgs = {username};
        return db.update("user",values,"username=?",whereArgs);

    }
    //quy
    public Cursor quy(){
        String[] res = {"_id","username","password"};
        return db.query("user",res,null,null,null,null,null);
    }

    public Cursor quyPassword(String username){
        String[] res = {"_id","username","password"};
        return db.query("user",res,"username=?",new String[]{username},null,null,null);
    }
    public void close(){
        db.close();
    }
}
