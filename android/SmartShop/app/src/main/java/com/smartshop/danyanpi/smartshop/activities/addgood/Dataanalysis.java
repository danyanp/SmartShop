package com.smartshop.danyanpi.smartshop.activities.addgood;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.smartshop.danyanpi.smartshop.MainActivity;
import com.smartshop.danyanpi.smartshop.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Dataanalysis extends AppCompatActivity {
    private PieChart mPieChart;
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_analysis);
        listView = findViewById(R.id.goodsellout);

        ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        HashMap<String, Object> map0 = new HashMap<String, Object>();
        map0.put("goodsname","商品名");
        map0.put("delprice", "卖价");
        map0.put("stock", "昨日销量");
        list.add(map0);


        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("goodsname","巧乐兹");
        map1.put("delprice", "4元");
        map1.put("stock", "30");
        list.add(map1);

        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("goodsname","可乐");
        map2.put("delprice", "3元");
        map2.put("stock", "70");
        list.add(map2);


        String [] from = {"goodsname","delprice","stock"};
        int [] to = {R.id.item_name,R.id.item_delprice,R.id.item_stock};

        //创建适配器对象

        //context,  上下文
        //data, 使用的数据
        //resource, 使用的布局文件
        //from, 集合键值的数组集
        //to 与键值对应的位置
        SimpleAdapter adapter = new SimpleAdapter(Dataanalysis.this, list, R.layout.item_layout, from, to);

        listView.setAdapter(adapter);
        mPieChart = findViewById(R.id.pic_chart);
        mPieChart.setCenterText("昨日收入");
        mPieChart.getDescription().setEnabled(false);
        List<PieEntry> strings = new ArrayList<>();
        strings.add(new PieEntry(30f,"雪糕"));
        strings.add(new PieEntry(70f,"饮料"));

        PieDataSet dataSet = new PieDataSet(strings,"商品分类");

        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(getResources().getColor(R.color.colorPrimary));
        dataSet.setColors(colors);

        PieData pieData = new PieData(dataSet);
        pieData.setDrawValues(true);

        mPieChart.setData(pieData);
        mPieChart.invalidate();
    }
}
