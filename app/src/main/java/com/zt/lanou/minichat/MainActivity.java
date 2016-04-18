package com.zt.lanou.minichat;

import android.content.Intent;
import android.widget.TabHost;

import com.zt.lanou.minichat.activity.WelcomeActivity;
import com.zt.lanou.minichat.activity.base.BaseActivity;

import butterknife.InjectView;


public class MainActivity extends BaseActivity {

    @InjectView(android.R.id.tabhost)
    TabHost tabhost;

    private boolean flag = true;

    @Override
    protected int setContent() {
        return R.layout.activity_main;

    }

    @Override
    protected void initView() {
        if (flag) {
            flag = false;
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);

        }
        //重置布局
        tabhost.setup();
        /**
         *  TabSpec tabNews = tabHost.newTabSpec("news");
         View viewNews = getLayoutInflater().inflate(R.layout.tabs_news, null);
         tabNews.setIndicator(viewNews);
         tabNews.setContent(R.id.main_news);
         tabHost.addTab(tabNews);
         */

    }

    @Override
    protected void initData() {

    }


}
