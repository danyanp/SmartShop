package com.smartshop.danyanpi.smartshop.activities.stock;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorTreeAdapter;
import android.widget.TextView;

import com.smartshop.danyanpi.smartshop.R;

public class DBAdapter extends CursorTreeAdapter {
    /**
     *
     * @param cursor 组的游标
     * @param context
     */
    DBHelp dbHelp;
    public DBAdapter(Cursor cursor, Context context) {
        super(cursor, context);
        dbHelp = new DBHelp(context);
    }

    //获取商品的游标
    @Override
    protected Cursor getChildrenCursor(Cursor cursor) {
        return dbHelp.selectGoods(cursor.getString(cursor.getColumnIndex("_id")));
    }
    //创建组（分类）的视图
    @Override
    protected View newGroupView(Context context, Cursor cursor, boolean b, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.group_layout,null);
        return view;
    }
    //绑定组（分类）的视图
    @Override
    protected void bindGroupView(View view, Context context, Cursor cursor, boolean b) {
        TextView textView = view.findViewById(R.id.group_txt);
        textView.setText(cursor.getString(cursor.getColumnIndex("categoryname")));
    }
    //创建字条目（商品）的视图
    @Override
    protected View newChildView(Context context, Cursor cursor, boolean b, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_layout,null);
    }
    //绑定字条目（商品）的视图
    @Override
    protected void bindChildView(View view, Context context, Cursor cursor, boolean b) {
        TextView item_name = view.findViewById(R.id.item_name);
        TextView item_stock = view.findViewById(R.id.item_stock);
        TextView item_purprice = view.findViewById(R.id.item_purprice);
        TextView item_delprice = view.findViewById(R.id.item_delprice);
        item_name.setText(cursor.getString(cursor.getColumnIndex("goodsname")));
        item_stock.setText(cursor.getString(cursor.getColumnIndex("stock")));
        item_purprice.setText(cursor.getString(cursor.getColumnIndex("purprice")));
        item_delprice.setText(cursor.getString(cursor.getColumnIndex("delprice")));
    }

}
