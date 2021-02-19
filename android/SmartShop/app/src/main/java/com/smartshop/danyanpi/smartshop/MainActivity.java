package com.smartshop.danyanpi.smartshop;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.orhanobut.logger.Logger;
import com.smartshop.danyanpi.smartshop.activities.addgood.Dataanalysis;
import com.smartshop.danyanpi.smartshop.activities.stock.StockActivity;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OnChartValueSelectedListener,View.OnClickListener{

    WebView wvTask;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onResume() {
        super.onResume();
        wvTask.onResume();
        wvTask.getSettings().setJavaScriptEnabled(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        PermissionGen.with(MainActivity.this)
                .addRequestCode(100)
                .permissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.INTERNET,
                        Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS)
                .request();
        //非wifi情况下，主动下载x5内核
        QbSdk.setDownloadWithoutWifi(true);
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
            }

            @Override
            public void onCoreInitFinished() {

            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
        wvTask = findViewById(R.id.forum_context);
        wvTask.getSettings().setSupportZoom(false); //支持缩放，默认为true。是下面那个的前提。
        wvTask.getSettings().setBuiltInZoomControls(false); //设置内置的缩放控件。若为false，则该WebView不可缩放
        wvTask.getSettings().setDisplayZoomControls(true); //隐藏原生的缩放控件
        wvTask.getSettings().setBlockNetworkImage(false);//解决图片不显示
        wvTask.getSettings().setLoadsImagesAutomatically(true); //支持自动加载图片
        wvTask.getSettings().setDefaultTextEncodingName("utf-8");//设置编码格式

        String url="https://www.schoowall.com/SmartShopweb/index.html";
        wvTask.loadUrl(url);
        Logger.d("监控界面加载的url为: " + url);

        //该界面打开更多链接
        wvTask.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                webView.loadUrl(s);
                return true;
            }
        });


    }
    @Override
    public void onPause() {
        super.onPause();
        wvTask.onPause();
        wvTask.getSettings().setLightTouchEnabled(false);
    }
    //销毁 放置内存泄漏
    @Override
    public void onDestroy() {
        if (this.wvTask != null) {
            wvTask.destroy();
        }
        super.onDestroy();
    }
    @PermissionSuccess(requestCode = 100)
    public void doSomething(){
        Toast.makeText(this, "Contact permission is granted", Toast.LENGTH_SHORT).show();
    }
    @PermissionFail(requestCode = 100)
    public void doFailSomething(){
        Toast.makeText(this, "Contact permission is not granted", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent = new Intent();
        if (id == R.id.nav_stock) {
            intent.setClass(this, StockActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_data) {
            intent.setClass(this, Dataanalysis.class);
            startActivity(intent);
        } else if (id == R.id.nav_tool) {
            intent.setClass(this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

    @Override
    public void onClick(View v) {

    }
}
