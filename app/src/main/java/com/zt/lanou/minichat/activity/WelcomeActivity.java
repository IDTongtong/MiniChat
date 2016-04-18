package com.zt.lanou.minichat.activity;

import com.zt.lanou.minichat.R;
import com.zt.lanou.minichat.activity.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zt on 2016/4/16.
 */
public class WelcomeActivity extends BaseActivity{


    private Timer timer;

    @Override
    protected int setContent() {
        return  R.layout.activity_welcome;
    }


    @Override
    protected void initView() {

         timer =new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        };
        timer.schedule(task,2000);


    }

    @Override
    protected void initData() {

    }
}
