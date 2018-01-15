package com.wz.pack;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;


public class BaseApplication extends Application {



    @Override
    public void onCreate() {
        super.onCreate();
        initLeakCanary();
    }

    //检测activity 的gc
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }


}
