package com.zt.lanou.minichat.activity;

import android.app.Application;
import android.content.Context;

/**
 * Created by zt on 2016/4/16.
 */
public class MyApplication extends Application{

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext(){
        return context;
    }



}
