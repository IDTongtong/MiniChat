package com.zt.lanou.minichat.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;

/**
 * Created by zt on 2016/4/16.
 */
public abstract class BaseActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //实现无标题栏同时去掉系统的任务栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(setContent());
        ButterKnife.inject(this);

        initView();
        initData();
    }

    protected abstract int setContent();

    /**
     * 绑定视图
     */
    protected abstract void initView();

    /**
     * 加载数据
     */
    protected abstract void initData();

    /**
     * 跳转到下个activity
     *
     * @param clazz
     * @param finish
     */
    public void gotoActivity(Class<? extends Activity> clazz, boolean finish) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        if (finish) {
            finish();
        }
    }

    /**
     * 传值跳转
     *
     * @param clazz
     * @param finish
     * @param bundle
     */
    public void gotoActivity(Class<? extends Activity> clazz, boolean finish, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null)
            intent.putExtras(bundle);
        startActivity(intent);
        if (finish) {
            finish();
        }
    }

    /**
     *界面跳转和服务的启动都会用到Intent，现在介绍Intent Flag是关于Activity的跳转
     * 　　Intent intent = new Intent(this,xxx.class);
     * 　　如果activity在task存在，拿到最顶端,不会启动新的Activity
     * 　　intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
     * 　  如果activity在task存在，将Activity之上的所有Activity结束掉
     * 　　intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
     * 　　默认的跳转类型,将Activity放到一个新的Task中
     * 　　intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     * 　　如果Activity已经运行到了Task，再次跳转不会在运行这个Activity
     * 　　intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
     *
     * @param clazz
     * @param flags
     * @param finish
     * @param bundle
     */
    public void gotoActivity(Class<? extends Activity> clazz, int flags, boolean finish, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (bundle != null) intent.putExtras(bundle);
        intent.addFlags(flags);
        startActivity(intent);
        if (finish) {
            finish();
        }
    }

}
