package com.example.hotfix.core;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * @author andysong
 * @data 2019-06-03
 * @discription xxx
 */
public class MyApp extends Application {

    private static final String TAG = "Tinker.SampleApppatch";



    @Override
    public void onCreate() {
        super.onCreate();
        initTinkerPatch();
    }

    private void initTinkerPatch() {

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
